package com.mcphub.domain.mcp.dto.response.api;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class McpResponse {
	private Long id;
	private String name;
	private String version;
	private String description;
	private String imageUrl;
	private Boolean isKeyRequired;

	// 연관 엔티티
	private String categoryName;
	private String platformName;
	private String licenseName;

	// 리뷰 관련
	private Float averageRating;

	// 저장 관련
	private Integer savedUserCount;

	// 최초 등록일
	private LocalDateTime publishedDate;
}
