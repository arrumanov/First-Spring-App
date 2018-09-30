package by.romanov;

import org.apache.commons.lang3.SerializationUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class SpringMVCController {
    @GetMapping("/t")
    public String Index(Model model){
        return this.GetStr(model);
    }

//    @GetMapping("/{controller}")
//    public String Index(@PathVariable("controller") String controller, Model model){
//        return this.GetStr(model);
//    }
//
//    @GetMapping("/{controller}/{action}")
//    public String Index(@PathVariable("controller") String controller, @PathVariable("action") String action, Model model){
//        return this.GetStr(model);
//    }

    private String GetStr(Model model){
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("hh:mm:ss");

        model.addAttribute("msg", "Hello World!");
        model.addAttribute("date", formatForDateNow.format(dateNow));
        model.addAttribute("authorName", "Roman Romanov");
        return "index";
    }

    @GetMapping("/")
    public String Age(){
        return "age";
    }

    @RequestMapping(value = "/birthday", method = RequestMethod.POST, produces = "application/json")
    //@PostMapping("/birthday")
    @ResponseBody
    public String Birthday(@RequestBody String birthday){
        Date date = new Date();
        try {
            date = DateUtils.parseDate( birthday, new String[] {"dd-MM-yy", "dd/MM/yy", "dd-MM-yyyy", "dd/MM/yyyy" });
        } catch (ParseException e) {
            e.printStackTrace();
        }

        DateFormat dateFormat=new SimpleDateFormat("MM.dd.yyyy");
        String s = dateFormat.format(date);

        return "{\"success\": \""+s+"\" }";
    }
}
