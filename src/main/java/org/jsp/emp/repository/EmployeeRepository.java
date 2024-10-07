package org.jsp.emp.repository;

import java.util.List;
import java.util.Optional;

import org.jsp.emp.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	Optional<Employee> findEmployeeByEmailAndPassword(String email, String password);

	List<Employee> findByName(String name);

	@Query("select e from Employee e where e.status='ACTIVE'")
	List<Employee> findAllActiveEmployee();

}
