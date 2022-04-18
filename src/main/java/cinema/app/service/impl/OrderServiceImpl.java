package cinema.app.service.impl;

import cinema.app.dao.OrderDao;
import cinema.app.lib.Inject;
import cinema.app.lib.Service;
import cinema.app.model.Order;
import cinema.app.model.ShoppingCart;
import cinema.app.model.Ticket;
import cinema.app.model.User;
import cinema.app.service.OrderService;
import cinema.app.service.ShoppingCartService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Inject
    private OrderDao orderDao;
    @Inject
    private ShoppingCartService shoppingCartService;

    @Override
    public Order completeOrder(ShoppingCart shoppingCart) {
        List<Ticket> tickets = shoppingCart.getTickets();
        List<Ticket> ticketsCopy = new ArrayList<>(tickets);
        Order order = new Order();
        order.setLocalDateTime(LocalDateTime.now());
        order.setTickets(ticketsCopy);
        order.setUser(shoppingCart.getUser());
        orderDao.add(order);
        shoppingCartService.clearShoppingCart(shoppingCart);
        return order;
    }

    @Override
    public List<Order> getOrdersHistory(User user) {
        return orderDao.findByUser(user);
    }
}
