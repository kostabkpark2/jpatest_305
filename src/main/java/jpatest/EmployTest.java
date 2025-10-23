package jpatest;

import domain.Department;
import domain.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class EmployTest {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpatest");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    tx.begin();
    System.out.println("트랜잭션 시작");
    try {
      // 부서 객체 가져오기
      System.out.println("부서 정보를 1차 캐시로 들고오기");
      Department department = em.find(Department.class, 2);
      // 사원 정보 생성하기
      Employee employee = new Employee();
      employee.setEmpId("20250006");
      employee.setEmpName("홍길동3");
      employee.setDepartment(department);
      employee.setJoinDate("20250101");
      employee.setSalary(500);

      department = em.find(Department.class, 3);
      Employee employee2 = new Employee();
      employee2.setEmpId("20250007");
      employee2.setEmpName("김연아3");
      employee2.setDepartment(department);
      employee2.setJoinDate("20250103");
      employee2.setSalary(300);
      System.out.println("비영속상태");
      em.persist(employee);
      em.persist(employee2);
      System.out.println("영속상태");
      System.out.println("커밋 전");
      tx.commit();
      System.out.println("커밋 후");
    } catch (Exception e) {
      tx.rollback();
    }
  }
}
