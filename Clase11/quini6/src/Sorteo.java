import java.util.*;

public class Sorteo {

    private Set<Integer> sorteados;
    private Map<Integer, Apuesta> apuestas;

    public Sorteo() {
        sorteados = new TreeSet<>();
        apuestas = new HashMap<>();
    }

    public boolean agregarApuesta(Apuesta nueva) {
        return apuestas.put(nueva.getBoleta(), nueva) == null;
    }

    public boolean agregarSorteado(int sorteado) {
        return sorteados.add(sorteado);
    }

    public Set<Apuesta> ganadoras() {
        Set<Apuesta> salida = new HashSet<>();
        for(Apuesta ap: apuestas.values()) {
            if (ap.esGanadora(this.sorteados))
                salida.add(ap);
        }

        return salida;
    }

    public Apuesta buscarApuesta(int númeroBoleta) {
        return apuestas.get(númeroBoleta);
    }
    
    public int cantidadAciertos(int númeroBoleta) {
        Apuesta encontrada = buscarApuesta(númeroBoleta);
        if (encontrada != null) return encontrada.contarAciertos(sorteados);
        return -1;
    }
    
    public int[] aciertosXCantidad() {
        int []cant = {0,0,0,0,0,0,0};
        for(Apuesta ap: apuestas.values()) {
            int ca = ap.contarAciertos(sorteados);
            cant[ca]++;
        }
        
        return cant;

    }
    
    
    @Override
    public String toString() {
        return sorteados.toString();
    }
}
