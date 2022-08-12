package ca.sheridancollege.midterm_raman.controllers.rest;

import ca.sheridancollege.midterm_raman.model.TelevisionShow;
import ca.sheridancollege.midterm_raman.service.TelevisionShowService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/tv")
public class TVResourceController {

    @Autowired
    TelevisionShowService showService;

    @GetMapping("/shows")
    public List<TelevisionShow> getShowDetails(){
        List<TelevisionShow> tvShows =  showService.findAllShows();
        return tvShows;
    }

    @PostMapping("/addShow")
    public ResponseEntity<String> addShowDetails(@RequestBody TelevisionShow televisionShow){
        try {
            showService.addTVShowDetail(televisionShow);
            return ResponseEntity.ok().body("Successfully Added");
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/updateShow/{id}")
    public ResponseEntity<String> updateShowDetails(@PathVariable(value="id") String id,@RequestBody TelevisionShow televisionShow){
        showService.updateTvShowDetails(televisionShow);
        return ResponseEntity.ok().body("Successfully updated");
    }
 }
