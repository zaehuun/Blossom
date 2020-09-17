package hello.prac.controller;

import hello.prac.Domain.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
public class HomeController {

    @RequestMapping("/")
    public String home(){
        return "home";
    }

    @RequestMapping("/list")
    public List<Student> studentList(){
        System.out.println("list");
        List<Student> students = null;
        return students;
    }
}
