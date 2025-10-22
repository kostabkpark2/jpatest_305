package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Department {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int deptId;
  private String deptName;

  public Department(int deptId, String deptName) {
    this.deptId = deptId;
    this.deptName = deptName;
  }

  public Department(){}

  public int getDeptId() {
    return deptId;
  }

  public void setDeptId(int deptId) {
    this.deptId = deptId;
  }

  public String getDeptName() {
    return deptName;
  }

  public void setDeptName(String deptName) {
    this.deptName = deptName;
  }

  @Override
  public String toString() {
    return "Department{" +
        "deptId=" + deptId +
        ", deptName='" + deptName + '\'' +
        '}';
  }
}
