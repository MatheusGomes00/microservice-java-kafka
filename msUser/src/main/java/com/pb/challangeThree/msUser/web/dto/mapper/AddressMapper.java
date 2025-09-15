package com.pb.challangeThree.msUser.web.dto.mapper;

import com.pb.challangeThree.msUser.entity.Address;
import com.pb.challangeThree.msUser.web.dto.AddressDto;
import org.modelmapper.ModelMapper;

public class AddressMapper {

    public static Address toAddress(AddressDto addressDto) {
        return new ModelMapper().map(addressDto, Address.class);
    }

}
