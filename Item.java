class Item {
    private String nombre;
    private String tipo;
    private int cantidad;
    private int efecto;

    public Item(String nombre, String tipo, int cantidad, int efecto) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.efecto = efecto;
    }

    public String aplicar(Combatiente c) {
        if (cantidad <= 0) return "No quedan " + nombre;
        if (tipo.equals("cura")) {
            c.recibirCura(efecto);
            return c.nombre + " recupera " + efecto + " de vida con " + nombre;
        } else if (tipo.equals("ataque")) {
            c.ataque += efecto;
            return c.nombre + " gana +" + efecto + " ataque por un turno gracias a " + nombre;
        }
        return "El ítem no hace nada.";
    }

    public void consumir() {
        cantidad--;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getNombre() {
        return nombre;
    }
}