package com.mcphub.domain.mcp.repository;

import com.mcphub.domain.mcp.entity.ArticleMcpTool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleMcpToolRepository extends JpaRepository<ArticleMcpTool, Long> {
}
