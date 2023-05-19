import com.example.tomcattraining.outils.OutilsDatesHeures;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestDateEtHeures {

    @Test
    public void DateCorrepondBienAuFormatddMMyyyyy()
    {
        String date = "10/10/2010";
        boolean etat = OutilsDatesHeures.isFormatAccepted(date);
        Assertions.assertEquals(true, etat);
    }

    @Test
    public void DateNeCorrepondPasAuFormatddMMyyyyy()
    {
        String date = "10/10/201";
        boolean etat = OutilsDatesHeures.isFormatAccepted(date);
        Assertions.assertEquals(false, etat);
    }

    @Test
    public void DateCorrepondBienAuFormatyyyyMMdd()
    {
        String date = "2010/10/10";
        boolean etat = OutilsDatesHeures.isFormatAccepted(date);
        Assertions.assertEquals(true, etat);
    }

    @Test
    public void DateNeCorrepondPasAuFormatyyyyMMdd()
    {
        String date = "201/10/10";
        boolean etat = OutilsDatesHeures.isFormatAccepted(date);
        Assertions.assertEquals(false, etat);
    }

    @Test
    public void FormatHeureCorrect()
    {
        String heure = "10:10";
        boolean etat = OutilsDatesHeures.VerifieFormatHeure(heure);
        Assertions.assertTrue(etat);
    }


    @Test
    public void FormatHeureIncorrect()
    {
        String heure = "10h0";
        boolean etat = OutilsDatesHeures.VerifieFormatHeure(heure);
        Assertions.assertFalse(etat);
    }

    @Test
    public void VerifieStringNonNull1Para()
    {

        boolean etat = OutilsDatesHeures.verifieStringNonVide("heure");
        Assertions.assertTrue(etat);
    }

    @Test
    public void VerifieStringNonNull1Paranull()
    {

        boolean etat = OutilsDatesHeures.verifieStringNonVide("");
        Assertions.assertFalse(etat);
    }

    @Test
    public void VerifieStringNonNull1Paranullet1ParaCorrect()
    {

        boolean etat = OutilsDatesHeures.verifieStringNonVide("","heure");
        Assertions.assertFalse(etat);
    }

    @Test
    public void VerifieStringNonNull1Paracorrectet1ParaNull()
    {

        boolean etat = OutilsDatesHeures.verifieStringNonVide("heure","");
        Assertions.assertFalse(etat);
    }
}
