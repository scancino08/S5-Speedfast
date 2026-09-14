import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Representa la zona de carga compartida de SpeedFast, desde donde
 * los distintos repartidores retiran los pedidos pendientes.
 *
 * Se utiliza una BlockingQueue, que ya es thread-safe internamente,
 * para garantizar que cada pedido sea retirado por un único
 * repartidor y evitar condiciones de carrera al acceder al recurso
 * compartido.
 */
public class ZonaDeCarga {

    private final BlockingQueue<Pedido> pedidosPendientes = new LinkedBlockingQueue<>();

    /**
     * Agrega un pedido a la zona de carga.
     * Sincronizado para dejar explícita la exclusión mutua al
     * modificar el recurso compartido.
     */
    public synchronized void agregarPedido(Pedido p) {
        pedidosPendientes.offer(p);
        System.out.println("Pedido #" + p.getId() + " agregado. Destino: " + p.getDireccionEntrega());
    }

    /**
     * Retira un pedido de la zona de carga de forma segura.
     * Devuelve null si no quedan pedidos disponibles, para que el
     * repartidor pueda finalizar su ejecución sin bloquearse.
     */
    public synchronized Pedido retirarPedido() {
        Pedido p = pedidosPendientes.poll();
        if (p != null) {
            p.setEstado(EstadoPedido.EN_REPARTO);
        }
        return p;
    }

    public synchronized boolean estaVacia() {
        return pedidosPendientes.isEmpty();
    }
}
