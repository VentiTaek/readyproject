package org.pp.practice.member.infrastructure;

import java.util.Optional;

import org.pp.practice.member.domain.Member;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class JpaMemberStore implements MemberStore {

    private final MemberRepository memberRepository;

    @Override
    public Member save(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Optional<Member> findById(Long id) {
        return memberRepository.findById(id);
    }
}
