package jpatest;

import domain.Employee;

import javax.persistence.*;
import java.util.List;

public class Employ_JPQL_Test {
  public static void main(String[] args) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpatest");
    EntityManager em = emf.createEntityManager();
    EntityTransaction tx = em.getTransaction();

    tx.begin();
    System.out.println("트랜잭션 시작");

      System.out.println("1차 캐시에 없음");
//      String jpql = "select emp from Employee emp where emp.empId like '2025%'";
//      List<Employee> employees = em.createQuery(jpql, Employee.class).getResultList();
    String jpql = "select emp.empName from Employee emp where emp.empId = '20250002'";
    String singleResult = em.createQuery(jpql, String.class).getSingleResult();
    System.out.println("영속상태");
    System.out.println(singleResult);
    //  System.out.println(employees.size() + " : " + employees);
      System.out.println("1차 캐시에서 가져옴");

      tx.commit();

  }
}
