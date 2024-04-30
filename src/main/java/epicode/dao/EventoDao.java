package epicode.dao;

import epicode.entity.Evento;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class EventoDao {

    private EntityManager em;

    public EventoDao(EntityManager em){
        this.em = em;
    }
    public void save(Evento evento){
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.merge(evento);
        et.commit();
    }

    public Evento getById(int id){
        Evento s = em.find(Evento.class, id);
        return s;
    }

    public void delete(Evento evento){
        EntityTransaction et = em.getTransaction();
        et.begin();
        em.remove(em.merge(evento));
        et.commit();
    }
}
