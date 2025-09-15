package com.mcphub.domain.workspace.dto;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record WorkspaceCreateResponse (
        Long userId, // 워크스페이스를 생성한 사용자 아이디
        String title, // 워크스페이스 제목
        LocalDateTime createdAt // 워크스페이스 생성 일자
){}
