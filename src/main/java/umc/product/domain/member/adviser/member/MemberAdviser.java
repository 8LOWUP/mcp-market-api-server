package umc.product.domain.member.adviser.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import umc.product.domain.file.dto.FileCreateResponse;
import umc.product.domain.file.service.FileService;
import umc.product.domain.member.converter.response.MemberConverter;
import umc.product.domain.member.dto.response.member.common.MemberIdResponse;
import umc.product.domain.member.entity.Member;
import umc.product.domain.member.service.member.MemberService;

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
