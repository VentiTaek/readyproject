package org.pp.practice.member.presentation;

import org.pp.practice.member.application.dto.MemberFacade;
import org.pp.practice.member.application.dto.MemberFactoryKt;
import org.pp.practice.member.application.dto.MemberInfo;
import org.pp.practice.member.presentation.dto.MemberCreateRequest;
import org.pp.practice.member.presentation.dto.MemberCreateResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequestMapping("/api/v1")
@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberFacade memberFacade;

    @PostMapping("/members")
    public MemberCreateResponse create(@RequestBody MemberCreateRequest request) {
        MemberInfo memberInfo = memberFacade.create(MemberFactoryKt.toCreate(request));
        return new MemberCreateResponse(memberInfo.getId());
    }
}
