package com.helper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeRowMapper implements RowMapper<Integer> {

	@Override
	public Integer mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		int id = resultSet.getInt("EMPLOYEE_ID");
		return id;
	}

}
