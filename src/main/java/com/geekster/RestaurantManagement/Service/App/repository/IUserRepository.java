package com.geekster.RestaurantManagement.Service.App.repository;

import com.geekster.RestaurantManagement.Service.App.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    User findFirstByUserEmail(String userEmail);
}
