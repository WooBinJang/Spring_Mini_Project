package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello") // 인터넷 주소창에 localhost:8080/hello.html이면 ~~ 해라.
    public String hello(Model model){
        model.addAttribute("data","hello!!"); // 키 data / 값 hello!!
        return "hello"; // 키에 값이 들어간 뒤 hello.html 로 리턴함.
    }
    @GetMapping("hello-mvc")  // 인터넷 주소창에 localhost:8080/hello-mvc.html => 오류 발생 뒤에 ?name=mvc 추가(get 방식)
    public String helloMvc(@RequestParam("name") String name,Model model) {
        model.addAttribute("name",name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody // http 통신 포로토콜에 있는 header/ body에서 boby 에 데이터를 직접 넣어주겠다.
    public String helloString (@RequestParam("name") String name){
        return "hello" +name; // hello Jang!!
    } // view 이런거 없이 바로 값을 반환함 html 소스가 없음 api 는 객체를 반환 할 때 대부분 쓰인다.

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello; // {"name":"Jang!!!"} - { key : value } 구조 => json 파일 구조
    }

    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }  // Bean 구조

}
