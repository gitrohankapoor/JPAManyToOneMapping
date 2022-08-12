package ca.sheridancollege.midterm_raman.repository;

import ca.sheridancollege.midterm_raman.model.TelevisionShow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TelevisionRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<TelevisionShow> findall() {
        return jdbcTemplate.query("select * from TELEVISIONSHOW", new TelevisionShowMapper());
    }
    public int delete(String showName) {
        return jdbcTemplate.update("delete from TELEVISIONSHOW where showname=?", new Object[] {
                showName
        });
    }

    public int insert(TelevisionShow tvShow) {
        return jdbcTemplate.update("insert into TELEVISIONSHOW (showname,showdescription,showday,showtime) " + "values(?,?,?,?)",
                new Object[] {
                        tvShow.getShowName(), tvShow.getShowDescription(), tvShow.getShowDay(),tvShow.getShowTime()
                });
    }

    public int update(TelevisionShow tvShow) {
        return jdbcTemplate.update("update TELEVISIONSHOW " + " set showdescription = ?, showday = ?, showtime=? " + " where showname = ?",
                new Object[] {
                        tvShow.getShowDescription(), tvShow.getShowDay(), tvShow.getShowTime(),tvShow.getShowName()
                });
    }
}
