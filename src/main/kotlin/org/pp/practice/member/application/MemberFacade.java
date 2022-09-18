package org.pp.practice.member.application;

import org.pp.practice.common.ApplicationService;
import org.pp.practice.member.application.dto.MemberCreate;
import org.pp.practice.member.application.dto.MemberInfo;
import org.pp.practice.member.application.dto.MemberUpdate;
import org.pp.practice.member.domain.MemberService;

import lombok.RequiredArgsConstructor;

@ApplicationService
@RequiredArgsConstructor
public class MemberFacade {

    private final MemberService memberService;

    public MemberInfo create(MemberCreate memberCreate) {
        return memberService.create(memberCreate);
    }

    public MemberInfo updateName(MemberUpdate memberUpdate, Long id) {
        return memberService.updateName(memberUpdate, id);
    }
}
