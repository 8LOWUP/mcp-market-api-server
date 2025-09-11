package com.mcphub.domain.member.dto.response.api;

import com.mcphub.domain.member.dto.response.readmodel.MemberRM;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SocialLoginResponse {
	private String accessToken;
	private String refreshToken;
	private MemberRM member;
}

