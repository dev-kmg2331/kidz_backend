package com.app.kidz.repository;

import com.app.kidz.domain.Payment;
import com.app.kidz.domain.member.Member;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class PaymentRepository {

    @PersistenceContext
    private EntityManager em;

    public Long save(Payment payment){
        em.persist(payment);
        return payment.getId();
    }

    public Payment findById(Long id){
        return em.find(Payment.class, id);
    }

    public List<Payment> findPaymentsByMemberId(Long memberId){
        return em.createQuery("select p from Payment p where p.member.id = :memberId", Payment.class)
                .setParameter("memberId", memberId)
                .getResultList();
    }
}
