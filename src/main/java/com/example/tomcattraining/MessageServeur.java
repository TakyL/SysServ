package com.example.tomcattraining;

public class MessageServeur {

    private final String msg_RDV_existe="Ce rendez-vous existe déjà";

    private final String msg_RDV_emp_cl= "L'un de deux utilisateurs possède déjà un rdv";

    static public String msg =null;

    public void setMsg_RDV_existe()
    {
        msg=msg_RDV_existe;
    }

    public void setMsg_RDV_emp_cl()
    {
        msg=msg_RDV_emp_cl;
    }
}
