package com.mcphub.domain.workspace.entity;

import com.mcphub.global.common.base.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "workspace_user_mcp")
@Getter
@Setter
public class WorkspaceUserMcp extends BaseEntity {

    @Transient
    public static final String SEQUENCE_NAME = "workspace_user_mcp_sequence";

    @Id
    private Long id;
    private String workspaceId;  // bigint -> String
    private String mcpId;        // bigint -> String
    private boolean isActivated; // boolean
}