package umc.product.domain.mcp.service;

import umc.product.domain.mcp.dto.response.readmodel.TestReadDto;
import umc.product.domain.mcp.entity.Mcp;

import java.util.List;

public interface McpService {
	Mcp addMcp();

	TestReadDto getMcpById(Long id);

	List<Mcp> getAllMcps();

	void deleteMcpById(Long id);

	Mcp updateMcp();
}
