/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.velt.util;

import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import java.lang.Object;
import org.hibernate.SessionFactory;

/**
 *
 * @author marcio
 */
public class HibernateUtil {
    
    private static final SessionFactory sessionFactory;
    public static final String HIBERNATE_SESSION = "hibernate_session";
    
    static {
        try {
            
            System.out.println("Configurando SF");
            Configuration configuration = new Configuration().configure();
            
            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
            
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            
            System.out.println("SF configurada com sucesso!");            
            
            
        } catch (Exception ex) {
            
            System.out.println("Ocorreu um erro ao iniciar a SF"+ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
}
