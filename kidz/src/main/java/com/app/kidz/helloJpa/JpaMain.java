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

            /* 비영속 */
//            Member member = new Member();
            // 1차 캐시에 저장됨
//            member.setName("HELLOPERSISTANCE");

            /* 영속 */
            // 내부적으로 flush()라는 메소드를 호출한 뒤,
            // INSERT SQL 을 생성한 후 쓰기 지연 SQL 저장소에 저장한다.
            // 또한, 1차 캐시라는 영역에 Entity가 저장된다.
            // 이후 transaction을 commit 한 시점에서 저장한 SQL들이 날라간다.
//            entityManager.persist(member);

            // 1차 캐시에서 조회함 -> 영속 엔티티의 동일성 보장
            Member foundMember = entityManager.find(Member.class, 1L);

            // JPA는 내부적으로 1차 캐시라는 영역에 @Id, Entity 그리고 스냅샷이라는 공간이 있다.
            /*
            * -- Id --- Entity --- 스냅샷 --
            * |      |          |         |
            * |------|----------|---------|
            */
            // 스냅샷에는 값을 읽어온 최초 시점의 상태를 저장하는 공간이다.
            // EntityManager는 Entity와 스냅샷을 비교하여 변경되었다면 UPDATE SQL을 생성한다.
            // 이후 생성된 UPDATE SQL은 쓰기 지연 SQL 저장소에 저장, flush() 메소드가 사용될 때, 호출 된다.
            // 이후 commit 시점에서 DB에 반영된다.
            foundMember.setName("엔티티 변경 감지");

            /* 준영속 상태 */
            // EntityManager가 관리하지 않는 상태.
//            entityManager.detach(foundMember);

            /* 영속성 컨텍스트 초기화 */
//            entityManager.clear();

            /* 영속성 컨텍스트 종료 */
//            entityManager.close();

//            entityTransaction.commit();
        } catch (Exception e) {
            entityTransaction.rollback();
        } finally {
            entityManager.close();
        }

        entityManagerFactory.close();
    }
}
