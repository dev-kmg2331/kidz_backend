package com.app.kidz.helloJpa;

import com.app.kidz.domain.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

public class MyJpaMain {
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

            User member = User.builder()
                    .identification("HELLOJPA")
                    .password("1234")
                    .email("JPA@gmail.com")
//                    .status(MemberStatus.ACTIVE)
//                    .isAdmin(MemberStatus.NOTADMIN)
                    .joinedAt(LocalDateTime.now()).build();

            entityManager.persist(member);

            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        } finally {
            entityManager.close();
        }

        entityManagerFactory.close();
    }
}
