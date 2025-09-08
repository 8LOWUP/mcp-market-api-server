package umc.product.domain.member.converter.response;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Component;
import umc.product.domain.member.dto.response.member.auth.MemberLoginResponse;
import umc.product.domain.member.dto.response.member.common.MemberIdResponse;
import umc.product.domain.member.entity.Member;
import umc.product.domain.member.entity.enums.Role;
import umc.product.domain.member.entity.enums.Status;
import umc.product.global.config.security.jwt.TokenInfo;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
