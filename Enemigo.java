class Enemigo extends Combatiente {
    protected String habilidad;

    public Enemigo(String nombre, int vida, int ataque, String habilidad) {
        super(nombre, vida, ataque);
        this.habilidad = habilidad;
    }

    public String tomarTurno(Batalla batalla) {
        return atacar(batalla.getJugador());
    }

    public String usarHabilidad(Combatiente c) {
        c.recibirDanio(2);
        return nombre + " usa " + habilidad + " en " + c.nombre + " (-2 vida extra)";
    }

    @Override
    public String mensajeInicio() {
        return "¡" + nombre + " aparece!";
    }

    @Override
    public String mensajeFinal() {
        return nombre + " ha sido derrotado.";
    }
}