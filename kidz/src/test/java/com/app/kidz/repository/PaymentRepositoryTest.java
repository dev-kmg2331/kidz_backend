package com.app.kidz.repository;

import com.app.kidz.domain.Address;
import com.app.kidz.domain.Payment;
import com.app.kidz.domain.PaymentMethod;
import com.app.kidz.domain.member.Member;
import com.app.kidz.domain.member.MemberStatus;
import com.app.kidz.domain.member.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional @Slf4j
class PaymentRepositoryTest {

    @PersistenceContext
    EntityManager em;
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private MemberRepository memberRepository;

    @Test @Rollback(false)
    void saveTest() throws Exception {
        //given
        User user = new User("kmg2331", "1234", "kmg2331@gmail.com", MemberStatus.ACTIVE, MemberStatus.NOT_ADMIN,
                "강민구", "강민구123", "01034442331",
                new Address("경기 의왕시 경수대로 262", "으아으앙", "00001")
        );
        Payment payment = new Payment(30000, PaymentMethod.KAKAO, user);

        //when
        Long memberId = memberRepository.saveUser(user);
        Long paymentId = paymentRepository.save(payment);

        /**
         * 영속성 컨텍스트의 내용을 DB에 반영 후, 영속성 컨텍스트를 초기화 한 다음 조회해야 한다.
         * */
        em.flush();
        em.clear();

        //then
        assertThat(memberRepository.findMemberById(memberId).getPayments()).contains(paymentRepository.findById(paymentId));
    }

    @Test
    void findPaymentsByMemberIdTest() throws Exception {
        //given
        User user = new User("kmg2331", "1234", "kmg2331@gmail.com", MemberStatus.ACTIVE, MemberStatus.NOT_ADMIN,
                "강민구", "강민구123", "01034442331",
                new Address("경기 의왕시 경수대로 262", "으아으앙", "00001")
        );
        Payment payment = new Payment(30000, PaymentMethod.KAKAO, user);

        //when
        Long memberId = memberRepository.saveUser(user);
        Long paymentId = paymentRepository.save(payment);

        em.flush();
        em.clear();

        //then
        assertThat(paymentRepository.findPaymentsByMemberId(memberId)).contains(paymentRepository.findById(paymentId));
    }
}