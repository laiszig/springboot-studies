# NOTES

## Spring Framework Stereotype Annotations

### @Component
This annotation is used on classes to indicate a Spring component.
The @Component annotation marks the Java class as a bean or say component so that the component-scanning mechanism of Spring can add into the application context.

### @Controller
The @Controller annotation is used to indicate the class is a Spring controller. This annotation can be used to identify controllers for Spring MVC or Spring WebFlux.

### @Service
This annotation is used on a class. The @Service marks a Java class that performs some service, such as execute business logic, perform calculations and call external APIs. This annotation is a specialized form of the @Component annotation intended to be used in the service layer.

### @Repository
This annotation is used on Java classes which directly access the database. The @Repository annotation works as marker for any class that fulfills the role of repository or Data Access Object.
This annotation has a automatic translation feature. For example, when an exception occurs in the @Repository there is a handler for that exception and there is no need to add a try catch block.



##fix
still having problems connecting to the database tab and finding the schemas of the db