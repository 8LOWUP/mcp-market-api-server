package com.mcphub.domain.mcp.dto.response.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MyUploadMcpResponse {
	private Long id;
	private String name;
	private String version;
	private String description;
	private String imageUrl;
	private String categoryName;
	private String platformName;
	private String licenseName;
	private LocalDateTime updatedAt;
	private LocalDateTime createdAt;
}
