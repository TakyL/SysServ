package com.example.tomcattraining.outils;

public class OutilsString {
    /**
     * Vérifie si deux chaines sont équivalentes
     * @param str1 : String
     * @param str2 : String
     * @return true si c'est le cas
     */
    public static boolean verifieSiChainesEquivalentes(String str1, String str2) {
        return str1.equals(str2);

    }

    /**
     * Remplace les - par des / si présence
     * est utilisé pour convertir l'ouput de l'input type date envoyé par le client
     * @param datewithtiret : yyyy-mm-dd
     * @return la chaine modifiée
     */
    public static String replacetiretparslash(String datewithtiret)
    {
        if(datewithtiret.contains("/"))
        {
            return datewithtiret.replace("-","/");
        }
        else return datewithtiret;

    }
}
