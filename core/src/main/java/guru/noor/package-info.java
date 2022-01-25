package guru.noor;

// Learnings:

// Setter VS Constructor Based DI (Dependency Injection):

// - You can mix both.

// - Rule of thumb:
// -- Constructor Based DI for mandatory dependencies.
// -- Setter Based DI for optional dependencies.

// - Spring team recommendation:
// -- Always use Constructor Based DI as it enables one to implement application components as immutable objects and to
// ensure that required dependencies are not null.
// --- Constructor-injected components are always returned to the client (Calling code) in a fully initialized state.

// - Notes:
// -- Large number of constructor arguments (>3) is considered a bad practice.
// --- This may imply that the class has too many responsibilities and should be refactored to better address proper
// separation of concerns.

// - Setter Based DI:
// -- should only be used for optional dependencies that can be assigned reasonable default values
// within the class.
// --- Otherwise, non-null checks must be performed everywhere the code uses the dependency (woohoooo!)
// -- One benefit: Setter methods make objects of that class amenable to reconfiguration or re-injection later.

// - Use the DI style that makes the most sense for a specific class.
// -- If you used a third-party class which does not expose any setter methods, you will have to use the constructor
// injection instead anyway (the choice is made for you).


// =====================================================================================================================


// Dependency Resolution Process:

// - The ApplicationContext is created abd initialized with configuration metadata that describes all the beans
// (configuration can be implemented using XML or with Annotations via Java code).

// - For each bean, its dependencies are expressed in the form of properties or constructor arguments.
// -- These dependencies are provided to the bean when the bean is actually created.
// -- Each property or constructor is an actual definition of the value to set, or a reference to another bean in the
// container (using the `ref` parameter).
// -- Each property or constructor argument which is a value is converted from its specified format to the actual type
// of that property or constructor argument.

// - Spring can convert a value supplied in string format to all built-in types, such as int, long, String, boolean,
// etc.

// - The Spring container always validates the configuration of each bean as the container is created.
// -- However, the bean properties themselves are not set until the bean is actually created.

// - The creation of a bean potentially causes a graph of beans to be created, as the bean's dependencies and its
// dependencies' dependencies (and so on) are created and assigned.


// =====================================================================================================================


// Circular Dependencies:

// If you predominantly use constructor injection, it is possible to create an unresolvable circular dependency
// scenario.

// - Example: Class A requires an instance of class B through constructor injection, and class B requires an instance
// of class A through constructor injection.
// -- If you configured beans for class A and B to be injected into each other, the Spring container detects this
// `circular reference` at runtime and throws a `BeanCurrentlyInCreationException`.
// -- One possible solution is to use setter-based DI for one of these classes rather than constructor-based injection.
// -- Alternatively, you can avoid constructor-based injection and use setter injection only.
// --- In other words, although it is not recommended, you can configure circular dependencies with setter injection.

// - Unlike the typical case (with no circular dependencies), a circular dependency between bean A and bean B will
// force one of the beans to be injected into the other prior to being fully initialized itself (this is a classic
// chicken/egg scenario).


// =====================================================================================================================

// @Autowired: Constructor Injection is recommended over field injections.

// Components Scanning -
// Stereotypes:
// - @Component (bean) - generic
// - @Repository - persistence layer
// - @Service - service layer
// - @Controller - presentation layer
