package org.pp.practice.member.domain;

import org.pp.practice.member.application.dto.MemberCreate;
import org.pp.practice.member.application.dto.MemberInfo;
import org.pp.practice.member.application.dto.MemberUpdate;
import org.pp.practice.member.infrastructure.MemberStore;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberStore memberStore;

    @Transactional
    public MemberInfo create(MemberCreate memberCreate) {
        Member savedMember = memberStore.save(memberCreate.toEntity());
        return new MemberInfo(savedMember.getId());
    }

    @Transactional
    public MemberInfo updateName(MemberUpdate memberUpdate, Long id) {
        Member member = memberStore.findById(id)
            .orElseThrow(RuntimeException::new);

        member.updateName(memberUpdate.getName());
        return new MemberInfo(member.getId(), member.getName());
    }
}
