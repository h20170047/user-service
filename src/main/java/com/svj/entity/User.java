package com.svj.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank
    // TODO- Validate paymentMethods from the ones provided in app.yml
    private String paymentMethod;
//    @SourceAccountValidation
    // TODO- Check if method is other than COD from app.yml, it should have a non-blank entry
    private String srcAccount;
    @PositiveOrZero
    private double availableAmount;
}
