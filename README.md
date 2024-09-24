# Design-Patterns
- Design patterns are proven solutions to common software design problems. They provide best practices and templates that help developers create reusable, maintainable, and scalable code. It increases flexibility and improve system architecture.
- Typically categorized into three types *creational*, *structural*, and *behavioral* design patterns

## Behavioural Design Pattern

1. **Observer Pattern:** 
- Real-World Example
> Imagine you live in a smart home equipped with various automated devices—lights, thermostats, and security systems. These devices need to respond to changes in the home's mode (e.g., "Home", "Away", "Night"). Instead of each device constantly checking the state, they can subscribe to updates from a central system (like a smart home controller). When the mode changes, the controller notifies all subscribed devices, allowing them to adjust their settings accordingly.
- In Simple Terms
> The Observer Pattern allows one object (the subject) to notify multiple other objects (observers) when its state changes. This is useful when you want to maintain a loose coupling between the subject and its observers. The subject does not need to know the specifics of the observers; it only calls their update methods when a change occurs. This makes it easier to add or remove observers without changing the subject’s code.
- File: [Observer.Java](Observer.java)
- When to Use?
> When you want to provide a subscription mechanism to allow other classes to listen for changes in state without tightly coupling them to the subject.


2. **Stratergy Pattern:**
- Real-World Example
> Consider a data analysis application that processes numerical data in various ways based on user requirements. For instance, a user might want to filter out values below a certain threshold, sort the values, or normalize them for better comparison. Instead of hardcoding these operations, the application can utilize different strategies to dynamically choose the desired processing method at runtime.
- In Simple Terms
> The Strategy Pattern enables selecting an algorithm at runtime. It allows you to define a family of algorithms, encapsulate each one, and make them interchangeable. This means you can change the behavior of your code without modifying its structure, making it more flexible and easier to maintain.
- File: [DataProcessingPipeline.Java](DataProcessingPipeline.Java)  
- When to Use?
> When you have multiple algorithms for a specific task, and you want to choose among them at runtime.


## Creational Design Pattern
1. **Factory Method:**
- Real-World Example
> Imagine a vending machine that serves various drinks. Users can select their preferred beverage, like coffee, tea, or juice. Instead of the vending machine containing the logic for preparing each drink directly, it uses a factory to create the drinks. This way, the machine only needs to know which drink to request, and the factory handles the instantiation and preparation details.
- In Simple Terms
> The Factory Method Pattern provides a way to create objects without specifying the exact class of the object that will be created. Instead of creating objects directly using constructors, a factory method is used to encapsulate the object creation logic. This allows for better flexibility and code maintenance.
- File: [VendingMachine.Java](VendingMachine.Java)
- When to Use?
> When the exact type of the object to be created may vary based on the client request or configuration.

2. **Builder:**
- Real-World Example
> Think of ordering a pizza. When you want to customize your pizza, you can choose the size, crust type, toppings, and whether you want extra cheese. The Builder Pattern is like the process of constructing your pizza step-by-step, where each option can be selected without needing to worry about the internal details of how a pizza is made.
- In Simple Terms
> The Builder Pattern is a creational design pattern that allows you to construct complex objects step by step. It separates the construction of a complex object from its representation, enabling you to create different representations of the same type of object. This is particularly useful when an object requires numerous parameters to be set.
- File: [PizzaOrder.Java](PizzaOrder.Java)
- When to Use?
> When an object requires numerous parameters for construction, especially when many of them are optional.


## Structural Design Pattern
1. **Adapter:**
- Real-World Example
> Consider you have mobile devices that use different charging ports. Some smartphones have a USB Type-B port, while others use a USB Type-C port. If you want to charge or transfer data between these devices, you would need an adapter that converts one port type to another. This adapter allows you to connect devices with incompatible interfaces, enabling seamless interaction between them. The Adapter Pattern works in the same way, facilitating communication between incompatible interfaces.
- In Simple Terms
> The Adapter Pattern is a structural design pattern that allows objects with incompatible interfaces to work together. It acts as a bridge between two incompatible interfaces, enabling communication without altering their existing code. The adapter translates the request from the client to a format the adaptee can understand.
- File: [UniversalAdapter.Java](UniversalAdapter.Java)
- When to Use?
> When you need to integrate a new class with an existing system that expects an interface it doesn’t match.

2. **Bridge:**
- Real-World Example
> Imagine a smart home system where you can control various devices like lights and fans using different interfaces. Some users prefer controlling their devices through a mobile app, while others might use a web application. The ability to operate devices through these different platforms showcases flexibility in control options.
- In Simple Terms
> The Bridge Pattern separates the abstraction (the smart devices) from their implementation (the control methods). In this case, the SmartDevice abstraction represents various smart devices, while the DeviceControl implementor interface defines how those devices can be controlled. Concrete implementations, like MobileAppControl and WebAppControl, provide specific ways to control the devices.
- File: [SmartHomeBridge.Java](SmartHomeBridge.Java)
- When to Use?
> Particularly useful in scenarios where you have multiple variations of both the abstraction and its implementation
