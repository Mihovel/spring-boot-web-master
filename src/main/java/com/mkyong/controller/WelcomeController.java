package com.mkyong.controller;

import com.mkyong.service.ProcessinHuman;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;

@Controller
public class WelcomeController {

    @Autowired
    ProcessinHuman processinHuman;

    // inject via application.properties
    @Value("${welcome.message}")
    private String message;

    private List<String> tasks = Arrays.asList("a", "b", "c", "d", "e", "f", "g");

    @GetMapping("/")
    public String main(Model model) {
        model.addAttribute("message", message);
        model.addAttribute("tasks", tasks);
        String s = processinHuman.processHuman();
        System.out.println("s = " + s);
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder append = stringBuilder.append("123").append("\n").append("1222");
        String s1 = append.toString();
        return "welcome"; //view
    }

    // /hello?name=kotlin
    @GetMapping("/hello")
    public String mainWithParam(
            @RequestParam(name = "name", required = false, defaultValue = "") String name,
            @RequestParam(name = "surname", required = false, defaultValue = "") String surname,
            Model model) {

        model.addAttribute("message", name);
        model.addAttribute("messagesur", surname);

        return "welcome"; //view
    }

}