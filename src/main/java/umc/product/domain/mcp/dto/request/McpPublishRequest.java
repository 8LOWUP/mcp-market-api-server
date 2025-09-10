package umc.product.domain.mcp.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class McpPublishRequest {
	private String version;       // 버전
    private String releaseNotes;  // 릴리즈 노트
    private boolean isPublic;     // 공개 여부?
    private Integer publisherId;  // 배포자 ID
}
