package ca.sheridancollege.midterm_raman.repository;

import ca.sheridancollege.midterm_raman.model.TelevisionShow;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TelevisionShowMapper implements RowMapper<TelevisionShow> {
    @Override
    public TelevisionShow mapRow(ResultSet rs, int rowNum) throws SQLException {
        TelevisionShow tvShow = new TelevisionShow();
        tvShow.setShowName(rs.getString("showname"));
        tvShow.setShowDescription(rs.getString("showdescription"));
        tvShow.setShowDay(rs.getString("showday"));
        tvShow.setShowTime(rs.getString("showtime"));
        return tvShow;
    }
}
