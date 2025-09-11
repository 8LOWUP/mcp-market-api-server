package com.mcphub.domain.member.repository.querydsl.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import com.mcphub.domain.member.entity.Member;
import com.mcphub.domain.member.entity.QMember;
import com.mcphub.domain.member.entity.enums.LoginType;
import com.mcphub.domain.member.repository.querydsl.MemberDslRepository;

import java.util.*;


@Repository
@Slf4j
@AllArgsConstructor
public class MemberDslRepositoryImpl implements MemberDslRepository {
    private final JPAQueryFactory jpaQueryFactory;
    private final QMember qMember = QMember.member;

    @Override
    public boolean existById(Long memberId) {
        return jpaQueryFactory
                .selectFrom(qMember)
                .where(qMember.id.eq(memberId))
                .fetchFirst() != null;
    }

    @Override
    public void updateAvatarImage(Member member, String avatarUrl) {
        jpaQueryFactory
                .update(qMember)
                .set(qMember.avatarUrl, avatarUrl)
                .where(qMember.id.eq(member.getId()))
                .execute();
    }

    @Override
    public Optional<Member> findByIdNotFetchLoginInfo(Long memberId) {
        return Optional.ofNullable(
                jpaQueryFactory
                        .selectFrom(qMember)
                        .where(qMember.id.eq(memberId))
                        .fetchFirst()
        );
    }

    /**
     * 소셜로그인용
     */
    @Override
    public Optional<Member> findMemberByClientId(String clientId) {
        return Optional.ofNullable(
                jpaQueryFactory
                        .selectFrom(qMember)
                        .where(qMember.clientId.eq(clientId))
                        .fetchFirst()
        );
    }

    @Override
    public Optional<Member> findByClientIdAndLoginType(String clientId, LoginType loginType) {

        return Optional.ofNullable(jpaQueryFactory
                                    .selectFrom(qMember)
                                    .where(
                                            qMember.clientId.eq(clientId),
                                            qMember.loginType.eq(loginType)
                                    )
                                    .fetchOne());
    }
}
