package com.shobhit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/database")
public class DBController {

	@Autowired
	private DBService dbService;

	@GetMapping("/result1")
	public String resultDB1() {
		return dbService.resultDB1();
	}

	@GetMapping("/result2")
	public String resultDB2() {
		return dbService.resultDB2();
	}
}