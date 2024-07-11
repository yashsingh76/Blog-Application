package com.blog.app.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
	
	private Integer categoryId;
	@NotEmpty
	@Size(min = 10,message = "minimum 10 words required")
	private String categoryTitle;
	
	@NotEmpty
	@Size(min = 50,message = "minimum 50 words for the description")
	private String categoryDescription;

}
