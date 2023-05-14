package com.example.tomcattraining.enumuration;

public enum Role {

    EMPLOYE(1,"Employé"),
    CLIENT(2,"Client");


    private final int id;

    private final String designation;

    Role(int id,String designation)
    {
        this.id=id;
        this.designation=designation;
    }

    public int getId() {
        return id;
    }

    public String getDesignation() {
        return designation;
    }
}
