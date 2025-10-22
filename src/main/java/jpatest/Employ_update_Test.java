package jpatest;

import domain.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Employ_update_Test {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpatest");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    tx.begin();
    System.out.println("트랜잭션 시작");
    try {
      Employee employee = em.find(Employee.class, "20250002");
      System.out.println("1차 캐시에 없어서 데이터베이스로부터 가져옴");
      //employee.setEmpName("연아킴");
      em.persist(employee);
      System.out.println("영속상태");
      System.out.println("커밋 전");
      tx.commit();
      System.out.println("커밋 후");
    } catch (Exception e) {
      tx.rollback();
    }
  }
}
