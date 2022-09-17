package org.pp.practice.member.infrastructure;

import org.pp.practice.member.domain.Member;

public interface MemberStore {

    Member save(Member member);
}
