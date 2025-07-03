package org.norw.orders.factory;

import org.norw.orders.model.GiftOrder;
import org.norw.orders.model.Order;
import org.norw.orders.model.PremiumOrder;
import org.norw.orders.model.RegularOrder;

public class OrderFactory {


    public enum OrderType {
        REGULAR, PREMIUM, GIFT;
    }

    public static Order createOrder(OrderType type, String orderId, String customerEmail, double amount) {
        switch (type) {
            case REGULAR:
                return new RegularOrder(orderId, customerEmail, amount);
            case PREMIUM:
                return new PremiumOrder(orderId, customerEmail, amount);
            case GIFT:
                return new GiftOrder(orderId, customerEmail, amount);
            default:
                throw new IllegalArgumentException("Unknown order type: " + type);
        }
    }
}
