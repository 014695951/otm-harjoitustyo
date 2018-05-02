package DAO;

import java.util.List;

public interface DAO {

    void create(Nimimerkki nimimerkki) ;

    void delete(Integer id) ;

    List<Nimimerkki> getAll() ;

}
