package org.pp.practice.member.application;

import org.pp.practice.common.ApplicationTest;
import org.springframework.test.context.jdbc.Sql;

@Sql(scripts = "/sql/member_fixtures.sql")
public class MemberApplicationTest extends ApplicationTest {
}
