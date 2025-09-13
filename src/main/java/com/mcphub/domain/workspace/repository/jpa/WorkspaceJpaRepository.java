package com.mcphub.domain.workspace.repository.jpa;

import com.mcphub.domain.workspace.entity.Workspace;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface WorkspaceJpaRepository extends MongoRepository<Workspace, String> {

    Optional<Workspace> findTopByUserIdAndDeletedAtOrderByCreatedAtDesc(String userId, LocalDateTime deletedAt);

    List<Workspace> findByUserIdAndDeletedAtOrderByCreatedAtDesc(String userId, LocalDateTime deletedAt);
}
