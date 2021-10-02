package com.thbs.dhandhan.controller.request;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TermedAccountRequest {
    Integer accountId;
Integer customerId;
    Float amount;
    Integer months;
}
