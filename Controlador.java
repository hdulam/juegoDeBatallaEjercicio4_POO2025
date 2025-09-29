import java.util.ArrayList;
import java.util.List;
class Controlador {
    private Batalla batalla;

    public void nuevaPartida(String nombre, String rol) {
        Jugador jugador = new Jugador(nombre, rol, 50, 10);
        jugador.agregarItem(new Item("Poción", "cura", 2, 15));
        jugador.agregarItem(new Item("Elixir", "ataque", 1, 5));

        List<Enemigo> enemigos = new ArrayList<>();
        enemigos.add(new Enemigo("Goblin", 30, 5, "mordida"));
        enemigos.add(new EnemigoJefe("Dragón", 80, 12, "fuego", 0.5));

        batalla = new Batalla(jugador, enemigos);
    }

    public String inicioDeBatalla() {
        StringBuilder sb = new StringBuilder();
        sb.append(batalla.getJugador().mensajeInicio()).append("\n");
        for (Enemigo e : batalla.getEnemigos()) {
            sb.append(e.mensajeInicio()).append("\n");
        }
        return sb.toString();
    }

    public String accionAtacar() {
        String res = batalla.getJugador().tomarTurno(batalla, 1);
        batalla.registrar(res);
        return res;
    }

    public String accionUsarPrimerItemEnJugador() {
        Jugador j = batalla.getJugador();
        if (j != null && !j.getItems().isEmpty()) {
            String res = j.usarItem(j.getItems().get(0), j);
            batalla.registrar(res);
            return res;
        }
        return "No hay ítems disponibles.";
    }

    public String pasar() {
        String res = batalla.getJugador().tomarTurno(batalla, 3);
        batalla.registrar(res);
        return res;
    }

    public List<String> turnoEnemigos() {
        List<String> acciones = new ArrayList<>();
        for (Enemigo e : batalla.getEnemigos()) {
            if (e.estaVivo()) {
                String res = e.tomarTurno(batalla);
                batalla.registrar(res);
                acciones.add(res);
            }
        }
        return acciones;
    }

    public String estado() {
        return batalla.mostrarEstado();
    }

    public String log() {
        return batalla.logComoTexto();
    }

    public boolean estaTerminada() {
        return batalla.yaTermino();
    }
}
