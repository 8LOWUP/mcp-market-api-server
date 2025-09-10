package umc.product.domain.mcp.mapper;

import org.springframework.stereotype.Component;
import umc.product.domain.mcp.dto.response.api.TestResponse;
import umc.product.domain.mcp.dto.response.readmodel.TestReadDto;
import umc.product.domain.mcp.entity.Mcp;

@Component
public class McpMapper {

	 public TestReadDto testMapper(Mcp mcp){
        return TestReadDto.builder()
            .id(mcp.getId())
            .build();
	 }
}
