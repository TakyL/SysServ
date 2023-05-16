package com.example.tomcattraining.outils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class OutilsDatesHeures {


    /**
     * Vérifie si une date est bien au format dd/mm/yyyy
     * @return
     */
    static public boolean isFormatddMMyyyy(String formatdate)
    {
        String regex = "^\\d{2}/\\d{2}/\\d{4}$";
        return Pattern.matches(regex, formatdate);
    }

    /**
     * Formatte un string date au format dd/mm/yyyy si besoin
     * @param input : String au format yyyy/mm/dd
     * @return Date au format dd/mm/yyyy
     */
    static public String formateDate(String input)
    {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        dateFormat.setLenient(false);

        return FormateDateYYYYMMDDtoDDMMYYYY(input);

    }

    /**
     * Formatte une date dd/mm/yyyy , conversion au format yyyy/mm/dd au format dd/mm/yyyy si besoin
     * @param input : Date au format yyyy/mm/dd
     * @return Date au format dd/mm/yyyy
     * @throws RuntimeException si le format saisi ne correspond ni à dd/mm/yyyy
     */
    static private String FormateDateYYYYMMDDtoDDMMYYYY(String input) {
        SimpleDateFormat inputDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if(isFormatYYYYMMDD(input))
            {
                Date date = inputDateFormat.parse(input);
                SimpleDateFormat outputDateFormat = new SimpleDateFormat("dd/MM/yyyy");
                return outputDateFormat.format(date);
            }
            else if(isFormatddMMyyyy(input))//La date est est déjà au bon format
            {
                return input;
            }

            throw new RuntimeException("Le système n'a pas réussi à convertir la date ");
        } catch (ParseException e) {
            throw new RuntimeException("Erreur lors de la conversion en yyyy" + input);
        }
    }

    static private boolean isFormatYYYYMMDD(String string)
    {
        String regex = "^\\d{4}/\\d{2}/\\d{2}$";
        return Pattern.matches(regex, string);
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
