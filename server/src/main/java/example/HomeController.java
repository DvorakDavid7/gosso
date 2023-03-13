package example;


import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Authentication authentication, Model model, HttpServletResponse response, HttpServletRequest request) {
        System.out.println(authentication.getName());
        String token = "sometokenstring";
        Cookie cookie = new Cookie("my-token", token);
        cookie.setHttpOnly(true);
        response.addCookie(cookie);
        return "forward:/index.html";
    }
}