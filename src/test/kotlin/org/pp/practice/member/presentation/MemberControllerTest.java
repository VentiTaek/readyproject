package org.pp.practice.member.presentation;

import org.junit.jupiter.api.Test;
import org.pp.practice.common.AcceptanceTest;
import org.pp.practice.member.presentation.dto.MemberCreateAddressRequest;
import org.pp.practice.member.presentation.dto.MemberCreateRequest;
import org.testcontainers.junit.jupiter.Testcontainers;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;

class MemberControllerTest extends AcceptanceTest {

    @Test
    void 회원_생성한다() {

        MemberCreateRequest memberCreateRequest = new MemberCreateRequest(
            "이름",
            new MemberCreateAddressRequest("first", "end")
        );
        ExtractableResponse<Response> response = RestAssured.given()
            .contentType(ContentType.JSON)
            .body(memberCreateRequest)
            .log()
            .all()
            .when()
            .post("/api/v1/members")
            .then()
            .log()
            .all()
            .extract();

    }

    @Test
    void 회원_생성한다2() {

        MemberCreateRequest memberCreateRequest = new MemberCreateRequest(
            "이름2",
            new MemberCreateAddressRequest("first2", "end2")
        );
        ExtractableResponse<Response> response = RestAssured.given()
            .contentType(ContentType.JSON)
            .body(memberCreateRequest)
            .log()
            .all()
            .when()
            .post("/api/v1/members")
            .then()
            .log()
            .all()
            .extract();

    }
}