package com.mcphub.domain.workspace.llm.tokenvalidator;

import com.mcphub.domain.workspace.entity.enums.Llm;

import java.util.Map;

public class TokenValidatorManager {
    private final Map<Llm, TokenValidator> validatorMap = Map.of(
            Llm.GEMINI, new GoogleTokenValidator(),
            Llm.GPT, new OpenAiTokenValidator(),
            Llm.CLAUDE, new AnthropicTokenValidator()
    );

    public boolean isInvalidToken(Llm llm, String token) {
        return validatorMap.getOrDefault(llm, t -> true).isInvalid(token);
    }
}
