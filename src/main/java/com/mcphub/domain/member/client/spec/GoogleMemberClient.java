package com.mcphub.domain.member.client.spec;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import com.mcphub.domain.member.client.SocialMemberClient;
import com.mcphub.domain.member.client.common.SocialClient;
import com.mcphub.domain.member.dto.client.SocialLoginResponse;
import com.mcphub.domain.member.entity.enums.LoginType;

@Component
@RequiredArgsConstructor
public class GoogleMemberClient implements SocialMemberClient {
    private final SocialClient socialClient;
    private static final String GOOGLE_URL = "https://www.googleapis.com/oauth2/v3/userinfo";

    @Override
    public SocialLoginResponse getSocialLoginResponse(
            String accessToken
    ) {
        String idPath = "$.sub";

        return socialClient.getSocialLoginResponse(
                accessToken,
                GOOGLE_URL,
                idPath);
    }

    @Override
    public LoginType getLoginType(
    ) {
        return LoginType.GOOGLE;
    }
}