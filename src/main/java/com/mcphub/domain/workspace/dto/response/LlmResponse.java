package com.mcphub.domain.workspace.dto.response;

import com.mcphub.domain.workspace.entity.enums.Llm;

public record LlmResponse(
        Llm llmId,
        String modelName,
        String llmProvider
) {
}
