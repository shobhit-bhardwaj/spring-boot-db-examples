package com.shobhit.service;

import java.util.List;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jooq.sample.model.Tables;
import com.jooq.sample.model.tables.pojos.Employ;

@Service
public class EmployService {

	@Autowired
	private DSLContext dslContext;

	public void saveEmploy(Employ employ) {
		dslContext.insertInto(Tables.EMPLOY, Tables.EMPLOY.ID, Tables.EMPLOY.NAME, Tables.EMPLOY.DESIGNATION, Tables.EMPLOY.SALARY)
			.values(employ.getId(), employ.getName(), employ.getDesignation(), employ.getSalary())
			.execute();
	}

	public List<Employ> getEmploys() {
		return dslContext.selectFrom(Tables.EMPLOY)
			.fetchInto(Employ.class);
	}
}