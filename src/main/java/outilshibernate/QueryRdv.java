package outilshibernate;

import com.example.tomcattraining.dao.RendezVousDao;
import com.example.tomcattraining.metiers.RendezVous;
import org.hibernate.Session;

import java.util.List;

import static com.example.tomcattraining.outils.OutilsString.verifieSiChainesEquivalentes;

/**
 * Classe qui gère la logique des query liés au rendez vous
 * fait appel à la classe RendezVousDao pour les appels CRUD + search all d'hibernate pour les requetes liés au rdv
 */
public class QueryRdv implements Query{
    @Override
    public List<RendezVous> findAllElmt() {
        Session session1 = OutilsHibernate.getSession();
        session1.beginTransaction();
        // fetch all RendezVous objects from the database
        List<RendezVous> rendezVousList = session1.createQuery("FROM RendezVous", RendezVous.class).list();

        session1.getTransaction().commit();
        return new RendezVousDao().findAll();
    }

    @Override
    public boolean insertItem(Object item) {
        if(!isAlreadyExisting((RendezVous) item) && !hasAlreadyaRdv((RendezVous) item))
        {
            System.out.println("OK"+item.toString());
            new RendezVousDao().create((RendezVous) item);
            return true;
        }
        return false;
    }


    /**
     * Vérifie si un rendez vous existe déjà dans la base de données
     * @param rdv
     * @return
     */

    private boolean isAlreadyExisting(RendezVous rdv) {

        List<RendezVous> list =findAllElmt();
        for (RendezVous r:list) {
            if(r.getDate_rdv().equals(rdv.getDate_rdv()))//Si date identique
            {
                if(verifieSiChainesEquivalentes(r.getHeure_rdv(),rdv.getHeure_rdv()) && verifieSiChainesEquivalentes(r.getNom_employe(),rdv.getNom_employe()) && verifieSiChainesEquivalentes(rdv.getNom_client(),r.getNom_client()))
                {
                    System.out.println("Ce rendez vous existe déjà");
                    //TODO print au client
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Recherche si le client/employé possède déjà un rendez vous pour cette tranche horaire
     * @param rdv : le rendez vous que l'on veut ajouter
     * @return true si client/employé possède déjà un rendez vous pour cette tranche horaire
     */
    private boolean hasAlreadyaRdv(RendezVous rdv) {

        List<RendezVous> list =findAllElmt();
        for (RendezVous r:list) {
            if(r.getDate_rdv().equals(rdv.getDate_rdv()) && verifieSiChainesEquivalentes(r.getHeure_rdv(), rdv.getHeure_rdv()))//Si date identique et heure identique
            {

                //Si nom est égale ou bien de le nom de l'employé a été trouvé alors il a déjà un rdv pour cette tranche horaire
                if(verifieSiChainesEquivalentes(rdv.getNom_employe(),r.getNom_employe()) || verifieSiChainesEquivalentes(rdv.getNom_client(),r.getNom_client()))//Si le nom d'un employé est egale à ce nom alors
                {
                    System.out.println("L'un de deux utilisateurs possède déjà un rdv");
                    //TODO print au client
                    return true;
                }
            }
        }
        return false;
    }
}
