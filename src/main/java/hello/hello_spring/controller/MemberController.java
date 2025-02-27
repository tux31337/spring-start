package hello.hello_spring.controller;

import hello.hello_spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    //필드 주입 : 중간에 바꿀수 있는 방법없음.
//    @Autowired private final MemberService memberService;

    // setter 주입 : public하게 set 메서드가 있어서 좋지않음, 로딩시점에 바꾸는건지 setting되면 바꿀일이 없음
//    private final MemberService memberService;
//
//    @Autowired
//    public void setMemberService(MemberService memberService) {
//        this.memberService = memberService;
//    }

    // 생성자 주입
    private final MemberService memberService;
    
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
