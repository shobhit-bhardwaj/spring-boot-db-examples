package com.shobhit.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.shobhit.entity.Author;
import com.shobhit.entity.AuthorStatistic;

@Repository
public interface AuthorDao extends BaseDao<Author, Integer> {

	public Optional<Author> findByAuthorEmailId(String emailId);

	public List<AuthorStatistic> getAuthorStatistics();

	public List<Author> getAuthors();
}