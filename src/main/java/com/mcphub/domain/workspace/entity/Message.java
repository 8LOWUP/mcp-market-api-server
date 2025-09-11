package com.mcphub.domain.workspace.entity;

import com.mcphub.global.common.base.BaseEntity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "message")
@Getter
@Setter
public class Message extends BaseEntity {

    @Id
    private String id;

    private String workspaceId;
    private String message;
    private boolean senderType;
}
