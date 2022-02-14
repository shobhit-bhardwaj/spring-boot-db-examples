package com.shobhit.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shobhit.entity.Author;
import com.shobhit.entity.AuthorStatistic;
import com.shobhit.entity.Book;
import com.shobhit.service.AuthorService;

@RestController
@RequestMapping (value = "/author")
public class AuthorController {

	@Autowired
	private AuthorService authorService;

	@PostMapping
	public List<Author> saveAuthor(@RequestBody List<Author> authors) {
		return authorService.saveAuthors(authors);
	}

	@GetMapping ("/jpa")
	public List<Author> getAuthorsByJPARepository() {
		return authorService.getAuthorsByJPARepository();
	}

	@GetMapping ("/{emailId}")
	public Optional<Author> findByAuthorEmailId(@PathVariable String emailId) {
		return authorService.findByAuthorEmailId(emailId);
	}

	@GetMapping ("/statistics")
	public List<AuthorStatistic> getAuthorStatistics() {
		return authorService.getAuthorStatistics();
	}

	@GetMapping ("/querydsl")
	public List<Author> getAuthorsByQueryDSL() {
		return authorService.getAuthorsByQueryDSL();
	}

	@GetMapping ("/books")
	public List<Book> getBooks() {
		return authorService.getBooks();
	}
}