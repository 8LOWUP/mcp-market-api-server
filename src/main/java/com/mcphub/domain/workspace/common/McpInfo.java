package com.mcphub.domain.workspace.common;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class McpInfo {
    private String id;
    private boolean active;
}