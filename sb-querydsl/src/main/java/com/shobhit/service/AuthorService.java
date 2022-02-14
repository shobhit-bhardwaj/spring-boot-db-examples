package com.shobhit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shobhit.dao.AuthorDao;
import com.shobhit.dao.BookDao;
import com.shobhit.entity.Author;
import com.shobhit.entity.AuthorStatistic;
import com.shobhit.entity.Book;

@Service
public class AuthorService {

	@Autowired
	private AuthorDao authorDao;

	@Autowired
	private BookDao bookDao;

	public List<Author> saveAuthors(List<Author> authors) {
		return authorDao.saveAll(authors);
	}

	//	Will have N+1 problem in Hibernate/JPA
	public List<Author> getAuthorsByJPARepository() {
		return authorDao.findAll();
	}

	public Optional<Author> findByAuthorEmailId(String emailId) {
		return authorDao.findByAuthorEmailId(emailId);
	}

	public List<AuthorStatistic> getAuthorStatistics() {
		return authorDao.getAuthorStatistics();
	}

	//	To avoid N+1 problem in Hibernate/JPA
	public List<Author> getAuthorsByQueryDSL() {
		return authorDao.getAuthors();
	}

	public List<Book> getBooks() {
		return bookDao.findAll();
	}
}