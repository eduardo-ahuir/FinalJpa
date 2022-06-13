package DAO;
import Entidades.Operaciones;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.*;
import java.util.List;

public class OperacionesDAO {
    static Logger log = LogManager.getRootLogger();
    static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("clientes");

    //METODO PARA INSERTAR Operaciones
    public void insertar(Operaciones operaciones) {
        EntityManager em = emfactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(operaciones);
        tx.commit();
        em.close();
    }

    //metodo para encontrar todos los operaciones
    public static List<Operaciones> EncontrarTodos() {
        EntityManager em = emfactory.createEntityManager();
        Query query1 = em.createNamedQuery("Operaciones.findAll", Operaciones.class);
        List<Operaciones> lista = (List<Operaciones>) query1.getResultList();
        em.close();
        return lista;
    }

    //metodo para encontrar una operacion con una cantidad determinada
    public static List<Operaciones> EncontrarPorCantidad(int cantidad) {
        EntityManager em = emfactory.createEntityManager();
        Query query1 = em.createNamedQuery("Operaciones.findByCantidad", Operaciones.class);
        query1.setParameter("cantidad", cantidad);
        List<Operaciones> lista = (List<Operaciones>) query1.getResultList();
        em.close();
        return lista;
    }




}
