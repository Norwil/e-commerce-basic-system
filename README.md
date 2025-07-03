echo "# E-Commerce Order Processing System

## Overview
A Java backend system demonstrating essential design patterns for order processing:
- **Singleton**: Configuration management
- **Factory**: Order type creation
- **Strategy**: Payment processing
- **Observer**: Status notifications

## Design Patterns Implemented
| Pattern       | Implementation Class          | Purpose                          |
|---------------|-------------------------------|----------------------------------|
| Singleton     | `ConfigurationManager`        | Global configuration access      |
| Factory       | `OrderFactory`                | Create different order types     |
| Strategy      | `PaymentStrategy` implementations | Flexible payment processing  |
| Observer      | `OrderObserver` implementations | Real-time status notifications |

## How to Run
1. Clone the repository:
   \`\`\`bash
   git clone https://github.com/your-username/ecommerce-order-system.git
   \`\`\`
2. Navigate to project:
   \`\`\`bash
   cd ecommerce-order-system/src/main/java
   \`\`\`
3. Compile and run:
   \`\`\`bash
   javac com/example/ecommerce/ECommerceSystemDemo.java
   java com.example.ecommerce.ECommerceSystemDemo
   \`\`\`

## Purpose
This is an **educational project** demonstrating how design patterns solve common problems in:
- Order processing workflows
- Payment method handling
- System configuration
- Event notifications

Not production-ready - created for pattern practice and interview preparation.

## Structure
\`\`\`
src/main/java/
├── config/               # Singleton implementation
├── orders/              # Factory pattern
│   ├── factory/
│   └── model/
├── payment/             # Strategy pattern
│   ├── strategy/
│   └── model/
├── notification/        # Observer pattern
│   └── observer/
└── service/             # Core processing
\`\`\`

## Author
[Emre Tokluk] - [emretokluk@gmail.com]" > README.md