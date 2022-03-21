package org.swclsss.mvcproject.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.swclsss.mvcproject.ErrorResponse;
import org.swclsss.mvcproject.chap11.RegisterRequest;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class RestMemberController {
    @Autowired
    private MemberService memberService;

    @GetMapping("/members")
    public Map<String, Member> members() {
        return memberService.searchMembers();
    }

    @GetMapping("/members/{id}")
    public ResponseEntity<Object> member(@PathVariable String id) {
        Member member = memberService.searchMember(id);
        if (member == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse("no member"));
        }
        return ResponseEntity.status(HttpStatus.OK).body(member);
    }

    @PostMapping("/members")
    public ResponseEntity<Object> newMember(@RequestBody @Valid Member member
            , HttpServletResponse response
            , Errors errors) {
        if (errors.hasErrors()) {
            String errorCodes = errors.getAllErrors()
                    .stream()
                    .map(objectError -> objectError.getCodes()[0])
                    .collect(Collectors.joining(","));
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new ErrorResponse("errorCodes = " + errorCodes));
        }
        memberService.insertMember(member);
        response.setHeader("Location","/members/"+member.getId());
        response.setStatus(HttpServletResponse.SC_CREATED);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ErrorResponse("no Error"));
    }
}
