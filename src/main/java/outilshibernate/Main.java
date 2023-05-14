package outilshibernate;

import com.example.tomcattraining.metiers.RendezVous;
import com.example.tomcattraining.metiers.Utilisateur;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        try (Session session = OutilsHibernate.getSession()) {
            session.beginTransaction();

            // create a new user
            Utilisateur user = new Utilisateur("John", "Doe");
            Utilisateur user2 = new Utilisateur("Mary","Sue");
            session.save(user);
            session.save(user2);
            RendezVous rdv = new RendezVous(user.getNom(), user2.getNom(), new Date(),"10:10");
            session.save(rdv);

            // retrieve the user from the database
            Query query = session.createQuery("from Utilisateur where nom = :nom");//TODO faire une classe query
            Query query1 = session.createQuery("from RendezVous where heure_rdv = :heure");
            query1.setParameter("heure","10:10");
            query.setParameter("nom", "John");
            Utilisateur retrievedUser = (Utilisateur) query.uniqueResult();
            RendezVous rerievedRdv = (RendezVous) query1.uniqueResult();

            System.out.println("Retireved rdv "+ rerievedRdv);

            System.out.println("Retrieved user: " + retrievedUser);
            session.getTransaction().commit();
        }
    }

    public static void RemplitDatabase()
    {
        System.out.println("Je suis lancé dans le futur");
        try (Session session = OutilsHibernate.getSession()) {
            session.beginTransaction();

            // create a new user
            Utilisateur user = new Utilisateur("John", "Doe");
            Utilisateur user2 = new Utilisateur("Mary","Sue");
            session.save(user);
            session.save(user2);
            RendezVous rdv = new RendezVous(user.getNom(), user2.getNom(), new Date(),"10:11");
            RendezVous rdv1 = new RendezVous("Bonjour","Bonsoir",new Date(),"10:25");
            session.save(rdv);
            session.save(rdv1);


            session.getTransaction().commit();
        }
    }
}
