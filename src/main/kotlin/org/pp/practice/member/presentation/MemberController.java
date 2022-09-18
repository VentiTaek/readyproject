package org.pp.practice.member.presentation;

import org.pp.practice.member.application.dto.MemberCommandFactory;
import org.pp.practice.member.application.MemberFacade;
import org.pp.practice.member.application.dto.MemberInfo;
import org.pp.practice.member.application.dto.MemberUpdate;
import org.pp.practice.member.presentation.dto.MemberCreateRequest;
import org.pp.practice.member.presentation.dto.MemberCreateResponse;
import org.pp.practice.member.presentation.dto.MemberUpdateNameRequest;
import org.pp.practice.member.presentation.dto.MemberUpdateResponse;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        MemberInfo memberInfo = memberFacade.create(MemberCommandFactory.toCreate(request));
        return new MemberCreateResponse(memberInfo.getId());
    }

    @PatchMapping("/members/{id}")
    public MemberUpdateResponse updateName(
        @RequestBody MemberUpdateNameRequest memberUpdateNameRequest,
        @PathVariable Long id) {
        MemberUpdate memberUpdate = MemberCommandFactory.toUpdate(memberUpdateNameRequest);
        MemberInfo memberInfo = memberFacade.updateName(memberUpdate, id);
        return new MemberUpdateResponse(memberInfo.getId(), memberUpdate.getName());
    }
}
