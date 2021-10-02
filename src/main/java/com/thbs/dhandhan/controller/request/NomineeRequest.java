package com.thbs.dhandhan.controller.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NomineeRequest {
    Integer accountId;
    String name;
    String phoneNumber;
    String govId;
    String govIdType;
}
