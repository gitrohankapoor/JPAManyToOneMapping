package ca.sheridancollege.midterm_raman.service;

import ca.sheridancollege.midterm_raman.model.TelevisionShow;
import ca.sheridancollege.midterm_raman.repository.TelevisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelevisionShowService {
    @Autowired
    TelevisionRepository tvRepository;

    public List<TelevisionShow> findAllShows(){
        return tvRepository.findall();

    }

    public void addTVShowDetail(TelevisionShow televisionShow) {
        tvRepository.insert(televisionShow);
    }

    public void deleteTVShowDetail(String showName) {
        tvRepository.delete(showName);
    }

    public void updateTvShowDetails(TelevisionShow tvShow) {
        tvRepository.update(tvShow);
    }
}
