package com.pb.challangeThree.msUser.service;


import com.pb.challangeThree.msUser.entity.Address;
import com.pb.challangeThree.msUser.entity.User;
import com.pb.challangeThree.msUser.exception.EntityNotFoundException;
import com.pb.challangeThree.msUser.exception.PasswordViolationException;
import com.pb.challangeThree.msUser.exception.UserUniqueViolationException;
import com.pb.challangeThree.msUser.feign.FeignClientSource;
import com.pb.challangeThree.msUser.record.ProcessedRequest;
import com.pb.challangeThree.msUser.repository.UserRepository;
import com.pb.challangeThree.msUser.web.dto.*;
import com.pb.challangeThree.msUser.web.dto.mapper.AddressMapper;
import com.pb.challangeThree.msUser.web.dto.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final FeignClientSource feignClientSource;
    private final ProducerMessage producerMessage;
    private final PasswordEncoder passwordEncoder;


    @Transactional
    public ResponseUserDto createUser(UserDto userDto) {
        Optional<User> verifyUser = userRepository.findByUsername(userDto.getUsername());
        if(verifyUser.isEmpty()){
            User user = UserMapper.toUser(userDto);

            user.setPassword(passwordEncoder.encode(userDto.getPassword()));

            AddressDto addressDto = feignClientSource.findAddressByCep(userDto.getCep());
            Address address = AddressMapper.toAddress(addressDto);
            user.setAddress(address);

            userRepository.save(user);

            ResponseUserDto userResponse = UserMapper.toDto(user);
            ResponseAddressDto responseAddressDto = convertResponse(addressDto);
            userResponse.setAddress(responseAddressDto);

            sendRequest(createRequest(userResponse.getUsername()));

            return userResponse;
        } else {
            throw new UserUniqueViolationException(String.format("Username '%s' already registered!", userDto.getUsername()));
        }
    }

    public ResponseAddressDto convertResponse(AddressDto addressDto) {
        ResponseAddressDto responseAddress = new ResponseAddressDto();
        responseAddress.setZipCode(addressDto.getCep());
        responseAddress.setStreet(addressDto.getLogradouro());
        responseAddress.setDistrict(addressDto.getBairro());
        responseAddress.setCity(addressDto.getLocalidade());
        responseAddress.setState(addressDto.getUf());
        return responseAddress;
    }

    public void updatePassword(UpdateUserDto userDto) {
        String username = userDto.getUsername();
        String oldPassword = userDto.getOldPassword();
        String newPassword = userDto.getNewPassword();

        Optional<User> user = userRepository.findByUsername(username);
        if (user.isEmpty()){
            throw new EntityNotFoundException(String.format("Username '%s' not founded!", username));
        }

        User userToUpdate = user.get();

        if (passwordEncoder.matches(oldPassword, userToUpdate.getPassword())) {
            userToUpdate.setPassword(passwordEncoder.encode(newPassword));
            userRepository.save(userToUpdate);

            sendRequest(updateRequest(userToUpdate.getUsername()));
        } else {
            throw new PasswordViolationException("Old password doesn't match!");
        }
    }

    public ProcessedRequest createRequest(String username) {
        return new ProcessedRequest(username, "CREATE");
    }

    public ProcessedRequest updateRequest(String username) {
        return new ProcessedRequest(username, "UPDATE");
    }

    @SuppressWarnings("null")
    public void sendRequest(ProcessedRequest request) {
        producerMessage.send(request);
    }

}
