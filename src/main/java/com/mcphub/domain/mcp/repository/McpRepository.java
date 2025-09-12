package com.mcphub.domain.mcp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mcphub.domain.mcp.entity.Mcp;
import org.springframework.stereotype.Repository;

@Repository
public interface McpRepository extends JpaRepository<Mcp, Long> {
}
