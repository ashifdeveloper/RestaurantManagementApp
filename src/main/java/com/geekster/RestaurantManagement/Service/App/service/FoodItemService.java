package com.geekster.RestaurantManagement.Service.App.service;


import com.geekster.RestaurantManagement.Service.App.model.AuthenticationToken;
import com.geekster.RestaurantManagement.Service.App.model.FoodItem;
import com.geekster.RestaurantManagement.Service.App.repository.IAuthenticationTokenRepository;
import com.geekster.RestaurantManagement.Service.App.repository.IFoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodItemService {
    @Autowired
    IFoodItemRepository iFoodItemRepository;

    @Autowired
    IAuthenticationTokenRepository iAuthenticationTokenRepository;

    public void addFoodItem(FoodItem foodItem, String token) {
        AuthenticationToken authToken = iAuthenticationTokenRepository.findFirstByToken(token);
        if(authToken !=null){
            iFoodItemRepository.save(foodItem);
        }

    }

    public List<FoodItem> getAllFoodItem() {
        return iFoodItemRepository.findAll();
    }
}
