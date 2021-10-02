package com.thbs.dhandhan.controller.request;


import com.thbs.dhandhan.utils.TransactionType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionRequest {
    Integer accountId;
    TransactionType type;
    String toAccountId;
    Float amount;

    @Override
    public String toString() {
        return "TransactionRequest{" +
                "accountId=" + accountId +
                ", type=" + type +
                ", toAccountId='" + toAccountId + '\'' +
                ", amount=" + amount +
                '}';
    }
}
