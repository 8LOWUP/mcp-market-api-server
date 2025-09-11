package com.mcphub.domain.member.converter.response;

import org.springframework.stereotype.Component;
import com.mcphub.domain.member.dto.response.member.auth.MemberLoginResponse;
import com.mcphub.domain.member.dto.response.member.common.MemberIdResponse;
import com.mcphub.domain.member.entity.Member;
import com.mcphub.domain.member.entity.enums.Role;
import com.mcphub.domain.member.entity.enums.Status;
import com.mcphub.global.config.security.jwt.TokenInfo;

@Component
public class MemberConverter {
    public MemberIdResponse toMemberIdResponse(
            Long memberId
    ) {
        return MemberIdResponse.builder()
                .memberId(memberId)
                .build();
    }

    public MemberLoginResponse toLoginMemberResponse(
            final Member member,
            TokenInfo tokenInfo,
            Role role
    ) {
        return MemberLoginResponse.builder()
                .memberId(member.getId())
                .accessToken(tokenInfo.accessToken())
                .refreshToken(tokenInfo.refreshToken())
                .activeStatus(member.getStatus() != Status.WAITING_FOR_UPDATE)
                .role(role)
                .build();
    }

}
