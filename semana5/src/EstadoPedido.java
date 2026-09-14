/**
 * Enum que representa los posibles estados de un Pedido dentro del
 * sistema de despacho de SpeedFast.
 *
 * Usar un enum en lugar de Strings evita errores de tipeo y mejora
 * la legibilidad y seguridad del código.
 */
public enum EstadoPedido {
    PENDIENTE,
    EN_REPARTO,
    ENTREGADO
}
