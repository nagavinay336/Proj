package com.empstack;

import java.util.Objects;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Employee {

	private int id;
	private String name;
	private String desig;
	private int salary;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(desig, other.desig) && id == other.id && Objects.equals(name, other.name)
				&& salary == other.salary;
	}

	@Override
	public int hashCode() {
		int prime = 31;
		int hash = prime * id + name.hashCode() + desig.hashCode() + salary * prime;
		return hash;
	}

}
