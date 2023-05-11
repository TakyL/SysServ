package outilshibernate;

import com.example.tomcattraining.metiers.Utilisateur;
import org.hibernate.Session;
import org.hibernate.query.Query;

public class Main {

    public static void main(String[] args) {
        try (Session session = OutilsHibernate.getSession()) {
            session.beginTransaction();

            // create a new user
            Utilisateur user = new Utilisateur("John", "Doe");
            session.save(user);

            // retrieve the user from the database
            Query query = session.createQuery("from Utilisateur where nom = :nom");//TODO faire une classe query
            query.setParameter("nom", "John");
            Utilisateur retrievedUser = (Utilisateur) query.uniqueResult();

            System.out.println("Retrieved user: " + retrievedUser);
            session.getTransaction().commit();
        }
    }
}
