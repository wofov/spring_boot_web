package spring.edd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String hello(Model model) {
        System.out.println("-");
        model.addAttribute("data", "hi");
        return "hello.html";
    }

    @GetMapping("/hi")
    public String mvc(@RequestParam(required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "tem";
    }

    @GetMapping("string")
    @ResponseBody
    public String helloString(@RequestParam String name) {
        return "hello" + name;
    }

    @GetMapping("/api")
    @ResponseBody
    public Hello helloApi(@RequestParam String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello{
        private String name;
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }



}
