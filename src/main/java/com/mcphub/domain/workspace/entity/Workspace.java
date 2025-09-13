package com.mcphub.domain.workspace.entity;

import com.mcphub.global.common.base.BaseEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "workspace")
@Getter
@Setter
@Builder
public class Workspace extends BaseEntity {

    @Transient
    public static final String SEQUENCE_NAME = "workspace_sequence";

    @Id
    private Long id;
    private String llmId;   // bigint -> String
    private String userId;  // bigint -> String
    private String title;   // text

    // ================= MCP 배열 필드 =================
    // MCP ID와 활성화 여부를 함께 저장
    private List<McpInfo> mcps = new ArrayList<>();

    @Getter
    @Setter
    @Builder
    public static class McpInfo {
        private String mcpId;
        private boolean active;
    }
}