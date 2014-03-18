import java.util.List;

/**
 * @author Chen Haoming
 */
public interface GenericDao<T, PK> {

    T save (T t);

    T get (PK pk);

    boolean delete (PK pk);

    List<T> save (List<T> list);

    int delete (List<T> list);

    List<T> find (T t);

    Object executeSQL(String sql);
}
