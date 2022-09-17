package org.pp.practice.member.infrastructure;

import org.pp.practice.member.domain.Member;
import org.springframework.data.repository.CrudRepository;

public interface MemberRepository extends CrudRepository<Member, Long> {
}
