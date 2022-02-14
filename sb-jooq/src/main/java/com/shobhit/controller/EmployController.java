package com.shobhit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jooq.sample.model.tables.pojos.Employ;
import com.shobhit.service.EmployService;

@RestController
@RequestMapping ("/employ")
public class EmployController {

	@Autowired
	private EmployService employService;

	@PostMapping
	public void saveEmploy(@RequestBody Employ employ) {
		employService.saveEmploy(employ);
	}

	@GetMapping
	public List<Employ> getEmploys() {
		return employService.getEmploys();
	}
}