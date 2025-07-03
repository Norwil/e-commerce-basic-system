package org.norw;

import org.norw.config.ConfigurationManager;
import org.norw.notification.observer.AnalyticsService;
import org.norw.notification.observer.EmailNotificationService;
import org.norw.notification.observer.InventoryService;
import org.norw.notification.observer.SMSNotificationService;
import org.norw.orders.factory.OrderFactory;
import org.norw.orders.model.Order;
import org.norw.orders.status.OrderStatus;
import org.norw.payment.strategy.CreditCardPayment;
import org.norw.payment.strategy.CryptoPayment;
import org.norw.payment.strategy.PayPalPayment;
import org.norw.service.OrderProcessingService;

import javax.swing.event.AncestorListener;

public class ECommerceSystemDemo {
    public static void main(String[] args) {
        System.out.println("=== E-COMMERCE ORDER PROCESSING SYSTEM ===\n");

        // Test all patterns integration
        demonstrateSystem();
    }

    private static void demonstrateSystem() {
        // 1. SINGLETON - Get Configuration
        System.out.println("1. SINGLETON PATTERN - Configuration Manager");
        ConfigurationManager cfg1 = ConfigurationManager.getInstance();
        ConfigurationManager cfg2 = ConfigurationManager.getInstance();

        System.out.println("Same instance? " + (cfg1 == cfg2));
        cfg1.displayConfig();
        System.out.println();

        // 2. FACTORY - Create different order types
        System.out.println("2. FACTORY PATTERN - Creating Orders: ");
        Order regularOrder = OrderFactory.createOrder(OrderFactory.OrderType.REGULAR,"ORD001", "john@doe.com", 100.0);
        Order premiumOrder = OrderFactory.createOrder(OrderFactory.OrderType.PREMIUM, "ORD002", "jane@doe.com", 200.6);
        Order giftOrder = OrderFactory.createOrder(OrderFactory.OrderType.GIFT, "ORD003", "bob@alice.com", 150.0);

        System.out.println("Regular Order Fee: $" + regularOrder.calculateProcessingFee());;
        System.out.println("Premium Order Fee: $" + premiumOrder.calculateProcessingFee());
        System.out.println("Gift Order Fee: $" + premiumOrder.calculateProcessingFee());
        System.out.println();

        // 3. OBSERVER - Setup notification services
        System.out.println("3. OBSERVER PATTERN - Setting up Notifications:");
        OrderProcessingService processor = new OrderProcessingService();

        processor.addObserver(new EmailNotificationService());
        processor.addObserver(new SMSNotificationService());
        processor.addObserver(new InventoryService());
        processor.addObserver(new AnalyticsService());
        System.out.println("All notification service registered\n");

        // 4. STRATEGY - Process payments with different methods
        System.out.println("4. STRATEGY PATTERN - Payment Processing: ");

        // Process regular order with credit card
        processor.setPaymentStrategy(new CreditCardPayment());
        processor.processOrder(regularOrder);
        System.out.println();

        // Process premium order with PayPal
        processor.setPaymentStrategy(new PayPalPayment());
        processor.processOrder(premiumOrder);
        System.out.println();

        // Process gift order with Crypto
        processor.setPaymentStrategy(new CryptoPayment());
        processor.processOrder(giftOrder);
        System.out.println();

        // 5. Update order status (triggers observers)
        System.out.println("5. ORDER STATUS UPDATES:");
        processor.updateOrderStatus("ORD001", OrderStatus.SHIPPED);
        processor.updateOrderStatus("ORD002", OrderStatus.DELIVERED);
        processor.updateOrderStatus("ORD003", OrderStatus.CANCELLED);
    }
}
