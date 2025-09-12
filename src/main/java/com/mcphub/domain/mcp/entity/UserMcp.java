package com.mcphub.domain.mcp.entity;

import com.mcphub.global.common.base.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "user_mcp")
public class UserMcp extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 사용자 테이블이 별도라면 Long으로 들고가고, 엔티티가 있다면 @ManyToOne으로 교체하세요.
    @Column(name = "user_id", nullable = false)
    private Long userId;

    // FK(mcp_id)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mcp_id", nullable = false)
    private Mcp mcp;

    @Column(name = "mcp_token", nullable = false, columnDefinition = "TEXT")
    private String mcpToken;
}
