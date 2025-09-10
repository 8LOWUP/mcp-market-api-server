package umc.product.domain.mcp.converter;

import org.springframework.stereotype.Component;
import umc.product.domain.mcp.dto.response.api.TestResponse;

@Component
public class McpConverter {

    public TestResponse toTestResponse(Long id) {
        return TestResponse.builder()
                .id(id)
                .build();
    }
}
