import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Controlador c = new Controlador();

        System.out.print("Ingrese el nombre del jugador: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese el rol (Guerrero/Explorador): ");
        String rol = sc.nextLine();

        c.nuevaPartida(nombre, rol);
        System.out.println(c.inicioDeBatalla());

        while (!c.estaTerminada()) {
            System.out.println("\nEstado actual:");
            System.out.println(c.estado());

            System.out.println("\nAcción del jugador:");
            System.out.println("1) Atacar  2) Usar ítem  3) Pasar");
            int opcion = sc.nextInt();

            String resultado;
            if (opcion == 1){
                resultado = c.accionAtacar();
            }else if (opcion == 2){
                resultado = c.accionUsarPrimerItemEnJugador();
            }else{
                resultado = c.pasar();
            }

            System.out.println(">> " + resultado);

            // Turno enemigos
            for (String acc : c.turnoEnemigos()) {
                System.out.println(">> " + acc);
            }
        }

        System.out.println("\n=== La batalla terminó ===");
        System.out.println(c.estado());
    }
}
