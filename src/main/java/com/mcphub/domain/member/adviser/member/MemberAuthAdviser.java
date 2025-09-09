package com.mcphub.domain.member.adviser.member;

import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import com.mcphub.domain.member.dto.response.member.auth.MemberCreateTokenResponse;
import com.mcphub.domain.member.dto.response.member.common.MemberIdResponse;
import com.mcphub.domain.member.dto.response.member.auth.MemberLoginResponse;
import com.mcphub.domain.member.entity.Member;
import com.mcphub.domain.member.entity.enums.LoginType;
import com.mcphub.domain.member.service.auth.MemberAuthService;
import com.mcphub.domain.member.service.auth.MemberRefreshTokenService;
import com.mcphub.domain.member.service.member.MemberService;

@Component
@RequiredArgsConstructor
public class MemberAuthAdviser {
    private final MemberAuthService memberAuthService;
    private final MemberService memberService;
    private final MemberRefreshTokenService memberRefreshTokenService;

    public MemberLoginResponse socialLogin(
            String accessToken,
            LoginType loginType
    ) {
        return memberAuthService.socialLogin(accessToken, loginType);
    }

    public MemberCreateTokenResponse regenerateToken(
            String refreshToken
    ) {
        Claims claims = memberRefreshTokenService.getClaims(refreshToken);
        Long memberId = Long.parseLong(claims.get("memberId").toString());
        Member member = memberService.findById(memberId);
        return memberAuthService.generateNewAccessToken(refreshToken, member);
    }

    public MemberIdResponse logout(
            Member member
    ) {
        return memberAuthService.logout(member);
    }

    public MemberIdResponse withdrawal(
            Member member
    ) {
        return memberAuthService.withdrawal(member);
    }
}
