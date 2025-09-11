package com.mcphub.domain.member.strategy.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import com.mcphub.domain.member.client.SocialMemberClient;
import com.mcphub.domain.member.converter.response.MemberConverter;
import com.mcphub.domain.member.dto.client.SocialLoginResponse;
import com.mcphub.domain.member.dto.response.member.auth.MemberLoginResponse;
import com.mcphub.domain.member.entity.Member;
import com.mcphub.domain.member.repository.querydsl.MemberDslRepository;
import com.mcphub.domain.member.strategy.LoginStrategy;
import com.mcphub.global.common.exception.RestApiException;
import com.mcphub.domain.member.status.AuthErrorStatus;
import com.mcphub.global.config.security.jwt.JwtProvider;
import com.mcphub.global.config.security.jwt.TokenInfo;

import static com.mcphub.domain.member.status.MemberErrorStatus.*;

@RequiredArgsConstructor
@Component
public class SocialLoginStrategy implements LoginStrategy {

    private final MemberDslRepository memberDslRepository;
    private final MemberConverter memberConverter;
    private final JwtProvider jwtProvider;

    /**
     * GOOGLE, KAKAO는 따로 구현하는 것이 아닌 공통적인 login 메서드 사용
     * SocialMemberClient로 Social을 구분
     */
    @Override
    public MemberLoginResponse login(
            SocialMemberClient client,
            String accessToken
    ) {
        SocialLoginResponse socialLoginResponse;
        try {
            socialLoginResponse = client.getSocialLoginResponse(accessToken);

            if (socialLoginResponse == null || socialLoginResponse.id() == null) {
                throw new RestApiException(AuthErrorStatus.FAILED_SOCIAL_LOGIN);
            }

        } catch (Exception e) {
            throw new RestApiException(AuthErrorStatus.FAILED_SOCIAL_LOGIN);
        }

        String clientId = socialLoginResponse.id();
        System.out.println(clientId);

        Member member = memberDslRepository.findByClientIdAndLoginType(clientId, client.getLoginType())
                .orElseThrow(() -> new RestApiException(MEMBER_NOT_FOUND));
        TokenInfo tokenInfo = generateToken(member);

        return memberConverter.toLoginMemberResponse(member, tokenInfo, member.getRole());
    }

    private TokenInfo generateToken(Member member) {
        return jwtProvider.generateToken(member.getId().toString(), member.getRole().toString());
    }
}
