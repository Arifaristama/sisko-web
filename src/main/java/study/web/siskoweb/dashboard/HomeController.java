package study.web.siskoweb.dashboard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dashboard")
public class HomeController {

    @GetMapping
    public String home() {
        return "pages/dashboard/home";
    }
}
