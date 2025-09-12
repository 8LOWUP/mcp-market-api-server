package com.mcphub.domain.mcp.repository;

import com.mcphub.domain.mcp.entity.UserMcp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMcpRepository extends JpaRepository<UserMcp, Long> {
	@Query("SELECT COUNT(u) FROM UserMcp u WHERE u.mcp.id = :mcpId")
	Integer getSavedUserCount(@Param("mcpId") Long mcpId);
}
