package umc.product.domain.member.repository.querydsl;

import umc.product.domain.member.entity.Member;
import umc.product.domain.member.entity.enums.LoginType;

import java.util.List;
import java.util.Optional;

public interface MemberDslRepository {
    boolean existById(Long memberId);

    void updateAvatarImage(Member member, String avatarUrl);

    Optional<Member> findByIdNotFetchLoginInfo(Long memberId);
    Optional<Member> findMemberByClientId(String clientId);

    Optional<Member> findByClientIdAndLoginType(String clientId, LoginType loginType);
}
