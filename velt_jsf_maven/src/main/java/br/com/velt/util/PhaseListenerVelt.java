/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.velt.util;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import org.hibernate.Session;

/**
 *
 *
 */
public class PhaseListenerVelt implements PhaseListener {

    @Override
    public void beforePhase(PhaseEvent fase) {
        
       
        if (fase.getPhaseId().equals(PhaseId.RESTORE_VIEW)) {
             System.out.println("Depois da Fase: "+getPhaseId());
            Session session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            FacesContextUtil.setRequestSession(session);
        }

    }

    @Override
    public void afterPhase(PhaseEvent fase) {
        System.out.println("Antes da Fase: "+getPhaseId());
        if (fase.getPhaseId().equals(PhaseId.RENDER_RESPONSE)) {

            Session session = FacesContextUtil.getRequestSession();

            try {
                session.getTransaction().commit();

            } catch (Exception e) {
                if (session.getTransaction().isActive()) {

                    session.getTransaction().rollback();
                }
            } finally {

                session.close();
            }

        }

    }

    @Override
    public PhaseId getPhaseId() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
