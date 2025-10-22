package domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
  @Id
  private String empId;
  private String empName;
  private int deptId;
  private String joinDate;
  private long salary;

  public Employee(String empId, String empName, int deptId, String joinDate, long salary) {
    this.empId = empId;
    this.empName = empName;
    this.deptId = deptId;
    this.joinDate = joinDate;
    this.salary = salary;
  }

  public Employee() {}

  public String getEmpId() {
    return empId;
  }

  public void setEmpId(String empId) {
    this.empId = empId;
  }

  public String getEmpName() {
    return empName;
  }

  public void setEmpName(String empName) {
    this.empName = empName;
  }

  public int getDeptId() {
    return deptId;
  }

  public void setDeptId(int deptId) {
    this.deptId = deptId;
  }

  public String getJoinDate() {
    return joinDate;
  }

  public void setJoinDate(String joinDate) {
    this.joinDate = joinDate;
  }

  public long getSalary() {
    return salary;
  }

  public void setSalary(long salary) {
    this.salary = salary;
  }

  @Override
  public String toString() {
    return "Employee{" +
        "empId='" + empId + '\'' +
        ", empName='" + empName + '\'' +
        ", deptId=" + deptId +
        ", joinDate='" + joinDate + '\'' +
        '}';
  }
}
