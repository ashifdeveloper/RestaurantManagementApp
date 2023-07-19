package com.geekster.RestaurantManagement.Service.App.repository;

import com.geekster.RestaurantManagement.Service.App.model.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IFoodOrderRepository extends JpaRepository<FoodOrder, Long> {
}
