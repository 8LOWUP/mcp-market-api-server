package com.mcphub.domain.member.repository.redis;

import com.mcphub.domain.member.entity.RefreshToken;

public interface MemberRedisRepository {
    RefreshToken saveRefreshToken(String refreshToken, Long memberId);
    void deleteRefreshToken(Long memberId);
    boolean existRefreshToken(String refreshToken, Long memberId);
}
