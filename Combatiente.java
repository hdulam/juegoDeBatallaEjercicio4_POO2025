
abstract class Combatiente {
    protected String nombre;
    protected int vida;
    protected int ataque;

    public Combatiente(String nombre, int vida, int ataque) {
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
    }

    public String atacar(Combatiente c) {
        c.recibirDanio(ataque);
        return nombre + " atacó a " + c.nombre + " (-" + ataque + " vida)";
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public void recibirDanio(int cantidad) {
        vida -= cantidad;
        if (vida < 0) vida = 0;
    }

    public void recibirCura(int cantidad) {
        vida += cantidad;
    }

    public abstract String mensajeInicio();
    public abstract String mensajeFinal();

    @Override
    public String toString() {
        return nombre + " (vida=" + vida + ", ataque=" + ataque + ")";
    }
}