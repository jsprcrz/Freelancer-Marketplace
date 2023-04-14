package coe692.lab5.registeredUser.endpoint;

import coe692.lab5.registeredUser.business.Messaging;

import io.kubemq.sdk.basic.ServerAddressNotSuppliedException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLException;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyAppServletContextListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent arg0) {
        System.out.println("ServletContextListener destroyed");
    }

    @Override
    public void contextInitialized(ServletContextEvent arg0) {
        Runnable r = new Runnable() {
            public void run() {

                try {
                    Messaging.Receiving_Events_Store("job_channel");
                } catch (SSLException ex) {
                    Logger.getLogger(MyAppServletContextListener.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ServerAddressNotSuppliedException ex) {
                    Logger.getLogger(MyAppServletContextListener.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        new Thread(r).start();
    }
}
