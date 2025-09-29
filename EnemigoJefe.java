class EnemigoJefe extends Enemigo {
    private double resistencia;

    public EnemigoJefe(String nombre, int vida, int ataque, String habilidad, double resistencia) {
        super(nombre, vida, ataque, habilidad);
        this.resistencia = resistencia;
    }

    public String usarHabilidadExtra(Combatiente c) {
        int danio = (int)(ataque * 1.5);
        c.recibirDanio(danio);
        return nombre + " desata su poder contra " + c.nombre + " (-" + danio + " vida)";
    }

    @Override
    public String mensajeInicio() {
        return "¡¡Jefe " + nombre + " aparece con gran poder!!";
    }

    @Override
    public String mensajeFinal() {
        return "¡¡El jefe " + nombre + " ha sido derrotado!!";
    }
}