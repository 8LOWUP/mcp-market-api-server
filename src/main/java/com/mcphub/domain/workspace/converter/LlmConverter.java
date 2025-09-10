package com.mcphub.domain.workspace.converter;

import com.mcphub.domain.workspace.dto.response.LlmTokenResponse;
import com.mcphub.domain.workspace.entity.LlmToken;
import org.springframework.stereotype.Component;

@Component
public class LlmConverter {
    public LlmTokenResponse toLlmTokenResponse(LlmToken llmToken) {
        return LlmTokenResponse.builder()
                .llmId(llmToken.getLlmId())
                .llmToken(llmToken.getToken())
                .build();
    }
}
