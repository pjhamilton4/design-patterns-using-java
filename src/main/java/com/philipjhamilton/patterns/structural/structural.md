# Structural Design Patterns
Design patterns that are concerend with how classes and objects are composed to form larger structures. They use inheritance to compose interfaces or implementations. Or simply, they make independently developed class libraries work together.
## Types

- ### Adapter
    #### Intent
    1. Creational methods taking an instance of different abstract/interface type and returning an implementation of own/another abstract/interface type which decorates/overrides the given instance.

    #### Examples in the JDK
    1. java.util.Arrays#asList()
    2. java.util.Collections#list()
    3. java.util.Collections#enumeration()
    4. java.io.InputStreamReader()
    5. java.io.OutputStreamWriter()

- ### Bridge
    #### Intent
    1. Recognizable by taking an instance of different abstract/interface type and return an implementation of own abstract/interface type which delegates/uses the given instance.

    #### Examples in the JDK
    1. java.util.Collections@newSetFromMap()
    2. new LinkedHashMap(LinkedHashSet<K>, List<V>)

- ### Composite
    #### Intent
    1. Recognizable by taking an instance of same abstract/interface type into a tree structure

    #### Examples in the JDK
    1. java.faces.component.UIComponent#getChildren()
    2. java.awt.Container#add()

- ### Decorator
    #### Intent
    1. Takes an instance of same abstract/interface type which adds additional behavior

    #### Examples in the JDK
    1. java.io.InputStream, OutputStream, Rader, Writer
    2. java.util.Collections
    3. 

- ### Facade
    #### Intent
    1. Internally uses instance of different independent abstract/interface types

    #### Examples in the JDK
    1. javax.faces.context.FacesContext - LifeCycle, ViewHandler and NavigationHandler internally used.
    2. javax.face.context.ExternalContext - Uses ServletContext, HttpSession, HttpServletRequest
    
- ### Flyweight
    #### Intent
    1. Returns a cached instance

    #### Examples in the JDK
    1. java.lang.Integer#valueOf - Boolean, Byte, Character, Short, Long all use this pattern too
    2. Strings - String pool java uses
    
- ### Proxy
    #### Intent
    1. Returns an implementation of given abstract/interface type which in turn delegates/uses a different implementation of given abstract/interface type
    
    #### Examples in the JDK
    1. java.lang.reflect.Proxy
    2. javax.ejb.EJB
    3. javax.inject.Inject
    4. javax.persistence.PersistenceContext

## Rules of thumb


