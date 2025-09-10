package com.mcphub.domain.workspace.mapper;

import com.mcphub.domain.workspace.dto.request.LlmTokenRequest;
import com.mcphub.domain.workspace.entity.LlmToken;
import org.springframework.stereotype.Component;

@Component
public class LlmMapper {
    public LlmToken toLlmToken(LlmTokenRequest request) {
        return new LlmToken(null, request.llmId(), request.llmToken(), true);
    }
}
