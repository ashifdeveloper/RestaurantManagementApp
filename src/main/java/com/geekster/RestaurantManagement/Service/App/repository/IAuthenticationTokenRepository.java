package com.geekster.RestaurantManagement.Service.App.repository;

import com.geekster.RestaurantManagement.Service.App.model.AuthenticationToken;
import com.geekster.RestaurantManagement.Service.App.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAuthenticationTokenRepository extends JpaRepository<AuthenticationToken, Long> {
    AuthenticationToken findByUser(User user);

    AuthenticationToken findFirstByToken(String token);
}
