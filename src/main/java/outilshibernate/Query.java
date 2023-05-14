package outilshibernate;

import java.util.ArrayList;
import java.util.List;

public interface Query<T> {

    List<T> findAllElmt();

}
