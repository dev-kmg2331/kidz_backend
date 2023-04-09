package com.app.kidz.repository;

import com.app.kidz.domain.member.Member;
import com.app.kidz.domain.member.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public Long saveUser(User user){
        em.persist(user);
        return user.getId();
    }

    public User findUserById(Long id){
        return em.find(User.class, id);
    }
    public Member findMemberById(Long id){
        return em.find(Member.class, id);
    }
}
