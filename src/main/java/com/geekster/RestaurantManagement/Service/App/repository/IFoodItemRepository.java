package com.geekster.RestaurantManagement.Service.App.repository;


import com.geekster.RestaurantManagement.Service.App.model.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFoodItemRepository extends JpaRepository<FoodItem,Long> {
}
