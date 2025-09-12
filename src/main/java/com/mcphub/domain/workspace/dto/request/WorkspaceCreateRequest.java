package com.mcphub.domain.workspace.dto.request;

import lombok.Builder;

import java.util.List;

@Builder
public record WorkspaceCreateRequest (
        String llmId,
        List<String> mcpId,
        String chat
) {}
