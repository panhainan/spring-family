package site.sixteen.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class MainController {

    @RequestMapping({"/index", "/"})
    public String index() {
        log.info("index method");
        return "index";
    }

}
