package com.geekster.RestaurantManagement.Service.App.controller;

import com.geekster.RestaurantManagement.Service.App.model.FoodItem;
import com.geekster.RestaurantManagement.Service.App.model.RoleType;
import com.geekster.RestaurantManagement.Service.App.service.AuthenticationTokenService;
import com.geekster.RestaurantManagement.Service.App.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foodItem")
public class FoodItemController {
    @Autowired
    FoodItemService foodItemService;

    @Autowired
    AuthenticationTokenService authenticationTokenService;

    //addFood
    @PostMapping()
    public String addFoodItem(@RequestParam String userEmail , @RequestParam String token , @RequestBody FoodItem foodItem, @RequestParam RoleType type){
        if(authenticationTokenService.authenticate(userEmail , token,type)){
            foodItemService.addFoodItem(foodItem , token);
            return " New FoodItem has been added...!!!";

        }else {
            return "sorry its not acceptable because only admin can add food";

        }

    }

    //getAllFoodItem
    @GetMapping()
    public List<FoodItem> getAllFood(){
        return foodItemService.getAllFoodItem();
    }

}
