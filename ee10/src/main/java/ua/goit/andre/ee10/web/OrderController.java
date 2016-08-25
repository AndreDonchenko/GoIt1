package ua.goit.andre.ee10.web;

import org.springframework.web.bind.annotation.*;
import ua.goit.andre.ee10.model.OrderNum;
import ua.goit.andre.ee10.service.OrderService;

import java.util.List;

@RestController
public class OrderController {

    private OrderService orderService;

    @RequestMapping(value = "/orders", method = RequestMethod.GET)
    public List<OrderNum> ordersAll() {
        return orderService.getAllOrders();
    }

    @RequestMapping(value = "/orders/open", method = RequestMethod.GET)
    public List<OrderNum> ordersOpen() {
        return orderService.getOpenOrders();
    }

    @RequestMapping(value = "/orders/closed", method = RequestMethod.GET)
    public List<OrderNum> ordersClosed() {
        return orderService.getClosedOrders();
    }

    @RequestMapping(value = "/orders/{orderId}", method = RequestMethod.GET)
    public OrderNum ordersById(@PathVariable(value = "orderId") Integer id ) {
        return orderService.getOrder(id);
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
}
