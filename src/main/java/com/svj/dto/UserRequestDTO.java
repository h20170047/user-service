package com.svj.dto;

import com.svj.entity.User;
import com.svj.validation.PaymentValidation;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
//@NoArgsConstructor
public class UserRequestDTO{
    private int id;
    @NotEmpty
    private String name;
    @Email
    private String email;
    @PaymentValidation
    private String paymentMethod;
    private String srcAccount;
    @PositiveOrZero
    private double availableAmount;

    @AssertTrue(message = "Invalid source account")
    private boolean isSourceAccount() {
        return (paymentMethod == "COD" &&  srcAccount.isEmpty()) || (paymentMethod!="COD" && !srcAccount.isEmpty());
    }

}
