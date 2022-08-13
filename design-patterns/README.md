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
- Don't call us, we'll call you. (Hollywood Principle)
- A class should have only one reason to change. (Single Responsibility Principle)

## Patterns

### Strategy Pattern

Defines a family of algorithms, encapsulates each one, and make them interchangeable.

It lets the algorithm vary independently from clients that use it.

The class diagram of Strategy and State Patterns are essentially the same, but the 2 differ in their intent. With
Strategy, the client usually specifies the strategy object that the context is composed with. While the pattern provides
flexibility to change strategy object at runtime, often there is a strategy object that is most appropriate for a
context object. For instance, in our duck examples, some of our ducks were configured to fly with typical flying
behavior (like mallard ducks), while others were configured with a fly behavior that kept them grounded (like rubber
ducks). Strategy Pattern is a flexible alternative to subclassing. (Strategy vs State)

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

### Template Method Pattern

Defines the skeleton on an algorithm in a method, deferring some steps to subclasses. Template Method lets sublcasses
redefine certain steps of an algorithm without changing the algorithm's structure.

### Iterator Pattern

Provides a way to access the elements of an aggregate object sequentially without exposing its underlying
representation.

It also places the task of traversal on the iterator object, not on the aggregate, which simplifies the aggregate
interface and implementation, and places the responsibility where it should be.

### Composite Pattern

Allows you to compose objects into tree structures to represent part-whole hierarchies. Composite lets clients treat
individual objects and composition of objects uniformly.

The Composite Pattern allows us to build structures of objects in the form of trees that contain both composition of
objects and individual objects as nodes.

Using composite structure, we can apply the same operations over both composites and individual objects. In other words,
in most cases we can ignore the differences between composition of objects and individual objects.

In tree structure, elements with child elements are called nodes. And elements without children are called leaves.

### State Pattern

Allows an object to alter its behavior when its internal state changes. The object will appear to change its class.

The class diagram of Strategy and State Patterns are essentially the same, but the 2 differ in their intent. In State
Pattern, we have a set of behaviors encapsulated in state objects; at any time the context is delegating to one of those
states. Over time, the current state changes across the set of state objects to reflect the internal state of the
context, so the context's behavior changes over time as well. The client usually knows very little, if anything, about
the state objects. State Pattern is an alternative to putting lots of conditionals in your context; by encapsulating the
behaviors within state objects, you can simply change the state object in context to change its behavior. (Strategy vs State) 