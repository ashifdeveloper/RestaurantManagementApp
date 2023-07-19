package com.geekster.RestaurantManagement.Service.App.service;


import com.geekster.RestaurantManagement.Service.App.model.AuthenticationToken;
import com.geekster.RestaurantManagement.Service.App.model.FoodOrder;
import com.geekster.RestaurantManagement.Service.App.model.FoodStatus;
import com.geekster.RestaurantManagement.Service.App.repository.IAuthenticationTokenRepository;
import com.geekster.RestaurantManagement.Service.App.repository.IFoodOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodOrderService {
    @Autowired
    IFoodOrderRepository iFoodOrderRepository;

    @Autowired
    IAuthenticationTokenRepository iAuthenticationTokenRepository;

    public void placeFoodOrder(FoodOrder foodOrder, String token) {
        AuthenticationToken authToken = iAuthenticationTokenRepository.findFirstByToken(token);
        foodOrder.setFoodStatus(FoodStatus.Created);
        foodOrder.setUserId(authToken.getUser());
        iFoodOrderRepository.save(foodOrder);



    }

    public List<FoodOrder> getAllOrderFood() {
        return iFoodOrderRepository.findAll();
    }
}
