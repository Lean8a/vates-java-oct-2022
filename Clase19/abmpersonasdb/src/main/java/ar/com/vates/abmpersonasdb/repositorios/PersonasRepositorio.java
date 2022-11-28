package ar.com.vates.abmpersonasdb.repositorios;

import ar.com.vates.abmpersonasdb.dominio.Persona;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.util.Collection;

@Repository
public class PersonasRepositorio {

    @PersistenceContext
    private EntityManager em;

    public PersonasRepositorio()  {
    }

    public Collection<Persona> obtenerTodas() {
        return em.createQuery("select p from Persona p", Persona.class)
                .getResultStream().peek(System.out::println).toList();
    }

    public Persona buscarPorDocumento(int doc) {
        return em.find(Persona.class, doc);
    }

    @Transactional
    public Persona guardarPersona(Persona p)  {
        em.merge(p);
        return p;
    }

    @Transactional
    public boolean borrarPersona(int doc) {
        Persona aBorrar = buscarPorDocumento(doc);
        if (aBorrar != null) em.remove(aBorrar);
        return aBorrar != null;
    }

}
