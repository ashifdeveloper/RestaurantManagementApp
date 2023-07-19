package com.geekster.RestaurantManagement.Service.App.controller;

import com.geekster.RestaurantManagement.Service.App.model.FoodOrder;
import com.geekster.RestaurantManagement.Service.App.model.RoleType;
import com.geekster.RestaurantManagement.Service.App.service.AuthenticationTokenService;
import com.geekster.RestaurantManagement.Service.App.service.FoodOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foodOrder")
public class FoodOrderController {
    @Autowired
    FoodOrderService foodOrderService;


    @Autowired
    AuthenticationTokenService authenticationTokenService;

//placeFoodOrder
    @PostMapping()
    public String placeFoodOrder(@RequestParam String userEmail , @RequestParam String token , @RequestBody FoodOrder foodOrder, @RequestParam RoleType type){
        if(authenticationTokenService.authenticate(userEmail,token,type)){
            foodOrderService.placeFoodOrder(foodOrder ,token);
            return "food has been order";

        }else {
            return "admin not allowed to order food";
        }
    }

    //getaAllFood

    @GetMapping()
    public List<FoodOrder> getAllPlacedFoodOrder(){
        return foodOrderService.getAllOrderFood();
    }
}

