package jpatest;

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
      Employee employee = new Employee();
      employee.setEmpId("20250001");
      employee.setEmpName("홍길동");
      employee.setDeptId(1);
      employee.setJoinDate("20250101");
      employee.setSalary(500);
      Employee employee2 = new Employee();
      employee2.setEmpId("20250002");
      employee2.setEmpName("김연아");
      employee2.setDeptId(1);
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
