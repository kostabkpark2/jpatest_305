package domain;

import javax.persistence.*;

@Entity
public class Department {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int deptId;
  @Column(length = 20)
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
