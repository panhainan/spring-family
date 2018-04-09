package site.sixteen.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import site.sixteen.entity.Card;

import javax.validation.Valid;

@Slf4j
@Controller
public class CardController {

    @RequestMapping(value = "/addCard", method = RequestMethod.GET)
    public String addCard(Model model) {
        model.addAttribute("card", new Card());
        return "addCard";
    }


    @RequestMapping(value = "/addCard", method = RequestMethod.POST)
    public String addCard(@Valid Card card, Errors errors, Model model) {
        log.info("{}", card);
        if (errors.hasErrors()) {
            return "addCard";
        }
        model.addAttribute("card", card);
        return "addCardSuccess";
    }
}
