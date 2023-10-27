package com.svj.entity;

import com.svj.Validation.PaymentValidation;
import jakarta.persistence.*;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USER_INFORMATION")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
