
package dao;


import java.util.List;

public interface DAOInterface<T> {
    //add
    public int insert(T t) ;
    //update
    public int update(T t) ;
    //delete
    public int delete(int t) ;
    //getAll
    public List<T> getAll() ;
    //search random
    public List<T> selectByCondition(String condition) ;
}
