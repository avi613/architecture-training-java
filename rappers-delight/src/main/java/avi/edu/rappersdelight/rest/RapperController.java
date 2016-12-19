package avi.edu.rappersdelight.rest;

import avi.edu.rappersdelight.rapper.Rapper;
import avi.edu.rappersdelight.rapper.RapperPreview;
import avi.edu.rappersdelight.repository.RapperRepository;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rappers")
public class RapperController {
    private RapperRepository rapperRepository;

    public RapperController(RapperRepository rapperRepository) {
        this.rapperRepository = rapperRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    @JsonView(RapperPreview.class)
    public List<Rapper> getAllRappers() {
        return rapperRepository.getAllRappers();
    }

    @RequestMapping("/{id}")
    public Rapper getRapperById(@PathVariable("id") String id) {
        return rapperRepository.getRapperById(id);
    }
}
