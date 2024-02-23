package spring.edd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    @GetMapping("/hello")
    public String hello(Model model){
        System.out.println("-");
        model.addAttribute("data","hi");
        return "hello.html";
    }
    @GetMapping("/hi")
    public String mvc(@RequestParam(required = false) String name, Model model){
        model.addAttribute("name",name);
        return "tem";
    }
}
