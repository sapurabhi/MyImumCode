package com.imum.cpms.login;

import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import javax.servlet.http.HttpServletResponse;

public class CacheControlPhaseListener implements PhaseListener {
    public CacheControlPhaseListener() {
        super();
    }

    public void afterPhase(PhaseEvent phaseEvent) {
    }

    public void beforePhase(PhaseEvent phaseEvent) {
        
        FacesContext facesContext = phaseEvent.getFacesContext();     
        HttpServletResponse response = (HttpServletResponse) facesContext.getExternalContext().getResponse();
        response.addHeader("Pragma", "no-cache");  
        response.addHeader("Cache-Control", "no-cache");     
        response.addHeader("Cache-Control", "no-store");
        response.addHeader("Cache-Control", "must-revalidate");        
    }

    public PhaseId getPhaseId() {
        return null;
    }
}
