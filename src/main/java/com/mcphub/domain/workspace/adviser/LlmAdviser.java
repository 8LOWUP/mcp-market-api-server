package com.mcphub.domain.workspace.adviser;

import com.mcphub.domain.workspace.dto.request.LlmTokenRequest;
import com.mcphub.domain.workspace.dto.response.LlmResponse;
import com.mcphub.domain.workspace.dto.response.LlmTokenResponse;
import com.mcphub.domain.workspace.service.LlmService;
import com.mcphub.global.util.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class LlmAdviser {
    private final LlmService llmService;
    private final SecurityUtils securityUtils;

    public List<LlmResponse> getLlmList() {
        return llmService.getLlmList();
    }

    public LlmTokenResponse registerToken(LlmTokenRequest request) {
        Long userId = securityUtils.getUserId();
        return llmService.registerToken(request, userId);
    }

    public LlmTokenResponse updateToken(LlmTokenRequest request)  {
        Long userId = securityUtils.getUserId();
        return llmService.updateToken(request, userId);
    }
}
