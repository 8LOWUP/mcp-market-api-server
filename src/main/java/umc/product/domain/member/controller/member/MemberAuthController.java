package umc.product.domain.member.controller.member;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import umc.product.domain.member.adviser.member.MemberAuthAdviser;
import umc.product.domain.member.entity.Member;
import umc.product.domain.member.entity.enums.LoginType;
import umc.product.domain.member.dto.response.member.auth.MemberCreateTokenResponse;
import umc.product.domain.member.dto.response.member.common.MemberIdResponse;
import umc.product.domain.member.dto.response.member.auth.MemberLoginResponse;
import umc.product.global.common.base.BaseResponse;
import umc.product.global.config.security.auth.CurrentMember;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "일반 사용자(App)용 Member Auth API", description = "일반 사용자(App)용 Member Auth 관련 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/members/auth")
public class MemberAuthController {
    private final MemberAuthAdviser memberAuthAdviser;

    @Operation(summary = "소셜 로그인 API", description = "네이버, 카카오, 구글 로그인을 수행하는 API입니다. 소셜 로그인은 App 전용입니다.")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "App 소셜 로그인 성공"
            )
    })
    @Parameters({
            @Parameter(name = "accessToken", description = "Social에서 발급받은 accessToken(Apple은 id_token)"),
            @Parameter(name = "loginType", description = "Social의 종류"),
    })
    @PostMapping("/social/login")
    public BaseResponse<MemberLoginResponse> socialLogin(
            @RequestHeader(value = "accessToken") String accessToken,
            @RequestParam(value = "loginType") LoginType loginType
    ) {
        return BaseResponse.onSuccess(memberAuthAdviser.socialLogin(accessToken, loginType));
    }

    @Operation(summary = "accessToken 재발급 API", description = "refreshToken가 유효하다면 새로운 accessToken을 발급하는 API입니다.")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "accessToken 재발급 성공"
            )
    })
    @Parameters({
            @Parameter(name = "refreshToken", description = "로그인시 받는 refreshToken"),
    })
    @GetMapping("/token/refresh")
    public BaseResponse<MemberCreateTokenResponse> regenerateToken(
            @RequestHeader(value = "refreshToken") String refreshToken
    ) {
        return BaseResponse.onSuccess(memberAuthAdviser.regenerateToken(refreshToken));
    }

    @Operation(summary = "로그아웃 API", description = "해당 유저의 refreshToken을 삭제하는 API입니다.")
    @DeleteMapping("/logout")
    public BaseResponse<MemberIdResponse> logout(
            @CurrentMember Member member
    ) {
        return BaseResponse.onSuccess(memberAuthAdviser.logout(member));
    }

    @Operation(summary = "회원 탈퇴 API", description = "해당 유저 정보를 삭제하는 API입니다.")
    @DeleteMapping
    public BaseResponse<MemberIdResponse> withdrawal(
            @CurrentMember Member member
    ) {
        return BaseResponse.onSuccess(memberAuthAdviser.withdrawal(member));
    }

}

