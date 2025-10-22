package jpatest;

import domain.Department;
import domain.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Department_find_Test {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpatest");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    tx.begin();
    System.out.println("트랜잭션 시작");
    try {
      System.out.println("1차 캐시에 없음");
      Department department = em.find(Department.class, 1);
      System.out.println("데이터베이스로부터 1차 캐시로 가져옴");
      System.out.println(department);
      System.out.println("영속상태");
      Department department2 = em.find(Department.class, 1);;
      System.out.println("1차 캐시에서 가져옴");
      System.out.println("데이터베이스의 자료와 1차 캐시의 자료가 동일한가 ? " +  (department == department2));
      tx.commit();
    } catch (Exception e) {
      tx.rollback();
    }
  }
}
