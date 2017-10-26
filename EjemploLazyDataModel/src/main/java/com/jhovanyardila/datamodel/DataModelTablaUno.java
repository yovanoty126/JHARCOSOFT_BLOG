/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jhovanyardila.datamodel;

import com.jhovanyardila.entidades.TablaUno;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 *
 * @author yovanoty126
 */
public class DataModelTablaUno extends LazyDataModel<TablaUno> {

    private EntityManager em;

    public DataModelTablaUno(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<TablaUno> load(int first, int pageSize, String sortField, SortOrder sortOrder, Map<String, Object> filters) {
        setRowCount((int) (long) contarRegistros(first, pageSize, filters));
        return buscarRegistros(first, pageSize, filters);
    }

    private List<TablaUno> buscarRegistros(int first, int pageSize, Map<String, Object> filters) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<TablaUno> query = cb.createQuery(TablaUno.class);
        Root<TablaUno> info = query.from(TablaUno.class);
        query.select(info);
        List<Predicate> crit = new ArrayList<>();
        if (filters != null && !filters.isEmpty()) {
            if (filters.get("tablaUnoId") != null) {
                try {
                    ParameterExpression<Integer> param = cb.parameter(Integer.class, "tablaUnoId");
                    crit.add(cb.equal(info.<Integer>get("tablaUnoId"), param));
                } catch (NumberFormatException ex) {
                    System.out.println(ex.getMessage());
                }
            }
            if (filters.get("nombre") != null) {
                ParameterExpression<String> param = cb.parameter(String.class, "nombre");
                crit.add(cb.like(info.<String>get("nombre"), param));
            }
            if (filters.get("ciudad") != null) {
                ParameterExpression<String> param = cb.parameter(String.class, "ciudad");
                crit.add(cb.like(info.<String>get("ciudad"), param));
            }
            if (filters.get("documentoNumero") != null) {
                ParameterExpression<String> param = cb.parameter(String.class, "documentoNumero");
                crit.add(cb.like(info.<String>get("documentoNumero"), param));
            }
            if (filters.get("carro") != null) {
                ParameterExpression<String> param = cb.parameter(String.class, "carro");
                crit.add(cb.like(info.<String>get("carro"), param));
            }
            if (crit.size() == 1) {
                query.where(crit.get(0));
            } else if (crit.size() > 1) {
                query.where(cb.and(crit.toArray(new Predicate[0])));
            }
            TypedQuery<TablaUno> q = em.createQuery(query);
            if (filters.get("tablaUnoId") != null) {
                try {
                    q.setParameter("tablaUnoId", filters.get("tablaUnoId"));
                } catch (NumberFormatException ex) {
                    System.out.println(ex.getMessage());
                }
            }
            if (filters.get("nombre") != null) {
                q.setParameter("nombre", "%" + filters.get("nombre") + "%");
            }
            if (filters.get("ciudad") != null) {
                q.setParameter("ciudad", "%" + filters.get("ciudad") + "%");
            }
            if (filters.get("documentoNumero") != null) {
                q.setParameter("documentoNumero", "%" + filters.get("documentoNumero") + "%");
            }
            if (filters.get("carro") != null) {
                q.setParameter("carro", "%" + filters.get("carro") + "%");
            }
            q.setFirstResult(first);
            q.setMaxResults(pageSize);
            return q.getResultList();
        } else {
            TypedQuery<TablaUno> q = em.createQuery(query);
            q.setFirstResult(first);
            q.setMaxResults(pageSize);
            return q.getResultList();
        }
    }

    private Long contarRegistros(int first, int pageSize, Map<String, Object> filters) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Long> query = cb.createQuery(Long.class);
        Root<TablaUno> info = query.from(TablaUno.class);
        query.select(cb.count(info));
        List<Predicate> crit = new ArrayList<>();
        if (filters != null && !filters.isEmpty()) {
            if (filters.get("tablaUnoId") != null) {
                try {
                    ParameterExpression<Integer> param = cb.parameter(Integer.class, "tablaUnoId");
                    crit.add(cb.equal(info.<Integer>get("tablaUnoId"), param));
                } catch (NumberFormatException ex) {
                    System.out.println(ex.getMessage());
                }
            }
            if (filters.get("nombre") != null) {
                ParameterExpression<String> param = cb.parameter(String.class, "nombre");
                crit.add(cb.like(info.<String>get("nombre"), param));
            }
            if (filters.get("ciudad") != null) {
                ParameterExpression<String> param = cb.parameter(String.class, "ciudad");
                crit.add(cb.like(info.<String>get("ciudad"), param));
            }
            if (filters.get("documentoNumero") != null) {
                ParameterExpression<String> param = cb.parameter(String.class, "documentoNumero");
                crit.add(cb.like(info.<String>get("documentoNumero"), param));
            }
            if (filters.get("carro") != null) {
                ParameterExpression<String> param = cb.parameter(String.class, "carro");
                crit.add(cb.like(info.<String>get("carro"), param));
            }
            if (crit.size() == 1) {
                query.where(crit.get(0));
            } else if (crit.size() > 1) {
                query.where(cb.and(crit.toArray(new Predicate[0])));
            }
            TypedQuery<Long> q = em.createQuery(query);
            if (filters.get("tablaUnoId") != null) {
                try {
                    q.setParameter("tablaUnoId", filters.get("tablaUnoId"));
                } catch (NumberFormatException ex) {
                    System.out.println(ex.getMessage());
                }
            }
            if (filters.get("nombre") != null) {
                q.setParameter("nombre", "%" + filters.get("nombre") + "%");
            }
            if (filters.get("ciudad") != null) {
                q.setParameter("ciudad", "%" + filters.get("ciudad") + "%");
            }
            if (filters.get("documentoNumero") != null) {
                q.setParameter("documentoNumero", "%" + filters.get("documentoNumero") + "%");
            }
            if (filters.get("carro") != null) {
                q.setParameter("carro", "%" + filters.get("carro") + "%");
            }
            q.setFirstResult(first);
            q.setMaxResults(pageSize);
            return q.getSingleResult();
        } else {
            TypedQuery<Long> q = em.createQuery(query);
            q.setFirstResult(first);
            q.setMaxResults(pageSize);
            return q.getSingleResult();
        }
    }

}
