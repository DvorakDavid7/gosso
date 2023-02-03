package example.oauth;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
class ApplicationController {

    @GetMapping("/")
    public String index() {
        return "forward:index.html";
    }
}
