// Write a Java program to display the Current Date using spring.
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@SpringBootApplication
public class DisplayDateApplication2 {

    public static void main(String[] args) {
        SpringApplication.run(DisplayDateApplication.class, args);
    }
}

@RestController
class DateController {

    @GetMapping("/current-date")
    public String displayCurrentDate() {
        LocalDate currentDate = LocalDate.now();
        return "Current Date: " + currentDate.toString();
    }
}
