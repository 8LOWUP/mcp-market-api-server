package com.mcphub.domain.workspace.service;

import com.mcphub.domain.workspace.dto.request.LlmTokenRequest;
import com.mcphub.domain.workspace.dto.response.LlmResponse;
import com.mcphub.domain.workspace.dto.response.LlmTokenResponse;
import com.mcphub.domain.workspace.entity.enums.Llm;

import java.util.List;

public interface LlmService {
    List<LlmResponse> getLlmList();
    LlmTokenResponse getToken(Llm llmId, Long userId);
    LlmTokenResponse registerToken(LlmTokenRequest request, Long userId);
    LlmTokenResponse updateToken(LlmTokenRequest request, Long userId);
}
