package com.mcphub.domain.workspace.llm.tokenvalidator;

class OpenAiTokenValidator implements TokenValidator {
    @Override
    public boolean isInvalid(String token) {
        return token == null || token.length() < 20;
    }
}
