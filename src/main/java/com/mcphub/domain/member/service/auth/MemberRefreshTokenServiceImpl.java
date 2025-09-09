package com.mcphub.domain.member.service.auth;

import io.jsonwebtoken.Claims;
import com.mcphub.domain.member.entity.RefreshToken;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.mcphub.domain.member.repository.redis.MemberRedisRepository;
import com.mcphub.global.config.security.jwt.JwtProvider;

@Service
@RequiredArgsConstructor
public class MemberRefreshTokenServiceImpl implements MemberRefreshTokenService {
    private final MemberRedisRepository memberRedisRepository;
    private final JwtProvider jwtProvider;

    // memberId에 등록된 리프레쉬 토큰 지우고, 새로운 값 저장
    @Transactional
    public RefreshToken saveRefreshToken(String refreshToken, Long memberId) {
        return memberRedisRepository.saveRefreshToken(refreshToken, memberId);
    }

    // memberId에 등록된 리프레쉬 토큰 지우기
    @Transactional
    public void deleteRefreshToken(Long memberId) {
        memberRedisRepository.deleteRefreshToken(memberId);
    }

    // memberId에 맞는 리프레쉬 토큰이 존재하는지 확인
    @Transactional(readOnly = true)
    public boolean existRefreshToken(String refreshToken, Long memberId) {
        return memberRedisRepository.existRefreshToken(refreshToken, memberId);
    }


    @Override
    public Claims getClaims(String refreshToken) {
        return jwtProvider.getClaims(refreshToken);
    }
}
