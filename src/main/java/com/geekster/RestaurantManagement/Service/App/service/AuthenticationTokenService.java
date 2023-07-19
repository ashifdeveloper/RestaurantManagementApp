package com.geekster.RestaurantManagement.Service.App.service;


import com.geekster.RestaurantManagement.Service.App.model.AuthenticationToken;
import com.geekster.RestaurantManagement.Service.App.model.RoleType;
import com.geekster.RestaurantManagement.Service.App.model.User;
import com.geekster.RestaurantManagement.Service.App.repository.IAuthenticationTokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationTokenService {
    @Autowired
    IAuthenticationTokenRepository iAuthenticationTokenRepository;

    public void saveToken(AuthenticationToken token) {
        iAuthenticationTokenRepository.save(token);
    }

    public AuthenticationToken getToken(User user) {
        return  iAuthenticationTokenRepository.findByUser(user);
    }

    public boolean authenticate(String userEmail, String token, RoleType type) {
        if(token == null && userEmail == null)return false;
        AuthenticationToken authToken = iAuthenticationTokenRepository.findFirstByToken(token);
        if(authToken == null)return false;
        String validEmail = authToken.getUser().getUserEmail();
        RoleType validType = authToken.getUser().getRoleType();
        return validEmail.equals(userEmail) && validType.equals(type);
    }
}
