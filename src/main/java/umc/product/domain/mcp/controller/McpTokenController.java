package umc.product.domain.mcp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.product.domain.mcp.dto.request.McpTokenRequest;
import umc.product.global.common.base.BaseResponse;

/**
 * MCP 토큰 관리 컨트롤러
 * MCP 토큰 저장 및 수정 기능을 제공합니다.
 */

@RestController
@RequestMapping("/mcps/token")
@RequiredArgsConstructor
public class McpTokenController {
	/**
	 * MCP 토큰 저장
	 * @return 토큰 저장 성공
	 */
	@PostMapping()
	public BaseResponse<String> saveMcpToken(@RequestBody McpTokenRequest request) {
        return BaseResponse.onSuccess("Mcp 토큰 저장");
	}

	/**
	 * MCP 토큰 수정
	 * @return 토큰 수정 성공
	 */
	@PatchMapping()
	public BaseResponse<String> updateMcpToken(@RequestBody McpTokenRequest request) {
		return BaseResponse.onSuccess("Mcp 토큰 수정");
	}
}
