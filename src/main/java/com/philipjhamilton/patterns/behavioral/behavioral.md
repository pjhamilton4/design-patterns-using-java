# Behavioral Design Patterns
Design patters that identify common communication patterns between objects and realize these patterns. Doing this ensures there is flexibility in carrying out communication.

## Types

- ### Chain of responsibility
    #### Intent
    1. Avoid coupling the sender of a request to its receiver by giving more
        than one object a chance to handle the request. Chain the receiving 
        objects and pass the request along the chain until an object handles it.
    2. Launch-and-leave requests with a single processing pipeline that contains many possible handlers.
    3. An OO linked list with recursive traversal.
    
    #### Examples in the JDK
    1. java.util.logging.Logger#log()
    2. javax.servlet.Filter#doFilter()
        
- ### Command
    #### Intent
    1. Encapsulate a request as an object, thereby letting you parameterize clients with different requests, queue or log requests, and support undoable operations.
    
    #### Examples in the JDK
    1. java.lang.Runnable
    2. javax.swing.Action
- ### Interpreter
    #### Intent
    1.   Given a language, define a represention for its grammar along with an interpreter that uses the representation to interpret sentences in the language.
    #### Examples in the JDK
    1. java.util.Patter
    2. java.text.Normalizer
    3. java.text.Format
    4. javax.el.ELResolver
- ### Iterator
    #### Intent
    1.   
    #### Examples in the JDK
    1. java.util.Iterator - Scanner as well
    2. java.util.Enumeration
- ### Mediator
    #### Intent
    1.
    #### Examples in the JDK
    1. java.util.Timer
    2. java.util.concurrent.Executor#execute()
    3. java.util.concurrent.ExecutorService
    4. java.util.concurrent.ScheduledExecutorService
    5. java.lang.reflect.Method#invoke()
- ### Memento
    #### Intent
    1.
    #### Examples in the JDK
    1. java.util.Date
    2. java.io.Serializable
    3. javax.faces.component.StateHolder 
- ### Null Object
    #### Intent
    1.   
- ### Observer
    #### Intent
    1.
    #### Examples in the JDK
    1. java.util.Observer/Observable
    2. java.util.EventListener
    3. javax.servlet.http.HttpSession*Listener
    4. javax.faces.event.PhaseListener
- ### State
    #### Intent
    1.   
    #### Examples in the JDK
    1. javax.faces.lifecycle.LifeCycle#execute()
- ### Strategy
    #### Intent
    1.   
    #### Examples in the JDK
    1. java.util.Comparator#compare()
    2. javax.servlet.http.HttpServlet
- ### Template method
    #### Intent
    1.   
    #### Examples in the JDK
    1. java.io.InputStream
    2. java.io.OutputStream
    3. java.io.Reader
    4. java.io.Writer
- ### Visitor
    #### Intent
    1.   
    #### Examples in the JDK
    1. javax.lang.model.element.AnnotationValue(Visitor)
    2. javax.lang.model.model.element.Element(Visitor)
## Rules of thumb

1. Behavioral patterns are concerned with the assignment of responsibilities between objects, or, encapsulating behavior in an object and delegating requests to it.
