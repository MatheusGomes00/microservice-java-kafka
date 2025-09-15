package com.pb.challangeThree.msUser.web.controller;

import com.pb.challangeThree.msUser.service.UserService;
import com.pb.challangeThree.msUser.web.dto.ResponseUserDto;
import com.pb.challangeThree.msUser.web.dto.UpdateUserDto;
import com.pb.challangeThree.msUser.web.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ResponseUserDto> create(@RequestBody UserDto userDto){
        ResponseUserDto createdUser = userService.createUser(userDto);
        return ResponseEntity.ok().body(createdUser);
    }

    @PutMapping("/update")
    public ResponseEntity<HttpStatus> updatePassword(@RequestBody UpdateUserDto userDto){
        userService.updatePassword(userDto);
        return ResponseEntity.status(204).build();
    }


}
