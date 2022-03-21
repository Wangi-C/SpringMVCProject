package org.swclsss.mvcproject.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class MemberService {
    @Autowired
    private MemberDao memberDao;

    public void insertMember(Member member) {
        member.setRegisterDateTime(LocalDateTime.now());
        memberDao.insertMember(member);
    }

    public Map<String, Member> searchMembers() {
        return memberDao.searchMember();
    }

    public Member searchMember(String id) {
        return memberDao.searchMember(id);
    }
}
