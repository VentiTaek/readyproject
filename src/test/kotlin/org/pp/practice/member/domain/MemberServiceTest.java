package org.pp.practice.member.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.pp.practice.member.application.MemberApplicationTest;
import org.pp.practice.member.application.dto.MemberInfo;
import org.pp.practice.member.application.dto.MemberUpdate;
import org.springframework.beans.factory.annotation.Autowired;

class MemberServiceTest extends MemberApplicationTest {

    @Autowired
    private MemberService memberService;

    @Test
    void 회원이름을_수정한다() {
        String updateName = "변견된 이름";
        MemberUpdate memberUpdate = new MemberUpdate(updateName);

        //TODO: 회원이름 Fixtures
        MemberInfo memberInfo = memberService.updateName(memberUpdate, 1L);

        assertThat(memberInfo.getName()).isEqualTo(updateName);
    }
}