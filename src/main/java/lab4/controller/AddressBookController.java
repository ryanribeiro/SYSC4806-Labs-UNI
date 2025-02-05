package lab4.controller;

import lab4.model.BuddyInfo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddressBookController {

    @GetMapping("/addNewBuddy")
    public String greeting(Model model) {
        model.addAttribute("buddy", new BuddyInfo());
        return "addNewBuddy";
    }
}
