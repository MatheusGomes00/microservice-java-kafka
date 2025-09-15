package com.pb.challangeThree.msUser.web.dto.mapper;

import com.pb.challangeThree.msUser.entity.User;
import com.pb.challangeThree.msUser.web.dto.ResponseUserDto;
import com.pb.challangeThree.msUser.web.dto.UserDto;
import org.modelmapper.ModelMapper;

public class UserMapper {

    public static User toUser(UserDto userDto) {
        return new ModelMapper().map(userDto, User.class);
    }

    public static ResponseUserDto toDto(User user) {
        return new ModelMapper().map(user, ResponseUserDto.class);
    }

}
