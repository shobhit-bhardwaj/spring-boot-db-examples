package com.shobhit.dao;

import org.springframework.stereotype.Repository;

import com.shobhit.entity.Book;

@Repository
public interface BookDao extends BaseDao<Book, Integer> {
	
}