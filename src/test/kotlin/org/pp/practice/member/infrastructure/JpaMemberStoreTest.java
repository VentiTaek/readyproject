package org.pp.practice.member.infrastructure;

import static org.assertj.core.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.pp.practice.common.JpaStoreTest;
import org.pp.practice.member.domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.junit.jupiter.Testcontainers;

@Testcontainers
@Sql(scripts = "/sql/member_fixtures.sql")
class JpaMemberStoreTest extends JpaStoreTest {

    @Autowired
    private MemberRepository memberRepository;

    private JpaMemberStore jpaMemberStore;

    @BeforeEach
    void setUp() {
        jpaMemberStore = new JpaMemberStore(memberRepository);
    }

    @Test
    void 회원조회한다_아이디사용() {
        Optional<Member> optionalMember = jpaMemberStore.findById(1L);
        assertThat(optionalMember.get()).isNotNull();
    }
}