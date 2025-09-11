package com.mcphub.domain.workspace.service;

import com.mcphub.domain.workspace.dto.WorkspaceCreateRequest;
import com.mcphub.domain.workspace.dto.WorkspaceCreateResponse;

public interface WorkspaceService {

    WorkspaceCreateResponse createWorkspace(WorkspaceCreateRequest request, Long userId);
}
