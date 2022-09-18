package org.pp.practice.member.presentation;

import static io.restassured.RestAssured.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.pp.practice.common.AcceptanceTest;
import org.pp.practice.member.presentation.dto.MemberCreateAddressRequest;
import org.pp.practice.member.presentation.dto.MemberCreateRequest;
import org.pp.practice.member.presentation.dto.MemberUpdateNameRequest;
import org.pp.practice.member.presentation.dto.MemberUpdateResponse;
import org.springframework.http.HttpStatus;

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

        ExtractableResponse<Response> response = 회원가입_요청(memberCreateRequest);
        assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value());
    }

    @Test
    void 회원이름을_수정한다() {
        // given
        회원_생성한다();

        MemberUpdateNameRequest memberUpdateNameRequest = new MemberUpdateNameRequest(
            "바뀐이름"
        );

        // when
        ExtractableResponse<Response> response = 회원이름수정_요청(memberUpdateNameRequest);

        MemberUpdateResponse memberUpdateResponse = response.body()
            .as(MemberUpdateResponse.class);

        // then
        assertAll(
            () -> assertThat(response.statusCode()).isEqualTo(HttpStatus.OK.value()),
            () -> assertThat(memberUpdateResponse.getId()).isEqualTo(1L),
            () -> assertThat(memberUpdateResponse.getName()).isEqualTo("바뀐이름")
        );
    }

    private static ExtractableResponse<Response> 회원가입_요청(MemberCreateRequest memberCreateRequest) {
        return given()
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

    private static ExtractableResponse<Response> 회원이름수정_요청(MemberUpdateNameRequest memberUpdateNameRequest) {
        return given()
            .contentType(ContentType.JSON)
            .body(memberUpdateNameRequest)
            .log()
            .all()
            .when()
            .patch("/api/v1/members/{id}", 1)
            .then()
            .log()
            .all()
            .extract();
    }

}