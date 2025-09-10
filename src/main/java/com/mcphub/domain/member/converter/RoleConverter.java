package com.mcphub.domain.member.converter;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import com.mcphub.global.config.security.auth.enums.Role;

@Converter(autoApply = true)
public class RoleConverter implements AttributeConverter<Role, Integer> {
    @Override
    public Integer convertToDatabaseColumn(
            Role role
    ) {
        return role != null ? role.getPriority() : null;
    }

    @Override
    public Role convertToEntityAttribute(
            Integer priority
    ) {
        if (priority == null) {
            return null;
        }
        for (Role role : Role.values()) {
            if (role.getPriority() == priority) {
                return role;
            }
        }
        throw new IllegalArgumentException("Unknown priority: " + priority);
    }
}