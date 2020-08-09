package org.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/xyz")
public class MyController {
	
	@RequestMapping(value="/mnop", method=RequestMethod.GET, produces="text/html")
	public String test(
			@RequestParam (name="myname") String mname			
			)
	{
		System.out.println("In java  "+mname);
		return "Hi Hello Welcome to SpringBoot Mr."+mname;
	}

}
