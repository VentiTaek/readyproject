package org.pp.practice.member.presentation.dto

enum class Status(
    val dd: String

) {
    STUN("dd"),
    DDDD("ddd"),;

    fun findStus(): Status? = values().find { it == STUN }
}