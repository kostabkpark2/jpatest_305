package domain;

import javax.persistence.*;

@Entity
public class Employee {
  @Id
  @Column(length = 8)
  private String empId;
  @Column(length = 30 , nullable = false)
  private String empName;
  @ManyToOne(fetch = FetchType.LAZY)  // Eager 가 default 임
  @JoinColumn(name = "dept_id")
  private Department department;
  @Column(length = 8, nullable = false)
  private String joinDate;
  private long salary;

  public Employee(String empId, String empName, Department department, String joinDate, long salary) {
    this.empId = empId;
    this.empName = empName;
    this.department = department;
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

  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
    this.department = department;
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
        ", department=" + department +
        ", joinDate='" + joinDate + '\'' +
        '}';
  }
}
