package org.pp.practice.member.application.dto

import org.pp.practice.member.domain.Address
import org.pp.practice.member.domain.Member
import org.pp.practice.member.presentation.dto.MemberCreateAddressRequest
import org.pp.practice.member.presentation.dto.MemberCreateRequest

/**
 * REQUEST
 */
data class MemberCreate(
    val name: String,
    val address: MemberAddress
) {
    fun toEntity(): Member {
        return Member(
            this.name,
            Address.of(
                this.address.first,
                this.address.end,
            )
        )
    }
}

fun MemberCreateRequest.toCreate(): MemberCreate =
    MemberCreate(
        name = this.name,
        address = this.address.toAddress(),
    )

data class MemberAddress(
    val first: String,
    val end: String,
)

fun MemberCreateAddressRequest.toAddress(): MemberAddress =
    MemberAddress(
        first = this.first,
        end = this.end,
    )


/**
 * Response
 */
data class MemberInfo(
    val id: Long
)