package com.example.tomcattraining.dao.factory;

import com.example.tomcattraining.dao.RendezVousDao;

public abstract class DaoFactory {
    public static DaoFactory getDAOFactory() {
        DaoFactory daoF = null;
        daoF = new H2Factory();
        return daoF;

    }
    public abstract RendezVousDao getRendezVousDao();
}
