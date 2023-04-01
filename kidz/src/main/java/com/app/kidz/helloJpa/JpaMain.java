package com.app.kidz.helloJpa;

import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

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

            member.setUsername("으악");
            member.setRoleType(RoleType.ADMIN);

            entityManager.persist(member);

            // 엔티티와 DB 테이블을 비교해서 create, update, validate 등의 옵션을 줄 수 있다.
            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        } finally {
            entityManager.close();
        }

        entityManagerFactory.close();
    }
}
