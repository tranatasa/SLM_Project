package com.example.SLM.Project.Maintenance;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

    @GetMapping("/api/message")
    public String ok(){
        return "Everything works as aspected!";
    }
}
