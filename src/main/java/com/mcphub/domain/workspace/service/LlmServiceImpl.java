package com.mcphub.domain.workspace.service;

import com.mcphub.domain.workspace.dto.request.LlmTokenRequest;
import com.mcphub.domain.workspace.dto.response.LlmResponse;
import com.mcphub.domain.workspace.dto.response.LlmTokenResponse;
import com.mcphub.domain.workspace.entity.enums.Llm;
import com.mcphub.domain.workspace.llm.tokenvalidator.TokenValidatorManager;
import com.mcphub.domain.workspace.status.LlmErrorStatus;
import com.mcphub.global.common.exception.RestApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LlmServiceImpl implements LlmService {
    TokenValidatorManager tokenValidatorManager;

    @Override
    public List<LlmResponse> getLlmList() {
        return null;
    }

    @Override
    public LlmTokenResponse getToken(Llm llmId, Long userId) {
        //llm token 존재 여부 확인
        //llm token 반환

        return null;
    }

    public LlmTokenResponse registerToken(LlmTokenRequest request, Long userId) {
        //llmToken 유효성 확인
        if (tokenValidatorManager.isInvalidToken(request.llmId(), request.llmToken()))
            throw new RestApiException(LlmErrorStatus.INVALID_LLM_TOKEN);

        //이미 유저가 등록한지 확인
        //DB에 저장
        return new LlmTokenResponse(null, null);
    }

    public LlmTokenResponse updateToken(LlmTokenRequest request, Long userId) {
        //llmToken 유효성 확인
        if (tokenValidatorManager.isInvalidToken(request.llmId(), request.llmToken()))
            throw new RestApiException(LlmErrorStatus.INVALID_LLM_TOKEN);

        //유저가 등록한 기록이 있는지 확인
        //DB 업데이트
        return new LlmTokenResponse(null, null);
    }
}
