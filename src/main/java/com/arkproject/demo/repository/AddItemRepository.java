package com.arkproject.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arkproject.demo.model.AddItem;

@Repository
public interface AddItemRepository extends JpaRepository<AddItem, Integer> {
	
}
