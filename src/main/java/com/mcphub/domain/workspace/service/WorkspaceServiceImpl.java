package com.mcphub.domain.workspace.service;

import com.mcphub.domain.workspace.dto.WorkspaceCreateRequest;
import com.mcphub.domain.workspace.dto.WorkspaceCreateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class WorkspaceServiceImpl implements WorkspaceService {

    @Override
    @Transactional
    public WorkspaceCreateResponse createWorkspace(WorkspaceCreateRequest request, Long userId) {
        // workspace 테이블에 입력

        // workspace_user_mcp 테이블에 입력

    }
}
