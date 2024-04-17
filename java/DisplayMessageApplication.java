// Write a Java program using Spring to display the message “If you can't explain it simply, you don't understand it well enough”.

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DisplayMessageApplication {

    public static void main(String[] args) {
        SpringApplication.run(DisplayMessageApplication.class, args);
    }

    public void run() {
        System.out.println("If you can't explain it simply, you don't understand it well enough");
    }
}
