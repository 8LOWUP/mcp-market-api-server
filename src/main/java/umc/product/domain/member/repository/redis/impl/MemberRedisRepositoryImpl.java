package umc.product.domain.member.repository.redis.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.connection.StringRedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;
import umc.product.domain.member.entity.Member;
import umc.product.domain.member.entity.RefreshToken;
import umc.product.domain.member.repository.redis.MemberRedisRepository;
import umc.product.global.common.exception.RestApiException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;
import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class MemberRedisRepositoryImpl implements MemberRedisRepository {
    private final RedisTemplate<String, Object> redisTemplate;
    private final StringRedisTemplate stringRedisTemplate;

    //Todo: 임시로 24시간으로 설정
    private static final long CODE_EXPIRATION_TIME = 60 * 60 * 24;
    private static final String CODE_KEY_PREFIX = "code:";
    private static final String CODE_MEMBER_KEY_PREFIX = "codeMember:";
    private static final long REFRESH_EXPIRATION_TIME = 60*60*24*14;
    private static final String REFRESH_KEY_PREFIX = "refreshToken:";


    @Transactional
    @Override
    public RefreshToken saveRefreshToken(String refreshToken, Long memberId) {
        String key = REFRESH_KEY_PREFIX +memberId;
        // 이미 등록된 리프레쉬 토큰이 있다면 지우고 새로운 값 저장
        deleteRefreshToken(memberId);

        RefreshToken token = RefreshToken.builder()
                .memberId(memberId.toString())
                .refreshToken(refreshToken)
                .build();

        // 새로운 리프레쉬 토큰 저장
        redisTemplate.opsForHash().put(key, "refreshToken", token);
        redisTemplate.expire(key, REFRESH_EXPIRATION_TIME, TimeUnit.SECONDS);

        return token;
    }

    @Override
    public void deleteRefreshToken(Long memberId) {
        String key = REFRESH_KEY_PREFIX +memberId;

        if(Boolean.TRUE.equals(redisTemplate.hasKey(key))) {
            redisTemplate.delete(key);
        }
    }

    @Override
    public boolean existRefreshToken(String refreshToken, Long memberId) {
        String key = REFRESH_KEY_PREFIX + memberId;

        RefreshToken storedToken = (RefreshToken) redisTemplate.opsForHash().get(key, "refreshToken");

        return storedToken != null && storedToken.getRefreshToken().equals(refreshToken);
    }
}
