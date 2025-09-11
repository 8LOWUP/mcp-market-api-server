package com.mcphub.domain.member.service.auth.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mcphub.domain.member.dto.response.readmodel.MemberRM;
import com.mcphub.domain.member.entity.Member;
import com.mcphub.domain.member.repository.Jpa.MemberRepository;
import com.mcphub.domain.member.service.auth.port.MemberCommandPort;
import com.mcphub.domain.member.service.auth.port.MemberQueryPort;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberAuthServiceImpl implements MemberCommandPort, MemberQueryPort {

	private final MemberRepository memberRepository;

	@Override
	@Transactional
	public MemberRM saveOrUpdate(String email, String nickname) {
		Member member = memberRepository.findByEmail(email)
			.orElseGet(() -> memberRepository.save(
				Member.builder()
					.email(email)
					.nickname(nickname)
					.build()
			));
		return new MemberRM(member.getId(), member.getEmail(), member.getNickname());
	}

	@Override
	public Optional<MemberRM> findByEmail(String email) {
		return memberRepository.findByEmail(email)
			.map(m -> new MemberRM(m.getId(), m.getEmail(), m.getNickname()));
	}

}

