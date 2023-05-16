package outilshibernate;

import com.example.tomcattraining.metiers.RendezVous;

import java.util.ArrayList;
import java.util.List;

public interface Query<T> {

    /**
     * Renvoie tous les éléments d'une table sous la forme d'une list<objet>
     * @return
     */

    public List<T> findAllElmt();

    public boolean insertItem(T item);

}
