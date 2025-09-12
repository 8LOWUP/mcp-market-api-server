package com.mcphub.domain.mcp.service.mcpDashboard;

import com.mcphub.domain.mcp.dto.request.McpDraftRequest;
import com.mcphub.domain.mcp.dto.request.McpMetaDataRequest;
import com.mcphub.domain.mcp.dto.request.McpUrlRequest;
import com.mcphub.domain.mcp.dto.response.readmodel.MyUploadMcpDetailReadModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class McpDashboardServiceImpl implements McpDashboardService {

	@Override
	public MyUploadMcpDetailReadModel getUploadMcpDetail(Long userId, Long mcpId) {
		return null;
	}

	@Override
	public Long createMcpDraft(Long userId, McpDraftRequest request) {
		return null;
	}

	@Override
	public Long uploadMcpUrl(Long userId, Long mcpId, McpUrlRequest request) {
		return null;
	}

	@Override
	public Long uploadMcpMetaData(Long userId, Long mcpId, McpMetaDataRequest request) {
		return null;
	}

	@Override
	public Long publishMcp(Long userId, Long mcpId) {
		return null;
	}

	@Override
	public Long deleteMcp(Long userId, Long mcpId) {
		return null;
	}
}
