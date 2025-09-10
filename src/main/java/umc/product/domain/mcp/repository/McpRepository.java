package umc.product.domain.mcp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.product.domain.mcp.entity.Mcp;

public interface McpRepository extends JpaRepository<Mcp, Long> {
}
