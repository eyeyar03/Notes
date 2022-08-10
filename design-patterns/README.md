# Design Patterns

## Design Principles

- Identify the aspects of your application that vary and separate them from what stays the same. (Encapsulate what
  varies.)
- Program to an interface, not an implementation.
- Favor composition over inheritance.
- Strive for loosely coupled designs between objects that interact.
- Classes should be open for extension, but closed for modification. (Open-Closed Principle)
- Depend upon abstractions. Do not depend upon concrete classes. High-level components should not depend on low-level
  components; rather, they should both depend on abstractions. (Dependency Inversion Principle)
- Talk only to your immediate friends. (Principle of Least Knowledge) (Law of Demeter)

## Patterns

### Strategy Pattern

Defines a family of algorithms, encapsulates each one, and make them interchangeable.

It lets the algorithm vary independently from clients that use it.

### Observer Pattern

Defines a one-to-many dependency between objects so that when one object changes state, all of its dependencies are
notified and updated automatically.

### Decorator Pattern

Attaches additional responsibilities to an object dynamically. Decorators provide a flexible alternative to subclassing
for extending functionality.

Intent: Doesn't alter the interface, but adds responsibility. (Decorator vs Adapter vs Facade)

### Factory Method Pattern

Defines an interface for creating an object, but lets subclasses decide which class to instantiate. Factory Method lets
a class defer instantiation to sublcasses.

Simple Factory is another approach on encapsulating object creation. But this is not actually a design pattern, it's
more of a programming idiom. This does not give you the flexibility of the Factory Method because there is no way to
vary the products you're creating.

### Abstract Factory Pattern

Provides an interface for creating families of related or dependent objects without specifying their concrete classes.

### Singleton Pattern

Ensures a class has only one instance, and provides a global point of access to it.

### Command Pattern

Encapsulates a request as an object, thereby letting you parameterized other objects with different requests, queue or
log requests, and support undoable operations.

### Adapter Pattern

Converts the interface of a class into another interface the clients expect. Adapter lets classes work together that
couldn't otherwise because of incompatible interfaces.

Intent: Converts one interface to another. (Decorator vs Adapter vs Facade)

### Facade

Provides a unified interface to a set of interfaces in a subsystem. Facade defines a higher-level interface that makes
the subsystem easier to use.

Intent: Makes an interface simpler. (Decorator vs Adapter vs Facade)