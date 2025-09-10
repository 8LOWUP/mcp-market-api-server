package com.mcphub.domain.workspace.llm.tokenvalidator;

public class AnthropicTokenValidator implements TokenValidator{
    @Override
    public boolean isInvalid(String token) {
        return token == null || token.length() < 20;
    }
}
