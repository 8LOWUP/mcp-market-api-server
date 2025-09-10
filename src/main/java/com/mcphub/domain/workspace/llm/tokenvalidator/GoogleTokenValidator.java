package com.mcphub.domain.workspace.llm.tokenvalidator;

class GoogleTokenValidator implements TokenValidator {
    @Override
    public boolean isInvalid(String token) {
        return token == null || !token.startsWith("g-");
    }
}
