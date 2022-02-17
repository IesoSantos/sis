/**
 * 
 */
package com.metro.bagregister.controller;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Anderson dos Reis Santos
 *
 */

public class Response<T> {
	
	private @Getter @Setter T data;
	private @Setter List<String> errors;

	public List<String> getErrors(){
		if(this.errors==null)
			this.errors= new ArrayList<String>();
		return this.errors;
	}
	
}
