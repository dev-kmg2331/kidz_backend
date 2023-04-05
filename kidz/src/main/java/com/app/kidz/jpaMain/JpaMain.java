package com.app.kidz.jpaMain;

import com.app.kidz.domain.entity.Member;
import com.app.kidz.domain.entity.Payment;
import com.app.kidz.domain.entity.Point;
import com.app.kidz.domain.entity.User;
import com.app.kidz.domain.enums.MemberRank;
import com.app.kidz.domain.enums.MemberStatus;
import lombok.extern.slf4j.Slf4j;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;

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

            User user = User.builder()
                    .identification("rkdalsrn2331")
                    .password("1234")
                    .email("rkdalsrn2331@naver")
                    .status(MemberStatus.ACTIVE)
                    .isAdmin(MemberStatus.NOT_ADMIN)
                    .joinedAt(LocalDateTime.now())
                    .name("강민구")
                    .nickname("KOKKIRI")
                    .mobile("01012341234")
                    .address("경수대로 262")
                    .rank(MemberRank.MASTER)
                    .build();

            entityManager.persist(user);

//            Payment payment = new Payment();
//            payment.setAmount(120000);
//            payment.setDate(LocalDateTime.now());
//            payment.setMember(entityManager.find(Member.class, 1L));
//            payment.setMethod("카카오페이");
//
//            entityManager.persist(payment);

//            Point point = new Point();
//            point.setAmount(12);
//            point.setMember(entityManager.find(Member.class, 2L));
//            entityManager.persist(point);

//            entityManager.find(Member.class, 1L).getPointList().forEach(e -> System.out.println(((User)e.getMember()).getNickname()));

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

