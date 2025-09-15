package com.pb.challangeThree.msUser.feign;

import com.pb.challangeThree.msUser.web.dto.AddressDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name= "viacep", url = "https://viacep.com.br/ws/")
public interface FeignClientSource {

    @RequestMapping(method = RequestMethod.GET, value = "{cep}/json")
    AddressDto findAddressByCep(@PathVariable("cep") String cep);
}
