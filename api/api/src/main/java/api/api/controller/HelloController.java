package api.api.controller;

import api.api.model.mo;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping(value="/helloworld/string")
    @ResponseBody
    public String helloworldString(){
        return "helloworld";
    }

    @GetMapping(value="/helloworld/json")
    @ResponseBody
    public Hello helloworldJson(){
        Hello hello = new Hello();
        hello.message = "helloworld";
        return hello;
    }

    @PostMapping(value="/request")
    @ResponseBody
    public mo aa(@RequestBody mo m){
        return m;
    }

    @GetMapping(value="helloworld/page")
    public String helloworldpage(){
        return "helloworld";
    }
    @Setter
    @Getter
    public static class Hello{
        private String message;

    }
}
