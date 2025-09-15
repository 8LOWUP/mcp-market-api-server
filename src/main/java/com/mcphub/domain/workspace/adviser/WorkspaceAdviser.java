package com.mcphub.domain.workspace.adviser;

import com.mcphub.domain.workspace.dto.WorkspaceCreateRequest;
import com.mcphub.domain.workspace.dto.WorkspaceCreateResponse;
import com.mcphub.domain.workspace.service.WorkspaceService;
import com.mcphub.global.util.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class WorkspaceAdviser {

    private final SecurityUtils securityUtils;

    private final WorkspaceService workspaceService;

    public WorkspaceCreateResponse createWorkspace(WorkspaceCreateRequest request) {
        return workspaceService.createWorkspace(request, securityUtils.getUserId());
    }
}
