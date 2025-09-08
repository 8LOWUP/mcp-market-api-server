package umc.product.domain.member.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.product.domain.member.entity.Member;


public interface MemberJpaRepository extends JpaRepository<Member, Long> {

}

