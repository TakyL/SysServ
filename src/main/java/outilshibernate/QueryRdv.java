package outilshibernate;

import com.example.tomcattraining.metiers.RendezVous;
import org.hibernate.Session;

import java.util.List;

public class QueryRdv implements Query{
    @Override
    public List findAllElmt() {
        Session session1 = OutilsHibernate.getSession();
        session1.beginTransaction();

        // fetch all RendezVous objects from the database
        List<RendezVous> rendezVousList = session1.createQuery("FROM RendezVous", RendezVous.class).list();

        // iterate over the list of RendezVous objects and add them to the table model
        for (RendezVous rendezVous : rendezVousList) {
            Object[] rowData = { rendezVous.getDate_rdv(), rendezVous.getHeure_rdv(), rendezVous.getNom_client(), rendezVous.getNom_employe() };
        }

        session1.getTransaction().commit();
        return rendezVousList;
    }
}
