/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhovanyardila.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author yovanoty126
 */
@Entity
@Table(name = "tabla_uno")
@NamedQueries({
    @NamedQuery(name = "TablaUno.findAll", query = "SELECT t FROM TablaUno t")
    , @NamedQuery(name = "TablaUno.findByTablaUnoId", query = "SELECT t FROM TablaUno t WHERE t.tablaUnoId = :tablaUnoId")
    , @NamedQuery(name = "TablaUno.findByNombre", query = "SELECT t FROM TablaUno t WHERE t.nombre = :nombre")
    , @NamedQuery(name = "TablaUno.findByCiudad", query = "SELECT t FROM TablaUno t WHERE t.ciudad = :ciudad")
    , @NamedQuery(name = "TablaUno.findByDocumentoNumero", query = "SELECT t FROM TablaUno t WHERE t.documentoNumero = :documentoNumero")
    , @NamedQuery(name = "TablaUno.findByCarro", query = "SELECT t FROM TablaUno t WHERE t.carro = :carro")})
public class TablaUno implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tabla_uno_id")
    private Integer tablaUnoId;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "ciudad")
    private String ciudad;
    @Column(name = "documento_numero")
    private Integer documentoNumero;
    @Size(max = 45)
    @Column(name = "carro")
    private String carro;

    public TablaUno() {
    }

    public TablaUno(Integer tablaUnoId) {
        this.tablaUnoId = tablaUnoId;
    }

    public Integer getTablaUnoId() {
        return tablaUnoId;
    }

    public void setTablaUnoId(Integer tablaUnoId) {
        this.tablaUnoId = tablaUnoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public Integer getDocumentoNumero() {
        return documentoNumero;
    }

    public void setDocumentoNumero(Integer documentoNumero) {
        this.documentoNumero = documentoNumero;
    }

    public String getCarro() {
        return carro;
    }

    public void setCarro(String carro) {
        this.carro = carro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tablaUnoId != null ? tablaUnoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TablaUno)) {
            return false;
        }
        TablaUno other = (TablaUno) object;
        if ((this.tablaUnoId == null && other.tablaUnoId != null) || (this.tablaUnoId != null && !this.tablaUnoId.equals(other.tablaUnoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.jhovanyardila.entidades.TablaUno[ tablaUnoId=" + tablaUnoId + " ]";
    }
    
}
