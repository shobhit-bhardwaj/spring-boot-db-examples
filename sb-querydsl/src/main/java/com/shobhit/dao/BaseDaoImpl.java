package com.shobhit.dao;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.shobhit.entity.QAuthor;
import com.shobhit.entity.QBook;

public abstract class BaseDaoImpl<T, ID> extends SimpleJpaRepository<T, ID> implements BaseDao<T, ID> {

	protected EntityManager entityManager;
	protected JPAQueryFactory jpaQueryFactory;

	protected final QAuthor author = QAuthor.author;
	protected final QBook book = QBook.book;

	public BaseDaoImpl(Class<T> domainClass, EntityManager entityManager) {
		super(domainClass, entityManager);

		this.entityManager = entityManager;
		this.jpaQueryFactory = new JPAQueryFactory(entityManager);
	}

	@Override
	public T findByIdMandatory(ID id) throws IllegalArgumentException {
		return findById(id)
				.orElseThrow(() -> new IllegalArgumentException("No Element Found "));
	}
}