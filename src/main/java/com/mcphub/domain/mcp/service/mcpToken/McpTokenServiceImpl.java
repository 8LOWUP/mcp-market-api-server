package com.mcphub.domain.mcp.service.mcpToken;

import com.mcphub.domain.mcp.dto.request.McpTokenRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class McpTokenServiceImpl implements McpTokenService {

	@Override
	public Long saveMcpToken(Long userId, Long mcpId, McpTokenRequest request) {
		return null;
	}

	@Override
	public Long updateMcpToken(Long userId, Long mcpId, McpTokenRequest request) {
		return null;
	}
}
