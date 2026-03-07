package Order;
public class OrderService {

    public boolean canCancel(OrderStatus status) {
        return status == OrderStatus.NEW;
    }
}