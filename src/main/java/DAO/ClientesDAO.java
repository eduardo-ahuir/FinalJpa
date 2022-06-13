package DAO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import Entidades.*;

import javax.persistence.*;
import java.util.List;

public class ClientesDAO {
    static Logger log = LogManager.getRootLogger();
    static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("clientes");




    //METODO PARA INSERTAR Clientes potenciales
    public void insertar(Clientes Clientesd) {

        EntityManager em = emfactory.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        em.persist(Clientesd);
        tx.commit();

        em.close();


    }

    //metodo para encontrar todos los clientes
    public List<Clientes> EncontrarTodos() {
        EntityManager em = emfactory.createEntityManager();
        Query query1 = em.createNamedQuery("Clientes.findAll", Clientes.class);
        List<Clientes> lista = (List<Clientes>) query1.getResultList();
        em.close();
        return lista;
    }

    //metodo para encontrar un cliente por su nombre
    public List<Clientes> EncontrarPorNombre(String nombre) {
        EntityManager em = emfactory.createEntityManager();
        Query query1 = em.createNamedQuery("Clientes.findByNombre", Clientes.class);
        query1.setParameter("nombre", nombre);
        List<Clientes> lista = (List<Clientes>) query1.getResultList();
        em.close();
        return lista;
    }


}

    


