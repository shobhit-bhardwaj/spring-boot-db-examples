package com.shobhit.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthorStatistic {
	private String authorName;
	private int bookCount;
}