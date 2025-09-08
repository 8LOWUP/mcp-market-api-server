package umc.product.domain.member.service.member;

import umc.product.domain.member.entity.Member;

public interface MemberService {
    void existById(Long memberId);
    Member findById(Long memberId);
    Member findByIdNotFetchLoginInfo(Long memberId);
    void modifyMyProfileAvatar(Member member,
                                 String avatarUrl);
}
