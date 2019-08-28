package service;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.*;
import java.util.*;

import entities.EmployeeEntity;

/**
 * Session Bean implementation class EmployeeEJB
 */
@Stateless
@LocalBean
public class EmployeeEJB {


	@PersistenceContext
	private EntityManager em;
	
    public EmployeeEJB() {
        // TODO Auto-generated constructor stub
    	
    }
    
    public void addNew(EmployeeEntity employeeEntity)
    {    	        
        em.getTransaction().begin();
        em.persist(employeeEntity);
        em.getTransaction().commit();
    }
    
    public List<EmployeeEntity> findEmployees()
    {
    	List<EmployeeEntity> employees = em.createQuery("SELECT * FROM tbl_employees").getResultList();
    	return employees;
    }
}
