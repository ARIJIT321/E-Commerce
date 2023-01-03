package com.shop.Model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import lombok.Data;

@Data
public class Login {

	@Size(min = 3, max = 20, message = "UserName Should be of 3 to 20 Characters.")
	private String Email;
	
	@NotEmpty(message = "Password Should not be Empty")
	@NotBlank(message=  "password Should not be Blank")
	@NotNull(message = "Password Should Not be Null")
	private String password;
}
