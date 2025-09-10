package com.mcphub.global.config.security.auth.dto;

import com.mcphub.global.config.security.auth.enums.Role;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class AuthMember {
    private Long id;
    private Role role;
    private LocalDateTime deletedAt;
}
