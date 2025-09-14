package com.mcphub.domain.workspace.service;

import com.mcphub.domain.workspace.dto.McpUrlTokenPair;
import com.mcphub.domain.workspace.dto.WorkspaceCreateRequest;
import com.mcphub.domain.workspace.dto.WorkspaceCreateResponse;
import com.mcphub.domain.workspace.dto.request.ChatRequest;
import com.mcphub.domain.workspace.dto.response.ChatResponse;
import com.mcphub.domain.workspace.entity.enums.Llm;
import com.mcphub.domain.workspace.llm.chatSender.ChatSenderManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WorkspaceServiceImpl implements WorkspaceService {
    private final ChatSenderManager chatSenderManager;

    @Override
    @Transactional
    public WorkspaceCreateResponse createWorkspace(WorkspaceCreateRequest request, Long userId) {
        // workspace 테이블에 입력

        // workspace_user_mcp 테이블에 입력
        return null;

    }

    @Override
    public ChatResponse sendChat(Long workspaceId, Long userId, ChatRequest request) {
        //workspaceId와 userId로 유저가 활성화한 mcp 리스트 가져오기
        List<Long> mcpIdList = null;
        List<String> mcpUrlList = null;
        //mcp 리스트에 있는 mcpId와 userId로 mcp token 값 가져오기
        List<String> mcpTokenList = null;

        String llmToken = null;
        List<McpUrlTokenPair> mcpUrlTokenList = null;

        //메시지와 mcpUrl, mcpToken 값과 llmToken 값으로 llm API에 요청
        String response = chatSenderManager.getResponse(llmToken, mcpUrlTokenList, request.chatMessage(), request.llmId());

        return new ChatResponse(response);
    }
}
