package ir;

import login.DBOper;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author      COlegulNostruCu Imdb
 * @version     1.6                 (current version number of program)
 * @since       1.2          (the version of the package this class was first added to)
 * clasa pentru lucrul cu filme salvate in db
 */


public class MovieOper {

    private List<MovieBean> listOfMovies = new ArrayList<>();


    /**
     * aceasta metoda face ce-i place
     *
     *
     */
    public List getListOfMovies() throws ClassNotFoundException, SQLException {

        Class.forName("org.postgresql.Driver");


        Connection conn = DriverManager.getConnection(DBOper.URL, DBOper.USERNAME, DBOper.PASSWORD);

        PreparedStatement pSt = conn.prepareStatement("SELECT * FROM movies order by data desc");
        ResultSet rs = pSt.executeQuery();
        while (rs.next()) {
            MovieBean ir = new MovieBean();
            ir.setId(rs.getInt("id"));
            ir.setName(rs.getString("name"));
            ir.setPoster(rs.getString("imgpath"));
            ir.setUrlyoutube(rs.getString("youtubepath"));
            listOfMovies.add(ir);
        }

        pSt.close();
        conn.close();

        return listOfMovies;
    }
}





