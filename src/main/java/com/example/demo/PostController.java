package com.example.demo;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/posts")

public class PostController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping
	public List<Post> getPosts(){
		ResponseEntity<Post[]> responseEntity = restTemplate.getForEntity("https://jsonplaceholder.typicode.com/posts", Post[].class);
		List<Post> posts = Arrays.asList(responseEntity.getBody());
		return posts;
	}
	
	@GetMapping("/longest-title")
	public Post getPostWithLongestTitle() {
		List<Post> posts = getPosts();
		Post postWithLongestTitle = null;
		int maxLength = 0;
		for (Post post : posts) {
			int length = post.getTitle().length();
			if (length > maxLength) {
				maxLength = length;
				postWithLongestTitle = post;
			}
		}
		System.out.println("The Longest title: " + postWithLongestTitle.getTitle());
		System.out.println("Body: " + postWithLongestTitle.getBody());
		return postWithLongestTitle;
	}
	
	
	@GetMapping("/formatted")
	public String getFormattedPosts() {
		List<Post> posts = getPosts();
		StringBuilder sb = new StringBuilder();
		
		for (Post post : posts) {
			Map<String, Object> map = new LinkedHashMap<>();
			map.put("id", post.getId());
			map.put("userId", post.getUserId());
			map.put("title", post.getTitle());
            map.put("body", post.getBody());
            map.put("titleLength", post.getTitle().length());
            sb.append(map.toString()).append("\n");
		}
		return sb.toString();
	}

}


