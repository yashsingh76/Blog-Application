package com.blog.app.payloads;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.blog.app.entities.Category;
import com.blog.app.entities.Comment;
import com.blog.app.entities.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
	
	
	private String title;
	
	private String content;
	
	private String imageName;
	
	private Date addeDate;
	
	private CategoryDto category;
	
	private UserDto user;
	
	private Set<CommentDto> comments = new HashSet<>();

}
