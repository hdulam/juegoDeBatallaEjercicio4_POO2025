import java.util.*;

class Batalla {
    private Jugador jugador;
    private List<Enemigo> enemigos;
    private List<String> log = new ArrayList<>();

    public Batalla(Jugador jugador, List<Enemigo> enemigos) {
        this.jugador = jugador;
        this.enemigos = enemigos;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public List<Enemigo> getEnemigos() {
        return enemigos;
    }

    public void registrar(String accion) {
        log.add(accion);
        if (log.size() > 3){
            log.remove(0);
        }
    }

    public String logComoTexto() {
        return String.join(" | ", log);
    }

    public boolean yaTermino() {
        if (!jugador.estaVivo()) {
            return true;
        }
        boolean todosMuertos = true;
        for (Enemigo e : enemigos) {
            if (e.estaVivo()){
                todosMuertos = false;
            }
        }
        return todosMuertos;
    }

    public String mostrarEstado() {
        StringBuilder sb = new StringBuilder(); //StringBuilder es más eficiente para concatenar strings en un bucle, según investigado,por eso probe usarlo aca, si falla cambiar a string noraml en revision;...
        sb.append(jugador.toString()).append("\n");
        for (Enemigo e : enemigos) {
            sb.append(e.toString()).append("\n");
        }
        sb.append("Acciones recientes: ").append(logComoTexto());
        return sb.toString();
    }
}