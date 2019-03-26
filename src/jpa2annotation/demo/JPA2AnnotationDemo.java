/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpa2annotation.demo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import jpa2annotation.demo.domain.Address;
import jpa2annotation.demo.domain.SoftwareEngineer;

/**
 *
 * @author berek
 */
public class JPA2AnnotationDemo {
    
    private EntityManagerFactory emf;
    private EntityManager em;
    
    public JPA2AnnotationDemo() {
        this.emf = Persistence.createEntityManagerFactory("JPA2Annotation-DemoPU");
        this.em = emf.createEntityManager();
    }
    
    public  <T> void persist(T t) {
        if(null != t) {
            EntityTransaction tx = em.getTransaction();
            tx.begin();
            em.persist(t);
            System.out.println("Entity persisted");
            tx.commit();
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        JPA2AnnotationDemo demo = new JPA2AnnotationDemo();
        Address addr1 = new Address("Dearborn", "MI", "USA");
        SoftwareEngineer se1 = new SoftwareEngineer("Bereket", "Yetera", addr1);
        
        System.out.println("object created ");
        
        demo.persist(se1);
        
        System.out.println("entity persisted successfully");
    }
    
}
