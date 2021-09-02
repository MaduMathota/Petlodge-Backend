package com.petlodge.caretaker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.petlodge.caretaker.entity.Food;

public interface FoodRepository extends JpaRepository<Food, String> {

}
