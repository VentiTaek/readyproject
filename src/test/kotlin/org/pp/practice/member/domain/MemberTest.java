package org.pp.practice.member.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MemberTest {

    @Test
    void 회원이름을_변경한다() {
        String updateName = "변경될 이름";

        //TODO Fixtures로 변경예정
        Member member = new Member("이름", Address.of("first", "end"));
        member.updateName(updateName);

        assertThat(member.getName()).isEqualTo(updateName);
    }
}