package com.geekster.RestaurantManagement.Service.App.dto;


import com.geekster.RestaurantManagement.Service.App.model.RoleType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpInput {
    private String username;
    private String userEmail;
    private String userPassword;
    @Enumerated(EnumType.STRING)
    private RoleType roleType;
}
