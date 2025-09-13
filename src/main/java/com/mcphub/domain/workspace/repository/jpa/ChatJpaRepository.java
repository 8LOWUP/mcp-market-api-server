package com.mcphub.domain.workspace.repository.jpa;

import com.mcphub.domain.workspace.entity.Chat;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChatJpaRepository extends MongoRepository<Chat, String> {

}
