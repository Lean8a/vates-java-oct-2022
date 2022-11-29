package ar.com.vates.abmpersonasdb.repositorios;

import ar.com.vates.abmpersonasdb.dominio.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface PersonasRepository extends JpaRepository<Persona, Integer> {

    Collection<Persona> getPersonasByOrderByApellidoAscNombreAsc();

    Collection<Persona> getPersonasByApellidoEqualsIgnoreCaseOrderByNombreAsc(String filtro);

    Collection<Persona> getPersonasByEdadBetweenOrderByNombreAsc(int minimo, int maximo);
}
