package mb.equip_me.services.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.logging.Logger;

@Controller
public class WebUserController {

    @Autowired
    protected WebUserService userService;

    protected Logger logger = Logger.getLogger(WebUserController.class.getName());

    public WebUserController(WebUserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String home() {
        return "index";
    }
}
