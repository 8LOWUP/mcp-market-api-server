package umc.product.domain.mcp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.product.domain.mcp.adviser.McpAdviser;
import umc.product.domain.mcp.dto.request.McpListRequest;
import umc.product.domain.mcp.dto.request.McpPurchaseRequest;
import umc.product.domain.mcp.dto.response.api.TestResponse;
import umc.product.global.common.base.BaseResponse;

/**
 * MCP 컨트롤러
 * - MCP 리스트 조회
 * - MCP 상세 조회
 * - MCP 구매/삭제
 * - 내가 등록한 MCP 조회
 */

@RestController
@RequestMapping("/mcps")
@RequiredArgsConstructor
public class McpController {
	McpAdviser mcpAdviser;
	/**
	 * 마켓 -> MCP 리스트
	 * @return 조건에 맞는 MCP 리스트
	 */
	@GetMapping()
	public BaseResponse<String> getMcpList(@ModelAttribute McpListRequest request)
	{
        return BaseResponse.onSuccess("Mcp 리스트 조회");
	}

	/**
	 * MCP 상세 조회
	 * @param mcpId
	 * @return MCP 상세 내용
	 */
	@GetMapping("/{mcpId}")
	public BaseResponse<TestResponse> getMcpDetail(@PathVariable Long mcpId) {
		return BaseResponse.onSuccess(mcpAdviser.getMcpById(mcpId));
	}

	/**
	 * MCP 마켓으로 부터 구매 (저장)
	 * @param mcpId
	 * @return MCP 상세 내용
	 */
	@PostMapping("/{mcpId}")
	public BaseResponse<String> purchaseMcp(@PathVariable Integer mcpId, @RequestBody McpPurchaseRequest request) {
		return BaseResponse.onSuccess("Mcp 저장");
	}

	/**
	 * 구매한 MCP 삭제
	 * @param mcpId MCP ID
	 * @return 삭제 결과
    */
	@DeleteMapping("/{mcpId}")
	public BaseResponse<String> deleteMcp(@PathVariable Integer mcpId) {
		return BaseResponse.onSuccess("구매한 MCP 삭제");
	}

	/**
	 * 등록한 MCP 리스트
	 * @return 등록한 MCP 리스트
	 */
	@GetMapping("/me")
	public BaseResponse<String> getMyUploadMcpList() {
		return BaseResponse.onSuccess("등록한 MCP 리스트 조회");
	}
}
