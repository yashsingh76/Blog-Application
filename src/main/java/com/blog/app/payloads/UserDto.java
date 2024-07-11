package com.blog.app.payloads;

import java.util.HashSet;
import java.util.Set;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	
    
	private int id;
	
	@NotEmpty
	private String name;
	
	@Email
	private String email;
	
	@NotEmpty
	@Size(min=4,max = 6,message = "password should be of minimum 4 characters and maximum 6 characters")
	private String password;
	
	@NotEmpty
	
	private String about;
	
	private Set<RoleDto> roles = new HashSet<>();

}
