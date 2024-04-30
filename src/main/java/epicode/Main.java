package epicode;

import epicode.dao.EventoDao;
import epicode.entity.Evento;
import epicode.entity.TipoEvento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("eventi_jpa");
        EntityManager em = emf.createEntityManager();

        EventoDao dao = new EventoDao(em);

        Evento e1 = new Evento();

        e1.setTitolo("Concerto");
        e1.setDataEvento(LocalDate.of(2000,8,5));
        e1.setDescrizione("Evento pubblico all'insegna del divertimento");
        e1.setTipoEvento(TipoEvento.PUBBLICO);
        e1.setNumeroMassimoPartecipanti(300);

        dao.save(e1);

        Evento e2 = dao.getById(1);
        System.out.println(e2);

        Evento e3 = new Evento();

        e3.setTitolo("Partita di calcio");
        e3.setDataEvento(LocalDate.of(2024,4,5));
        e3.setDescrizione("Evento privato");
        e3.setTipoEvento(TipoEvento.PRIVATO);
        e3.setNumeroMassimoPartecipanti(50000);
        dao.save(e3);

        dao.delete(e1);

    }
}
