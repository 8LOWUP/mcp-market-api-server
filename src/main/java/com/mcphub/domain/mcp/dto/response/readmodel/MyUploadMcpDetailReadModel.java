package com.mcphub.domain.mcp.dto.response.readmodel;

import com.mcphub.domain.mcp.dto.response.api.McpToolResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MyUploadMcpDetailReadModel {
	private Long id;
	private String name;
	private String version;
	private String description;
	private String imageUrl;
	private String sourceUrl;
	private Boolean isKeyRequired;

	private Long categoryId;
	private String categoryName;
	private Long platformId;
	private String platformName;
	private Long licenseId;
	private String licenseName;

	private Float averageRating;     // null 가능
	private Integer savedUserCount;
	private boolean isPublished;
	private LocalDateTime createdAt;
	private LocalDateTime updatedAt;
	private List<McpToolResponse> tools;
}
