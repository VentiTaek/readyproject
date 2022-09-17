package org.pp.practice.member.domain;

import javax.persistence.Embeddable;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Address {

    private String first;

    private String end;

    private Address(String first, String end) {
        this.first = first;
        this.end = end;
    }

    public static Address of(String first, String end) {
        return new Address(first, end);
    }
}
