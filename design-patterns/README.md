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