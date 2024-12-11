package com.learning.ABC_Restaurant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.learning.ABC_Restaurant.model.ItemPost;
import com.learning.ABC_Restaurant.repo.ItemRepo;

@Service
public class ABCService {

	@Autowired
	public ItemRepo repo;
	
	public List<ItemPost> returnAllItemPosts() {
		return repo.returnAllItemPosts();
		
		public void addItemPost(ItemPost itemPost) {
			 repo.addItemPost(itemPost);

		
	}
	
	
}


/*
 * package com.telusko.JobApp.service;
 * 
 * import java.util.List;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.stereotype.Service;
 * 
 * import com.telusko.JobApp.model.JobPost; import
 * com.telusko.JobApp.repo.JobRepo;
 * 
 * @Service public class JobService {
 * 
 * @Autowired public JobRepo repo;
 * 
 * 
 * 
 * //method to return all JobPosts public List<JobPost> returnAllJobPosts() {
 * return repo.returnAllJobPosts();
 * 
 * 
 * }
 * 
 * 
 * 
 * 
 * 
 * //
 * ***************************************************************************
 * 
 * 
 * 
 * 
 * 
 * // method to add a jobPost public void addJobPost(JobPost jobPost) {
 * repo.addJobPost(jobPost);
 * 
 * }
 * 
 * 
 * }
 */