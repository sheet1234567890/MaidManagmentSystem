package com.adda.app.CustomException;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor

public class CustomMsg {

	
	private String Date;
	private Integer Code;
	private String status;
	private String msg;
}
