package com.mcphub.domain.workspace.service;

import com.mcphub.domain.workspace.dto.WorkspaceCreateRequest;
import com.mcphub.domain.workspace.dto.WorkspaceCreateResponse;
import com.mcphub.domain.workspace.dto.request.ChatRequest;
import com.mcphub.domain.workspace.dto.response.ChatResponse;

public interface WorkspaceService {

    WorkspaceCreateResponse createWorkspace(WorkspaceCreateRequest request, Long userId);
    ChatResponse sendChat(Long workspaceId, Long userId, ChatRequest request);
}
