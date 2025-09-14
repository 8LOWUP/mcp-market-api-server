package com.mcphub.domain.workspace.dto.response;

import lombok.Builder;

@Builder
public record ChatResponse(
        String llmResponse
) {
}
