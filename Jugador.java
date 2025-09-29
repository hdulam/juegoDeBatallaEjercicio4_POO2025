import java.util.*;

class Jugador extends Combatiente {
    private String rol;
    private List<Item> items = new ArrayList<>();

    public Jugador(String nombre, String rol, int vida, int ataque) {
        super(nombre, vida, ataque);
        this.rol = rol;
    }

    public void agregarItem(Item item) {
        items.add(item);
    }

    public String usarItem(Item item, Combatiente c) {
        if (items.contains(item) && item.getCantidad() > 0) {
            String res = item.aplicar(c);
            item.consumir();
            return res;
        }
        return nombre + " no tiene más " + item.getNombre();
    }

    public String tomarTurno(Batalla batalla, int opcion) {
        // Opción 1: atacar, opción 2: usar primer item, opción 3: pasar
        if (opcion == 1) {
            for (Enemigo e : batalla.getEnemigos()) {
                if (e.estaVivo()) {
                    return atacar(e);
                }
            }
        } else if (opcion == 2 && !items.isEmpty()) {
            return usarItem(items.get(0), this);
        }
        return nombre + " pasó su turno.";
    }

    @Override
    public String mensajeInicio() {
        return nombre + " entra en la batalla como " + rol;
    }

    @Override
    public String mensajeFinal() {
        return nombre + " ha caído en combate...";
    }
    public List<Item> getItems() {
        return items;
    }
}