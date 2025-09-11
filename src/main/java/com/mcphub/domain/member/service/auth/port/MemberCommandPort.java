package com.mcphub.domain.member.service.auth.port;

import com.mcphub.domain.member.dto.response.readmodel.MemberRM;

public interface MemberCommandPort {
	MemberRM saveOrUpdate(String email, String nickname);
}
