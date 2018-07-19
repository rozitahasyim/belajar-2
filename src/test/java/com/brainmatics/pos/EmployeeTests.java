package com.brainmatics.pos;

import com.brainmatics.pos.core.employee.Employee;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EmployeeTests {
	@Test
	public void age_test() {
		Employee e = new Employee();
		assertEquals(25, e.getAge());
	}
}
