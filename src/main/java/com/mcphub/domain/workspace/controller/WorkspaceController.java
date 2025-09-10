package com.mcphub.domain.workspace.controller;

import com.mcphub.domain.workspace.adviser.WorkspaceAdviser;
import com.mcphub.global.common.base.BaseResponse;
import com.mcphub.global.config.security.auth.CurrentMember;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@Tag(name = "워크스페이스 API", description = "워크스페이스 인스턴스 CRUD API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/workspaces")
public class WorkspaceController {

    private final WorkspaceAdviser workspaceAdviser;

    @Operation(summary = "워크스페이스 생성 API", description = "새로운 워크스페이스 생성에 사용하는 API")
    @ApiResponses({
            @ApiResponse(responseCode = "", description = "")
    })
    @PostMapping()
    public BaseResponse<?> createWorkspace(
            @CurrentMember Object member
    ) {
        return BaseResponse.onSuccess(workspaceAdviser.createWorkspace(member));
    }

    @Operation(summary = "워크스페이스 목록 조회 API", description = "워크스페이스 목록을 조회할 때 사용하는 API")
    @ApiResponses({
            @ApiResponse(responseCode = "", description = "")
    })
    @GetMapping()
    public BaseResponse<?> getWorkspaceList() {
        return null;
    }

    @Operation(summary = "워크스페이스 조회 API", description = "특정 워크스페이스에 대한 상세 정보를 조회할 때 사용하는 API")
    @ApiResponses({
            @ApiResponse(responseCode = "", description = "")
    })
    @GetMapping(path = "/{workspaceId}")
    public BaseResponse<?> getWorkspace() {
        return null;
    }

    @Operation(summary = "워크스페이스 수정 API", description = "워크스페이스 정보(ex. 워크스페이스 이름)를 수정할 때 사용하는 API")
    @ApiResponses({
            @ApiResponse(responseCode = "", description = "")
    })
    @PatchMapping(path = "/{workspaceId}")
    public BaseResponse<?> modifyWorkspace() {
        return null;
    }

    @Operation(summary = "워크스페이스 삭제 API", description = "워크스페이스를 삭제할 때 사용하는 API")
    @ApiResponses({
            @ApiResponse(responseCode = "", description = "")
    })
    @DeleteMapping(path = "/{workspaceId}")
    public BaseResponse<?> deleteWorkspace() {
        return null;
    }

}
