package com.mcphub.domain.member.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mcphub.domain.member.entity.Member;


public interface MemberJpaRepository extends JpaRepository<Member, Long> {

}

