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

    public LlmTokenResponse registerToken(String accessToken, LlmTokenRequest request) {
        return llmTokenService.registerToken(accessToken, request);
    }

    public LlmTokenResponse updateToken(String accessToken, LlmTokenRequest request) {
        return llmTokenService.updateToken(accessToken, request);
    }
}
