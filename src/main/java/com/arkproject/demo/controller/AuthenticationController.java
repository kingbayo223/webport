package com.arkproject.demo.controller;

import java.util.List;

import javax.mail.MessagingException;

import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.arkproject.demo.model.AddItem;
import com.arkproject.demo.model.DeployItems;
import com.arkproject.demo.model.User;
import com.arkproject.demo.service.AddItemService;
import com.arkproject.demo.service.DeployItemsServices;
import com.arkproject.demo.service.UserService;

@Controller
public class AuthenticationController {

	@Autowired
	UserService userService;
	
	@Autowired
	private AddItemService service;
	
	@Autowired
	private DeployItemsServices services;
	
	

	
		
	@RequestMapping(value = { "/" }, method = RequestMethod.GET)
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index"); // resources/template/login.html
		return modelAndView;
	}
	
	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login"); // resources/template/login.html
		return modelAndView;
	}
	
	
	
		
	@RequestMapping(value = { "/requestItem" }, method = RequestMethod.GET)
	public ModelAndView requestItem() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("requestItem"); // resources/template/login.html
		return modelAndView;
	}
	
	@RequestMapping(value = { "/urequest" }, method = RequestMethod.GET)
	public ModelAndView urequest() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("urequest"); // resources/template/login.html
		return modelAndView;
	}
		
	
	@RequestMapping(value = { "/edit_Item" }, method = RequestMethod.GET)
	public ModelAndView edittItem() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("edit_Item"); // resources/template/login.html
		return modelAndView;
	}
		
	
	@RequestMapping(value = { "/role" }, method = RequestMethod.GET)
	public ModelAndView editrole() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("role"); // resources/template/login.html
		return modelAndView;
	}
		
	
		
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView register() {
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("register"); // resources/template/register.html
		return modelAndView;
	}
	
	@RequestMapping(value = "/regnew", method = RequestMethod.GET)
	public ModelAndView regnew() {
		ModelAndView modelAndView = new ModelAndView();
		AddItem add = new AddItem();
		modelAndView.addObject("add", add);
		modelAndView.setViewName("regnew"); // resources/template/register.html
		return modelAndView;
	}
	
	@RequestMapping(value = "/deployItem", method = RequestMethod.GET)
	public ModelAndView deployItem() {
		ModelAndView modelAndView = new ModelAndView();
		DeployItems add = new DeployItems();
		modelAndView.addObject("add", add);
		modelAndView.setViewName("deployItem"); // resources/template/register.html
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home(Model model) {
		ModelAndView modelAndView = new ModelAndView();
		List<AddItem> listAddItem =service.listAll();
		modelAndView.addObject("listAddItem", listAddItem);
		modelAndView.setViewName("home");
		return modelAndView;
	}
	
	@RequestMapping(value = "/availableItems", method = RequestMethod.GET)
	public ModelAndView availableItems(Model model) {
		ModelAndView modelAndView = new ModelAndView();
		List<DeployItems> listDeployItems =services.listAll();
		modelAndView.addObject("listDeployItems", listDeployItems);
		modelAndView.setViewName("availableItems");
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/homes", method = RequestMethod.GET)
	public ModelAndView homes(Model model) {
		ModelAndView modelAndView = new ModelAndView();
		List<DeployItems> listDeployItems =services.listAll();
		modelAndView.addObject("listDeployItems", listDeployItems);
		modelAndView.setViewName("homes");
		return modelAndView;
	}
	
	
	
	@RequestMapping(value = "/approve", method = RequestMethod.GET)
	public ModelAndView user(Model model) {
		ModelAndView modelAndView = new ModelAndView();
		List<User> listUser =userService.listAll();
		modelAndView.addObject("listUser", listUser);
		modelAndView.setViewName("approve");
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public ModelAndView adminHome() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin"); // resources/template/admin.html
		return modelAndView;
	}

	@RequestMapping(value="/register", method=RequestMethod.POST)
	public ModelAndView registerUser(@Valid User user, BindingResult bindingResult, ModelMap modelMap) {
		ModelAndView modelAndView = new ModelAndView();
		// Check for the validations
		if(bindingResult.hasErrors()) {
			modelAndView.addObject("successMessage", "Please correct the errors in form!");
			modelMap.addAttribute("bindingResult", bindingResult);
		}
		else if(userService.isUserAlreadyPresent(user)){
			modelAndView.addObject("successMessage", "user already exists!");			
		}
		// we will save the user if, no binding errors
		else {
			userService.saveUser(user);
			modelAndView.addObject("successMessage", "User is registered successfully!");
		}
		modelAndView.addObject("user", new User());
		modelAndView.setViewName("register");
		return modelAndView;
	}
	
	 
	@RequestMapping("/editUser/{id}")
	public ModelAndView showEditUserPage(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("editUser");
	    User user = userService.get(id);
	    mav.addObject("user", user);
	     
	    return mav;
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveAddItem(@ModelAttribute("add") AddItem add) {
	    service.save(add);
	     
	    return "redirect:/home";
	
	}
	
	@RequestMapping(value = "/saved", method = RequestMethod.POST)
	public String saveDeployItems(@ModelAttribute("add") DeployItems add) {
	    services.save(add);
	     
	    return "redirect:/availableItems";
	
	}
	
		
	@RequestMapping(value = "/saveEdit", method = RequestMethod.POST)
	public String saveEdit(@ModelAttribute("add") User add) {
	    userService.saveUser(add);
	     
	    return "redirect:/approve";
	
	}
	
	
	@RequestMapping("/deleteUser/{id}")
	public String deleteUser(@PathVariable(name = "id") int id) {
	    userService.deleteUser(id);
	    return "redirect:/approve";       
	}
	
	
	
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditItemPage(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("edit_Item");
	    AddItem addItem = service.get(id);
	    mav.addObject("addItem", addItem);
	     
	    return mav;
	}
	
	@RequestMapping("/deploy/{id}")
	public ModelAndView showdeploy(@PathVariable(name = "id") int id) {
	    ModelAndView ma = new ModelAndView("deploy");
	    DeployItems deployItems = services.get(id);
	    ma.addObject("deployItems", deployItems);
	     
	    return ma;
	}

	
	@RequestMapping("/delete/{id}")
	public String deleteItem(@PathVariable(name = "id") int id) {
	    service.delete(id);
	    return "redirect:/home";       
	}
	
	@RequestMapping("/deleted/{id}")
	public String deleteItems(@PathVariable(name = "id") int id) {
	    services.delete(id);
	    return "redirect:/home";       
	}
	

	
	
}










