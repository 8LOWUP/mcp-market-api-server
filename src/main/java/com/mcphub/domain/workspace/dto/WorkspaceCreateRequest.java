package com.mcphub.domain.workspace.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record WorkspaceCreateRequest (
        String title,
        List<String> mcpId
) {}
