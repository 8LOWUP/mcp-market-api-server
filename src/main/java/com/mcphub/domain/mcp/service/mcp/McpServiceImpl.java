package com.mcphub.domain.mcp.service.mcp;

import com.mcphub.domain.mcp.dto.request.McpListRequest;
import com.mcphub.domain.mcp.dto.request.MyUploadMcpRequest;
import com.mcphub.domain.mcp.dto.response.readmodel.McpReadModel;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.mcphub.domain.mcp.dto.response.readmodel.TestReadDto;
import com.mcphub.domain.mcp.entity.Mcp;
import com.mcphub.domain.mcp.mapper.McpMapper;
import com.mcphub.domain.mcp.repository.McpRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class McpServiceImpl implements McpService {

	private final McpMapper mcpMapper;
	private final McpRepository mcpRepository;

	@Override
	public Mcp addMcp() {
		return null;
	}

	@Override
	public TestReadDto getMcpById(Long id) {
		Mcp mcp = mcpRepository.findById(id).orElse(null);
		return mcpMapper.testMapper(mcp);
	}

	@Override
	public List<Mcp> getAllMcps() {
		return null;
	}

	@Override
	public void deleteMcpById(Long id) {

	}

	@Override
	public Mcp updateMcp() {
		return null;
	}

	;

	@Override
	public McpReadModel getMcpDetail(Long id) {
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public Page<McpReadModel> getMcpList(Pageable pageable, McpListRequest req) {
		// 검색/필터/정렬은 추후 Specification/QueryDSL로 확장
		Page<Mcp> mcps = mcpRepository.findAll(pageable);

		return mcps.map(mcp -> {
			// 리뷰 평균/저장 수 계산
			Float avgRating = mcpReviewRepository.getAverageRating(mcp.getId());
			Integer savedUserCount = userMcpRepository.getSavedUserCount(mcp.getId());

			return McpReadModel.builder()
			                   .id(mcp.getId())
			                   .name(mcp.getName())
			                   .version(mcp.getVersion())
			                   .description(mcp.getDescription())
			                   .imageUrl(mcp.getImageUrl())
			                   .sourceUrl(mcp.getSourceUrl())
			                   .isKeyRequired(mcp.getIsKeyRequired())

			                   .categoryId(mcp.getCategory().getId())
			                   .categoryName(mcp.getCategory().getName())
			                   .platformId(mcp.getPlatform().getId())
			                   .platformName(mcp.getPlatform().getName())
			                   .licenseId(mcp.getLicense().getId())
			                   .licenseName(mcp.getLicense().getName())

			                   .averageRating(avgRating)
			                   .savedUserCount(savedUserCount)
			                   .isPublished(mcp.getIsPublished())
			                   .publishedAt(mcp.getPublishedAt())
			                   .createdAt(mcp.getCreatedAt())
			                   .updatedAt(mcp.getUpdatedAt())
			                   .build();
		});
	}

	@Override
	public Long saveUserMcp(Long mcpId) {
		return null;
	}

	@Override
	public Long deleteMcp(Long mcpId) {
		return null;
	}

	@Override
	public Page<McpReadModel> getMyUploadMcpList(Long userId, Pageable pageable, MyUploadMcpRequest request) {
		return null;
	}

}
