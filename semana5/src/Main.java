import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Punto de entrada del sistema. Simula la coordinación de entregas
 * de SpeedFast: crea la zona de carga, agrega pedidos y lanza a los
 * repartidores para que los retiren y entreguen de forma concurrente.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        ZonaDeCarga zonaDeCarga = new ZonaDeCarga();
        System.out.println("[Zona de carga inicializada]");

        // Se agregan al menos 5 pedidos al sistema.
        zonaDeCarga.agregarPedido(new Pedido(1, "Santiago Centro"));
        zonaDeCarga.agregarPedido(new Pedido(2, "Providencia"));
        zonaDeCarga.agregarPedido(new Pedido(3, "Ñuñoa"));
        zonaDeCarga.agregarPedido(new Pedido(4, "Recoleta"));
        zonaDeCarga.agregarPedido(new Pedido(5, "Las Condes"));

        // Se crean e inician 3 hilos de tipo Repartidor usando ExecutorService.
        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.execute(new Repartidor("Juan", zonaDeCarga));
        executor.execute(new Repartidor("Camila", zonaDeCarga));
        executor.execute(new Repartidor("Pedro", zonaDeCarga));

        executor.shutdown();
        // Se espera la finalización del proceso.
        executor.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println("[Zona de carga vacía]");
        System.out.println("Todos los pedidos han sido entregados correctamente.");
    }
}
