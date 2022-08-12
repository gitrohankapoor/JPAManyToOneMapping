package ca.sheridancollege.midterm_raman.controllers;

import ca.sheridancollege.midterm_raman.model.TelevisionShow;
import ca.sheridancollege.midterm_raman.service.TelevisionShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TelevisionShowController {

    @Autowired
    TelevisionShowService tvService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/getShowDetails")
    public String getShowDetails(Model model){
        model.addAttribute("tvShowDetails",tvService.findAllShows());
        return "showDetails";
    }

    @GetMapping("/addShowDetails")
    public String addShowDetails(Model model){
        TelevisionShow tvShow = new TelevisionShow();
        model.addAttribute("tvShow",tvShow);
        return "addShowDetails";
    }
    @PostMapping("/submitMovie")
    public String saveShowDetails(@ModelAttribute("tvShow") TelevisionShow tvShow){
        tvService.addTVShowDetail(tvShow);
        return "submitSuccess";
    }
    @PostMapping("/showDelete")
    public String deleteShowDetails(@ModelAttribute("showName") String showName){
        tvService.deleteTVShowDetail(showName);
        return "deleteSuccess";
    }
    @PostMapping("/showUpdate")
    public String updateShowDetails(Model model,@ModelAttribute("tvShow") TelevisionShow tvShow){
        model.addAttribute("tvShow",tvShow);
        return "updateShowDetails";
    }
    @PostMapping("/updateMovie")
    public String updateShowDetails(@ModelAttribute("tvShow") TelevisionShow tvShow){
        tvService.updateTvShowDetails(tvShow);
        return "updateSuccess";
    }
    @GetMapping("/error")
    public String error(){
        return "error";
    }
}
