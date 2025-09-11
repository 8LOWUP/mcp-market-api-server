package com.mcphub.domain.workspace.service;

import com.mcphub.domain.workspace.dto.request.LlmTokenRequest;
import com.mcphub.domain.workspace.dto.response.LlmTokenResponse;

public interface LlmTokenService {
    LlmTokenResponse registerToken(LlmTokenRequest request);
    LlmTokenResponse updateToken(LlmTokenRequest request);
}
