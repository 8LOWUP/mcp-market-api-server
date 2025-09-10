package com.mcphub.domain.member.dto.response.member.auth;

import com.mcphub.global.config.security.auth.enums.Role;
import lombok.Builder;

@Builder
public record MemberLoginResponse (
        Long memberId,
        String accessToken,
        String refreshToken,
        boolean activeStatus,
        Role role
){

}
