package com.example.tomcattraining.outils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OutilsDatesHeures {


    /**
     * Vérifie si l'input est bien au format spécifié
     * @return
     */
    static public boolean isDateFormatted(Date dateformat)
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        formatter.setLenient(false); // disable lenient parsing
        String dateString = formatter.format(dateformat);
        return dateString.equals(formatter.format(dateString));
    }

    /**
     * Formatte un string date au format dd/mm/yyyy
     * @param input
     * @return
     */
    static public Date formateDate(String input)
    {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {

           return formatter.parse(input);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        throw new RuntimeException("Le formattage de la date n'a pas réussi ! ");
    }

    /**
     * Vérifie le format de l'heure
     * @param input
     * @return
     */
    static public boolean VerifieFormatHeure(String input)
    {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
        formatter.setLenient(false); // disable lenient parsing
        try {
            Date time = formatter.parse(input);
           if(time!=null)return true;
        } catch (ParseException e) {
            System.out.println("Invalid time format");
        }

        return false;
    }

    /**
     * Vérifie que les strings ne sont pas vides
     * @param para
     * @return true si tous les strings sont saisies et non vide
     */
    public static boolean verifieStringNonVide(String... para) {
        for (String s : para) {
            if (s.trim() == null || s.trim().isEmpty()) {
                return false;
            }
        }
        return true;
    }
}
