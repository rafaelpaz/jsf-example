package br.com.test;

import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Named
@ViewScoped
public class TestBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private SomeService service;

    @Inject
    private FacesContext context;

    private String uuid;

    public void newUUID() {
        this.uuid = UUID.randomUUID().toString() + " - " + LocalDateTime.now();
    }

    public String getServiceMessage() {
        return service.getMessage();
    }

    public String getContextString() {
        return context.toString();
    }

    public String getUuid() {
        return uuid;
    }

}
