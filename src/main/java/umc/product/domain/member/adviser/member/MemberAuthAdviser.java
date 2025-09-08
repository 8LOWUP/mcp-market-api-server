package umc.product.domain.member.adviser.member;

import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.product.domain.file.service.FileService;
import umc.product.domain.member.converter.response.MemberConverter;
import umc.product.domain.member.dto.response.member.auth.MemberCreateTokenResponse;
import umc.product.domain.member.dto.response.member.common.MemberIdResponse;
import umc.product.domain.member.dto.response.member.auth.MemberLoginResponse;
import umc.product.domain.member.entity.Member;
import umc.product.domain.member.entity.enums.LoginType;
import umc.product.domain.member.service.member.MemberAuthService;
import umc.product.domain.member.service.member.MemberRefreshTokenService;
import umc.product.domain.member.service.member.MemberService;
import umc.product.global.config.security.jwt.JwtProvider;

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
