# Creational Design Patterns
Design patters that provide object creational mechanisms, which allow for flexibility and reuse of code.

## Types

- ### Factory Method
    #### Intent
    1. Returns an implementation of an abstract/interface type. Define an interface for creating an object, but let subclasses decide whcih class to instantiate. Factory Method lets a class defer instantiation to subclasses.

    #### Examples in the JDK
    1. java.util.Calendar#getInstance()
    2. java.util.ResourceBundle#getBundle()
    3. java.text.NumberFormat#getInstance
    4. java.util.EnumSet#of()

- ### Abstract Factory
    #### Intent
    1. Creational methods returning the factory itself which in turn can be used to create another abstract/interface type. It provides an interface for creating families of related or dependent objects without specifying their concrete classes.

    #### Examples in the JDK
    1. javax.xml.parsers.DocumentBuilderFactory#newInstance()
    2. javax.xml.transform.TransformerFactory#newInstance()
    3. javax.xml.xpath.XPathFactory#newInstance()

- ### Builder
    #### Intent
    1. Returns the instance of itself. Separate the construction of a complex object from its representation so that the same construction process can create different representations.

    #### Examples in the JDK
    1. java.lang.StringBuilder#append()
    2. java.lag.StringBuffer#append()
    3. java.util.stream.Stream.Builder
    4. All implementations of java.lang.Appendable
    5. java.nio.ByteBuffer#put() - CharBuffer, ShortBuffer, IntBuffer, LongBuffer, FLoatBuffer and DoubleBuffer

- ### Prototype
    #### Intent
    1. Returns a different instance of itself with the same properties. Specify the kinds of objects to create using a prototypical instance, and create new objects by copying this prototype.

    #### Examples in the JDK
    1. Java.lang.Object#clone() - Need to implement Cloneable

- ### Singleton
    #### Intent
    1. Returns the same instance (usually itself) every time. Ensure a class only ha sone instance and provide a global point of access to it.
    
    #### Use when
    1. There must only be exactly one instance of a class, acceessible to clients from a well-known point.
    2. Sole instance should be extensible by suclassing. 

    #### Examples in the JDK
    1. java.lang.Runtime#getRuntime()
    2. java.lang.System#getSecurityManager()
    
    #### Misc
    1. Could use Enum in java


## Rules of thumb


