package umc.product.domain.mcp.adviser;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.product.domain.mcp.converter.McpConverter;
import umc.product.domain.mcp.dto.response.api.TestResponse;
import umc.product.domain.mcp.dto.response.readmodel.TestReadDto;
import umc.product.domain.mcp.entity.Mcp;
import umc.product.domain.mcp.service.McpService;

@Component
@RequiredArgsConstructor
public class McpAdviser {
	private final McpService mcpService;
	private final McpConverter mcpConverter;

	public TestResponse getMcpById(Long id) {
		TestReadDto readDto = mcpService.getMcpById(id);
		return mcpConverter.toTestResponse(readDto.getId());
	}
}
