package com.mcphub.domain.mcp.repository;

import com.mcphub.domain.mcp.entity.License;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LicenseRepository extends JpaRepository<License, Long> {
}
