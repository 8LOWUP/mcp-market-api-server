package umc.product.domain.member.repository.jdbc.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import umc.product.domain.member.repository.jdbc.MemberJdbcRepository;


@Repository
@Slf4j
@AllArgsConstructor
public class MemberJdbcRepositoryImpl implements MemberJdbcRepository {
    private final JPAQueryFactory jpaQueryFactory;
    private final JdbcTemplate jdbcTemplate;
    private final PlatformTransactionManager transactionManager;

}
