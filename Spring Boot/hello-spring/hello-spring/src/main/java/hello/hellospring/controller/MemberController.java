package hello.hellospring.controller;


import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private MemberService memberService;

    //필드 주입
    //좋지는 않음, 중간에 바꾸기가 까다로움
    //@Autowired private MemberService memberService;


    //setter 방식
    //단점 : public이라 중간에 바꾸면 문제 됨, 한 번 세팅하먄 바꿀 일 없으므로..
    //public이라 계속 불려서 변경 될 수도 있음
    // @Autowired
    //public void setMemberService(MemberService memberService){
    //    this.memberService = memberService;
    //}


    //생성자 주입
    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";

    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members",members);
        return "members/memberList";
    }

}
