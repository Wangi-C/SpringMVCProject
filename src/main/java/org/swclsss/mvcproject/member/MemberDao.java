package org.swclsss.mvcproject.member;

import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Repository
public class MemberDao {
    private static Map<String, Member> memberMap;

    static {
        memberMap = new HashMap<String, Member>();
        memberMap.put("abc",new Member("abc", "123", 12, LocalDateTime.of(2021, 12, 12, 03, 30,22)));
        memberMap.put("dbf",new Member("dbf", "123", 23, LocalDateTime.of(2019, 11, 12, 12, 32,22)));
        memberMap.put("ghi",new Member("ghi", "123", 34, LocalDateTime.of(2020, 01, 21, 01, 40,12)));
        memberMap.put("jkl",new Member("jkl", "123", 10, LocalDateTime.of(2018, 12, 11, 13, 31,21)));
    }

    public void insertMember(Member member) {
        memberMap.put(member.getId(), member);
    }

    public Map<String, Member> searchMember() {
        return memberMap;
    }

    public Member searchMember(String id) {
        return memberMap.get(id);
    }
}
