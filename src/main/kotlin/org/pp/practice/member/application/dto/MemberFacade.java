package org.pp.practice.member.application.dto;

import org.pp.practice.common.ApplicationService;
import org.pp.practice.member.domain.MemberService;

import lombok.RequiredArgsConstructor;

@ApplicationService
@RequiredArgsConstructor
public class MemberFacade {

    private final MemberService memberService;

    public MemberInfo create(MemberCreate memberCreate) {
        return memberService.create(memberCreate);
    }
}
