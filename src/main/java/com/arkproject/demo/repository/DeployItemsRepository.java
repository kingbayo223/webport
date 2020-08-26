package com.arkproject.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.arkproject.demo.model.AddItem;
import com.arkproject.demo.model.DeployItems;

@Repository
public interface DeployItemsRepository extends JpaRepository<DeployItems, Integer>{

	

}
