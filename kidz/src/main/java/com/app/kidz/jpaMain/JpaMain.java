package com.app.kidz.jpaMain;


import com.app.kidz.domain.Book;
import com.app.kidz.domain.Member;
import com.app.kidz.domain.Order;
import com.app.kidz.domain.OrderStatus;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

@Slf4j
public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                /* persistenceUnitName : persistence.xml 에 unit-name으로 등록되어있는 것 */
                Persistence.createEntityManagerFactory("helloJpa");

        /* jdbc connection 처럼 일회용 */
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        /* 트랜잭션, 무조건 한 트랜잭션 안에서  */
        EntityTransaction entityTransaction = entityManager.getTransaction();
        entityTransaction.begin();

        try {

            Member member = new Member();
            member.setName("한동석");
            member.setCity("서울특별시");
            member.setStreet("테헤란로");
            member.setZipcode("00001");
            entityManager.persist(member);

            entityManager.flush();
            entityManager.clear();

            Order order = new Order();
            order.setMember(member);
            order.setOrderDate(LocalDateTime.now());
            order.setOrderStatus(OrderStatus.ORDER);

            entityManager.persist(order);

            entityManager.flush();
            entityManager.clear();

            Member findMember = entityManager.find(Member.class, member.getId());

//            System.out.println(findMember.getOrders().getClass());
//            findMember.getOrders().forEach(e -> System.out.println("===== order : " + e.getClass()));

//            System.out.println("===========order member : " + entityManager.find(Order.class, 4L).getMember().getClass());

            entityTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            entityTransaction.rollback();
        } finally {
            entityManager.close();
        }

        entityManagerFactory.close();
    }
}
