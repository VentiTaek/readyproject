package org.pp.practice.member.presentation.dto

data class MemberCreateResponse(
    val id: Long,
)

data class MemberInfo(
    val id: Long,
    val name: String,
)

data class MembersResponse(
    val members: List<MemberInfo>
)

data class MemberUpdateResponse(
    val id: Long,
    val name: String,
)