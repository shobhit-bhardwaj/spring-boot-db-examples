package com.shobhit.dao;

import javax.persistence.EntityManager;

import com.shobhit.entity.Book;

public class BookDaoImpl extends BaseDaoImpl<Book, Integer> implements BookDao {

	public BookDaoImpl(EntityManager entityManager) {
		super(Book.class, entityManager);
	}
}