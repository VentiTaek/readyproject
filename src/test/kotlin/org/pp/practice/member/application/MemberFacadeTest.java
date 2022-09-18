package org.pp.practice.member.application;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.pp.practice.member.application.dto.MemberInfo;
import org.pp.practice.member.application.dto.MemberUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.jdbc.Sql;

@Sql(scripts = "/sql/member_fixtures.sql")
class MemberFacadeTest extends MemberApplicationTest {

    @Autowired
    private MemberFacade memberFacade;

    @Test
    void 회원이름을_변경한다() {
        String updateName = "변견된 이름";
        MemberUpdate memberUpdate = new MemberUpdate(updateName);
        MemberInfo memberInfo = memberFacade.updateName(memberUpdate, 1L);

        assertThat(memberInfo.getName()).isEqualTo(updateName);
    }

}