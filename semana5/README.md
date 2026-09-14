# Semana 5 – Desarrollo Orientado a Objetos II

## Descripción

Actividad formativa individual **"Sincronizando procesos en sistemas concurrentes"**.

El proyecto simula la coordinación de entregas de la empresa **SpeedFast**, donde múltiples repartidores retiran pedidos de una zona de carga compartida y los entregan de forma concurrente, aplicando mecanismos de sincronización en Java (`Thread`, `Runnable`, `synchronized`, `BlockingQueue`) para evitar condiciones de carrera y retiros duplicados.

## Estructura del proyecto

```
semana5/
└── src/
    ├── Pedido.java
    ├── EstadoPedido.java
    ├── ZonaDeCarga.java
    ├── Repartidor.java
    └── Main.java
```

- **Pedido**: representa una encomienda, con id, dirección de entrega y estado.
- **EstadoPedido**: enum con los estados `PENDIENTE`, `EN_REPARTO`, `ENTREGADO`.
- **ZonaDeCarga**: recurso compartido desde donde los repartidores retiran pedidos de forma segura.
- **Repartidor**: implementa `Runnable`; cada instancia se ejecuta en su propio hilo, retira pedidos y simula su entrega.
- **Main**: inicializa la zona de carga, agrega los pedidos y lanza los hilos de los repartidores.

## Ejecución

Para ejecutar la simulación del sistema:

1. Abre el proyecto en IntelliJ IDEA.
2. Dirígete a la clase `Main` (`src/Main.java`).
3. Ejecuta el archivo. La consola mostrará de forma ordenada la asignación de repartidores (automática y manual), la demostración del despacho, la cancelación de un pedido y el historial final de entregas.

## Tecnologías utilizadas

- Java (Threads, Runnable, synchronized, ExecutorService, BlockingQueue)

## Autor

- Paola Soledad Cancino García
