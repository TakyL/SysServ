package com.example.tomcattraining.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class listenerone implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        // Code to run when the web application starts up
        event.getServletContext().log("Listener lancée");
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        // Code to run when the web application shuts down
        event.getServletContext().log("Listener arrêt");
    }
}
