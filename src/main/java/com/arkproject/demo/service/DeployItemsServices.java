package com.arkproject.demo.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arkproject.demo.model.DeployItems;
import com.arkproject.demo.repository.DeployItemsRepository;

@Service
public class DeployItemsServices {
	
	@Autowired
	private DeployItemsRepository repo;
	
	 public List<DeployItems> listAll() {
	        return repo.findAll();
	    }
	     
	    public void save(DeployItems ad) {
	        repo.save(ad);
	    }
	     
	    public DeployItems get(int id) {
	        return repo.findById(id).get();
	    }
	     
	    public void delete(int id) {
	        repo.deleteById(id);
	    }

		public boolean createPdf(String string, Object context, HttpServletRequest request,
				HttpServletResponse response) {
			// TODO Auto-generated method stub
			return false;
		}
	    
		

}
