package com.pb.challangeThree.msUser.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseAddressDto {

    private String zipCode;
    private String street;
    private String district;
    private String city;
    private String state;
}
