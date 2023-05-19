import com.example.tomcattraining.outils.OutilsDatesHeures;
import com.example.tomcattraining.outils.OutilsString;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestOutilsString {

    @Test
    public void VerifieEqualiteStringCorrect()
    {

        boolean etat = OutilsString.verifieSiChainesEquivalentes("heure","heure");
        Assertions.assertTrue(etat);
    }

    @Test
    public void VerifieEqualiteStringinCorrect()
    {

        boolean etat = OutilsString.verifieSiChainesEquivalentes("heure","heures");
        Assertions.assertFalse(etat);
    }

    @Test
    public void VerifieEqualiteStringinInCorrectAvecNull()
    {

        boolean etat = OutilsString.verifieSiChainesEquivalentes("heure",null);
        Assertions.assertFalse(etat);
    }
}
