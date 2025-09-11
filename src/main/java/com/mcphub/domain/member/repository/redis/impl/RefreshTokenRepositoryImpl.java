package com.mcphub.domain.member.repository.redis.impl;

import lombok.RequiredArgsConstructor;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.concurrent.*;

@Repository
@RequiredArgsConstructor
public class RefreshTokenRepositoryImpl {

    private final RedisTemplate<String, String> redisTemplate;

    public void save(Long memberId, String refreshToken, long expirationMillis) {
        redisTemplate.opsForValue().set("refresh:" + memberId, refreshToken, expirationMillis, TimeUnit.MILLISECONDS);
    }

    public Optional<String> findByMemberId(Long memberId) {
        return Optional.ofNullable(redisTemplate.opsForValue().get("refresh:" + memberId));
    }

    public void delete(Long memberId) {
        redisTemplate.delete("refresh:" + memberId);
    }
}


