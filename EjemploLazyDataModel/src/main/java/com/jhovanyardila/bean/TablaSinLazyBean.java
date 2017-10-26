/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhovanyardila.bean;

import com.jhovanyardila.entidades.TablaUno;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author yovanoty126
 */
@Named(value = "tablaSinLazyBean")
@ViewScoped
public class TablaSinLazyBean implements Serializable{

    @PersistenceContext(unitName = "com.jhovanyardila_EjemploLazyDataModel_war_1.0PU")
    private EntityManager em;
    private List<TablaUno> listaTabla;

    @PostConstruct
    public void init() {
        listaTabla = em.createNamedQuery("TablaUno.findAll").getResultList();
    }

    /**
     * Creates a new instance of TablaSinLazyBean
     */
    public TablaSinLazyBean() {
    }

    public List<TablaUno> getListaTabla() {
        return listaTabla;
    }

    public void setListaTabla(List<TablaUno> listaTabla) {
        this.listaTabla = listaTabla;
    }

}
