# Design Patterns

## Design Principles

- Identify the aspects of your application that vary and separate them from what stays the same. (Encapsulate what
  varies.)
- Program to an interface, not an implementation.
- Favor composition over inheritance.
- Strive for loosely coupled designs between objects that interact.
- Classes should be open for extension, but closed for modification.

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

