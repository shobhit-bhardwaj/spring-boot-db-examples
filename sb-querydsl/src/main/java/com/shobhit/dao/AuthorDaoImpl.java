package com.shobhit.dao;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import com.querydsl.core.types.Projections;
import com.shobhit.entity.Author;
import com.shobhit.entity.AuthorStatistic;

public class AuthorDaoImpl extends BaseDaoImpl<Author, Integer> implements AuthorDao {

	public AuthorDaoImpl(EntityManager entityManager) {
		super(Author.class, entityManager);
	}

	@Override
	public Optional<Author> findByAuthorEmailId(String emailId) {
		return Optional.ofNullable(
				jpaQueryFactory
				.from(author)
				.where(author.authorEmailId.equalsIgnoreCase(emailId))
				.select(author)
				.fetchFirst()
		);
	}

	@Override
	public List<AuthorStatistic> getAuthorStatistics() {
		return jpaQueryFactory
				.from(author)
				.innerJoin(author.books, book)
				.groupBy(author.authorName)
				.select(Projections.constructor(AuthorStatistic.class, author.authorName, book.count().intValue()))
				.fetch();
	}

	@Override
	public List<Author> getAuthors() {
		return jpaQueryFactory
				.from(author)
				.distinct()
				.innerJoin(author.books, book)
				.select(author)
				.fetchJoin().fetch();
	}
}