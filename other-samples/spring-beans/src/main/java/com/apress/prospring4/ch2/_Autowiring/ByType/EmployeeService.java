package com.apress.prospring4.ch2._Autowiring.ByType;

public class EmployeeService {

  private Employee employee;

  public Employee getEmployee() {
    return employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }


}
