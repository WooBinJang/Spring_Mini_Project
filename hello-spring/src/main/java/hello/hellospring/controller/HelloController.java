package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

    @GetMapping("hello") // 인터넷 주소창에 loclahost8080/hello.html이면 ~~ 해라.
    public String hello(Model model){
        model.addAttribute("data","hello!!"); // 키 data / 값 hello!!
        return "hello"; // 키에 값이 들어간 뒤 hello.html 로 리턴함.
    }
    @GetMapping("hello-mvc")  // 인터넷 주소창에 loclahost8080/hello-mvc.html
    public String helloMvc(@RequestParam("name") String name,Model model) {
        model.addAttribute("name",name);
        return "hello-template";
    }
}
