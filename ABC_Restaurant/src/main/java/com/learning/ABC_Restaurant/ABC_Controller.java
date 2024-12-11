package com.learning.ABC_Restaurant;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learning.ABC_Restaurant.model.ItemPost;
import com.learning.ABC_Restaurant.service.ABCService;

@Controller
public class ABC_Controller {

	@Autowired
	private ABCService service;
	
	@RequestMapping({"/","/home"})
	public String home() {
		return "home";
	}
	
	@RequestMapping("/additem")
	public String addItem() {
		return "additem";
	}
	
	@GetMapping("/viewallitems")
	public String viewItems(Model model) {

		List<ItemPost> itemPost = service.returnAllItemPosts();
		model.addAttribute("itemPosts", itemPosts);
		return "viewallitems";
	}
	
	@PostMapping("/handleForm")
	public String handleAddItemForm(ItemPost itemPost,Model model) {
		model.addAttribute("itemPost", itemPost);
		service.addItemPost(itemPost);
		//System.out.println(jobPost);
		  return "success";
		
	}

}


/*
 * ......................
 * 
 * package com.telusko.JobApp.controller;
 * 
 * 
 * public class JobController {
 * 
 * @Autowired private JobService service;
 * 
 * // ************************************************************************
 * 
 * @RequestMapping({"/","/home"}) public String home() { return "home"; }
 * 
 * // ************************************************************************
 * 
 * @RequestMapping("/addjob") public String addJob() { return "addjob"; }
 * 
 * // ************************************************************************
 * 
 * // controller method for getting all job posts
 * 
 * @GetMapping("/viewalljobs") public String viewJobs(Model model) {
 * 
 * List<JobPost> jobPosts = service.returnAllJobPosts();
 * model.addAttribute("jobPosts", jobPosts); return "viewalljobs"; }
 * 
 * // ************************************************************************
 * 
 * @PostMapping("/handleForm") public String handleAddJobForm(JobPost
 * jobPost,Model model) { model.addAttribute("jobPost", jobPost);
 * service.addJobPost(jobPost); //System.out.println(jobPost); return "success";
 * 
 * }
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * }
 */