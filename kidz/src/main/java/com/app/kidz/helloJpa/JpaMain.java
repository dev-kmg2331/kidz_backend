package com.app.kidz.helloJpa;

import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

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
//            Member member = new Member();
//            member.setName("HELLO-JPA");
//            entityManager.persist(member);

//            Member foundMember = entityManager.find(Member.class, 2L);
//            foundMember.setName("수정된 멤버");

            List<Member> resultList = entityManager.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(5)
                    .setMaxResults(10)
                    .getResultList();

            resultList.forEach(e -> log.info(e.toString()));

            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        } finally {
            entityManager.close();
        }

        entityManagerFactory.close();
    }
}
