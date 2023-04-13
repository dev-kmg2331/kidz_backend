package com.app.kidz.repository;

import com.app.kidz.domain.Address;
import com.app.kidz.domain.member.MemberStatus;
import com.app.kidz.domain.member.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test @Rollback(false)
    void save() {
        //given
        User user = new User("kmg2331", "1234", "kmg2331@gmail.com", MemberStatus.ACTIVE, MemberStatus.NOT_ADMIN,
                "강민구", "강민구123", "01034442331",
                new Address("경기 의왕시 경수대로 262", "으아으앙", "00001")
        );

        //when
        Long savedId = memberRepository.saveUser(user);
        User findUser = memberRepository.findUserById(savedId);

        //then
        assertThat(user).isEqualTo(findUser);
    }

    @Test
    void findById() {
        //given
        User user = new User("kmg2331", "1234", "kmg2331@gmail.com", MemberStatus.ACTIVE, MemberStatus.NOT_ADMIN,
                "강민구", "강민구123", "01034442331",
                new Address("경기 의왕시 경수대로 262", "으아으앙", "00001")
        );

        //when
        Long savedId = memberRepository.saveUser(user);
        User findUser = memberRepository.findUserById(savedId);

        //then
        assertThat(user).isEqualTo(findUser);
    }
}