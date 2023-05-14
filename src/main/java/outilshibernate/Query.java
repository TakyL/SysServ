package outilshibernate;

import java.util.ArrayList;
import java.util.List;

public interface Query<T> {

    public abstract List<T> findAllElmt();

}
