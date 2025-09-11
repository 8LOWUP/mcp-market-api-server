package com.mcphub.domain.workspace.adviser;

import com.mcphub.domain.workspace.dto.request.LlmTokenRequest;
import com.mcphub.domain.workspace.dto.response.LlmTokenResponse;
import com.mcphub.domain.workspace.service.LlmTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LlmTokenAdviser {
    private final LlmTokenService llmTokenService;

    public LlmTokenResponse registerToken(LlmTokenRequest request) {
        return llmTokenService.registerToken(request);
    }

    public LlmTokenResponse updateToken(LlmTokenRequest request) {
        return llmTokenService.updateToken(request);
    }
}
