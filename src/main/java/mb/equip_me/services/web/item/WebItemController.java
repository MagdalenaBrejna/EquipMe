package mb.equip_me.services.web.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.logging.Logger;

@Controller
public class WebItemController {

    @Autowired
    protected WebItemService itemService;

    protected Logger logger = Logger.getLogger(mb.equip_me.services.web.item.WebItemController.class.getName());

    public WebItemController(WebItemService itemService) {
        this.itemService = itemService;
    }

    @RequestMapping("/item")
    public String home() {
        return "index";
    }
}
