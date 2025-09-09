package com.mcphub.domain.member.adviser.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import com.mcphub.domain.file.dto.FileCreateResponse;
import com.mcphub.domain.file.service.FileService;
import com.mcphub.domain.member.converter.response.MemberConverter;
import com.mcphub.domain.member.dto.response.member.common.MemberIdResponse;
import com.mcphub.domain.member.entity.Member;
import com.mcphub.domain.member.service.member.MemberService;

@Component
@RequiredArgsConstructor
public class MemberAdviser {
    private final MemberService memberService;
    private final FileService fileService;

    private final MemberConverter memberConverter;


    public MemberIdResponse modifyMyProfileAvatar(
            Member member,
            MultipartFile file
    ) {
        FileCreateResponse fileCreateResponse = fileService.createFile("avatar", file);
        memberService.modifyMyProfileAvatar(member, fileCreateResponse.getUrl());
        return  memberConverter.toMemberIdResponse(member.getId());
    }
}
