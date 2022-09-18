package org.pp.practice.member.infrastructure;

import java.util.Optional;

import org.pp.practice.member.domain.Member;

public interface MemberStore {

    Member save(Member member);

    Optional<Member> findById(Long id);
}
