 package com.arkproject.demo.service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arkproject.demo.model.AddItem;

import com.arkproject.demo.repository.AddItemRepository;
import com.sun.xml.txw2.Document;

@Service
public class AddItemService {
	
	@Autowired
	private AddItemRepository repo;
	
	 public List<AddItem> listAll() {
	        return repo.findAll();
	    }
	     
	    public void save(AddItem add) {
	        repo.save(add);
	    }
	     
	    public AddItem get(int id) {
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
	   
