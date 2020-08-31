package hello.prac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @PostMapping("/members/new")
    @ResponseBody
    public MemberForm newmapping(@ModelAttribute MemberForm memberForm){
        System.out.println(memberForm.getName());

        return memberForm;
    }
}
