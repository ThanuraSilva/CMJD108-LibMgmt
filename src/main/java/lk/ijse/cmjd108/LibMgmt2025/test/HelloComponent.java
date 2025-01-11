package lk.ijse.cmjd108.LibMgmt2025.test;

import org.springframework.stereotype.Component;

@Component
public class HelloComponent {
    public HelloComponent() {
        System.out.println("HelloComponent and registered via @Component");
    }
}
