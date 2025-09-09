package com.mcphub.domain.member.service.auth;

import io.jsonwebtoken.Claims;
import com.mcphub.domain.member.entity.RefreshToken;

public interface MemberRefreshTokenService {
    RefreshToken saveRefreshToken(String refreshToken,
                                  Long memberId);
    void deleteRefreshToken(Long memberId);
    boolean existRefreshToken(String refreshToken,
                              Long memberId);
    Claims getClaims(String refreshToken);
}
