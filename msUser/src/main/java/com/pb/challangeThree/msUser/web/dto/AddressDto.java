package com.pb.challangeThree.msUser.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;
}
