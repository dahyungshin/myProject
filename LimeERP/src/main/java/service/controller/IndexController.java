package service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class IndexController {

    @RequestMapping("/")
    public String main() {
        return "Common/main";
    }
}
