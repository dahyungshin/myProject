package service.controller;

import domain.spec.RestInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/rest")
public class RestController {

    private RestInfoService restInfoService;

    public RestController(RestInfoService restInfoService) {
        this.restInfoService = restInfoService;
    }

    @RequestMapping("/")
    public String list() {
        return "rest/list";
    }

    @RequestMapping("/form")
    public String form() {
        return "rest/form";
    }
}
