package com.mcphub.domain.member.strategy.context;

import com.mcphub.domain.member.client.SocialMemberClient;
import com.mcphub.domain.member.client.spec.AppleMemberClient;
import com.mcphub.domain.member.client.spec.GoogleMemberClient;
import com.mcphub.domain.member.client.spec.KakaoMemberClient;
import com.mcphub.domain.member.entity.enums.LoginType;
import com.mcphub.domain.member.dto.response.member.auth.MemberLoginResponse;
import com.mcphub.domain.member.strategy.LoginStrategy;
import com.mcphub.domain.member.strategy.handler.LoginHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.mcphub.domain.member.strategy.impl.SocialLoginStrategy;
import com.mcphub.global.common.exception.RestApiException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.mcphub.domain.member.status.MemberErrorStatus.UNSUPPORTED_LOGIN_TYPE;

@Component
@RequiredArgsConstructor
public class LoginContext {

    private final Map<LoginType, LoginHandler> clientMap;
    private final Map<LoginType, LoginStrategy> strategyMap;
    private final AppleMemberClient appleMemberClient;
    private final GoogleMemberClient googleMemberClient;
    private final KakaoMemberClient kakaoMemberClient;

    /**
     *
     * @param socialMemberClientList bean에 등록된 APPLE, GOOGLE, KAKAO 구현체 가져옴
     * @param strategyList bean에 등록된 Internal, Social 구현체 가져옴
     */
    @Autowired
    public LoginContext(
            List<SocialMemberClient> socialMemberClientList,
            List<LoginStrategy> strategyList,
            AppleMemberClient appleMemberClient,
            GoogleMemberClient googleMemberClient,
            KakaoMemberClient kakaoMemberClient
    ) {
        this.appleMemberClient = appleMemberClient;
        this.googleMemberClient = googleMemberClient;
        this.kakaoMemberClient = kakaoMemberClient;
        this.strategyMap = new HashMap<>();
        this.clientMap = new HashMap<>();

        //Social에 맞는 로직을 Map에 추가
        strategyList.forEach(strategy -> {
            if(strategy instanceof SocialLoginStrategy) {
                strategyMap.put(LoginType.KAKAO, strategy);
                strategyMap.put(LoginType.APPLE, strategy);
                strategyMap.put(LoginType.GOOGLE, strategy);
            }
        });

        //Social에 맞는 LoginHandler를 Map에 추가
        socialMemberClientList.forEach(client -> {
            if (client instanceof AppleMemberClient) {
                clientMap.put(LoginType.APPLE,
                        LoginHandler.builder()
                                .client(appleMemberClient)
                                .strategy(strategyMap.get(LoginType.APPLE))
                                .build());
            } else if (client instanceof GoogleMemberClient) {
                clientMap.put(LoginType.GOOGLE,
                        LoginHandler.builder()
                                .client(googleMemberClient)
                                .strategy(strategyMap.get(LoginType.GOOGLE))
                                .build());
            } else if (client instanceof KakaoMemberClient) {
                clientMap.put(LoginType.KAKAO,
                        LoginHandler.builder()
                                .client(kakaoMemberClient)
                                .strategy(strategyMap.get(LoginType.KAKAO))
                                .build());
            }
            clientMap.put(LoginType.INTERNAL,       //internal은 default로 지정
                    LoginHandler.builder()
                            .client(null)
                            .strategy(strategyMap.get(LoginType.INTERNAL))
                            .build());
        });
    }

    public MemberLoginResponse executeStrategy(
            String accessToken, LoginType loginType
    ) {
        LoginStrategy strategy = clientMap.get(loginType).getStrategy();
        if (strategy == null) {
            throw new RestApiException(UNSUPPORTED_LOGIN_TYPE);
        }
        return strategy.login(clientMap.get(loginType).getClient(), accessToken);
    }
}
