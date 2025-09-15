package com.pb.challangeThree.msNotify.kafkaConsumer.message;


import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProcessedRequest implements Serializable {

    private String userName;
    private String operation;
}
