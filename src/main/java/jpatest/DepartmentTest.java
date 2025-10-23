package jpatest;

import domain.Department;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DepartmentTest {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpatest");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    tx.begin();
    System.out.println("트랜잭션 시작");
    try {
      Department department = new Department();
      System.out.println("비영속 상태");
      department.setDeptName("Sales");
      em.persist(department);

      department = new Department();
      System.out.println("비영속 상태");
      department.setDeptName("Finance");
      em.persist(department);

      System.out.println("영속 상태");
      System.out.println("커밋 전");
      tx.commit();
      System.out.println("커밋 후");
    } catch (Exception e) {
      tx.rollback();
    }
  }
}
