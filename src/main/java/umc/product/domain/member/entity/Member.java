package umc.product.domain.member.entity;

import umc.product.domain.member.converter.RoleConverter;
import umc.product.domain.member.entity.enums.LoginType;
import umc.product.domain.member.entity.enums.Role;
import umc.product.domain.member.entity.enums.Status;
import jakarta.persistence.*;
import lombok.*;
import umc.product.global.common.base.BaseEntity;


@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {
    // todo: 엔티티 추가되면 매핑 추가
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    @Convert(converter = RoleConverter.class)
    @Column(nullable = false)
    private Role role;

    private String name;

    private String email;

    private String clientId;

    @Enumerated(EnumType.STRING)
    private LoginType loginType;

    @Setter
    private String avatarUrl;

    @Setter
    @Enumerated(EnumType.STRING)
    private Status status;

    public void changeRole(Role role) {
        this.role = role;
    }

}