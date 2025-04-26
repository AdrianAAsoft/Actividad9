import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<validar> hilos = new ArrayList<>();

        System.out.println("🔐 Validador concurrente de contraseñas\n");
        System.out.print("🔢 ¿Cuántas contraseñas deseas validar?: ");
        int cantidad = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= cantidad; i++) {
            System.out.print("➡️ Ingresa la contraseña #" + i + ": ");
            String pass = scanner.nextLine();
            validar hilo = new validar(pass);
            hilos.add(hilo);
            hilo.start(); // Ejecutar el hilo
        }

        // Esperar que todos los hilos terminen
        for (validar hilo : hilos) {
            try {
                hilo.join();
            } catch (InterruptedException e) {
                System.out.println("⚠️ Error en el hilo: " + e.getMessage());
            }
        }

        System.out.println("\n🧵 Todas las validaciones han finalizado.");
    }
}
