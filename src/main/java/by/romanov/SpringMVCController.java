package by.romanov;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class SpringMVCController {
    @GetMapping("/")
    public String Index(Model model){
        return this.GetStr(model);
    }

    @GetMapping("/{controller}")
    public String Index(@PathVariable("controller") String controller, Model model){
        return this.GetStr(model);
    }

    @GetMapping("/{controller}/{action}")
    public String Index(@PathVariable("controller") String controller, @PathVariable("action") String action, Model model){
        return this.GetStr(model);
    }

    private String GetStr(Model model){
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("hh:mm:ss");

        model.addAttribute("msg", "Hello World!");
        model.addAttribute("date", formatForDateNow.format(dateNow));
        model.addAttribute("authorName", "Roman Romanov");
        return "index";
    }
}
