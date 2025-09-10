package umc.product.domain.mcp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.product.domain.mcp.dto.request.McpDraftRequest;
import umc.product.domain.mcp.dto.request.McpMetaDataRequest;
import umc.product.domain.mcp.dto.request.McpPublishRequest;
import umc.product.domain.mcp.dto.request.McpUrlRequest;
import umc.product.global.common.base.BaseResponse;

@RestController
@RequestMapping("/mcps/dashboard")
@RequiredArgsConstructor
public class McpDashboardController {

	/**
	 * 업로드한 Mcp 상세
	 * @return Mcp 상세 (provider)
	 */
	@GetMapping("/{mcpId}")
	public BaseResponse<String> getUploadMcpDetail(@PathVariable Integer mcpId) {
        return BaseResponse.onSuccess("Mcp 리스트 조회");
	}

	/**
	 * MCP 등록 드래프트 생성
	 * @return 드래프트 생성
	 */
	@PostMapping()
	public BaseResponse<String> createMCPDraft(@RequestBody McpDraftRequest request) {
        return BaseResponse.onSuccess("Mcp 등록 드래프트 생성");
	}

	/**
	 * MCP Url 업로드
	 * @return url 등록
	 */
	@PatchMapping("/{mcpId}/url")
	public BaseResponse<String> uploadMCPUrl(@PathVariable Integer mcpId, @RequestBody McpUrlRequest request) {
		return BaseResponse.onSuccess("Mcp Url 등록");
	}

	/**
	 * MCP 메타 데이터 등록
	 * @return Mcp 메타 데이터 등록
	 */
	@PatchMapping("/{mcpId}/meta")
	public BaseResponse<String> uploadMCpMetaData(@PathVariable Integer mcpId, @RequestBody McpMetaDataRequest request) {
		return BaseResponse.onSuccess("Mcp Meta Data 등록");
	}


	/**
	 * MCP 최종 배포
	 * @return Mcp 최종 배포
	 */
	@PatchMapping("/{mcpId}/publish")
	public BaseResponse<String> publishMCP(@PathVariable Integer mcpId, @RequestBody McpPublishRequest request) {
		return BaseResponse.onSuccess("Mcp 최종 배포");
	}

	/**
	 * MCP 삭제 (provider)
	 * @param mcpId
	 * @return MCP 삭제
	 */
	@DeleteMapping("{mcpId}")
	public BaseResponse<String> deleteMCP(@PathVariable Integer mcpId) {
		return BaseResponse.onSuccess("업로드한 Mcp 삭제");
	}
}
