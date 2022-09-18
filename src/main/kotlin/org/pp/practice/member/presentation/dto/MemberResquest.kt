package org.pp.practice.member.presentation.dto

data class MemberCreateRequest(
    val name: String,
    val address: MemberCreateAddressRequest
)

data class MemberCreateAddressRequest(
    val first: String,
    val end: String,
)

data class MemberUpdateNameRequest(
    val name: String,
)


