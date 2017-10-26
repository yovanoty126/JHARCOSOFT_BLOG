/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhovanyardila.bean;

import com.jhovanyardila.datamodel.DataModelTablaUno;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author yovanoty126
 */
@Named(value = "tablaConLazyDataModelBean")
@ViewScoped
public class TablaConLazyDataModelBean implements Serializable {

    @PersistenceContext(unitName = "com.jhovanyardila_EjemploLazyDataModel_war_1.0PU")
    private EntityManager em;
    private DataModelTablaUno dataModelTablaUno;
    
    @PostConstruct
    public void init(){
        dataModelTablaUno=new DataModelTablaUno(em);
    }

    public DataModelTablaUno getDataModelTablaUno() {
        return dataModelTablaUno;
    }

    public void setDataModelTablaUno(DataModelTablaUno dataModelTablaUno) {
        this.dataModelTablaUno = dataModelTablaUno;
    }

}
