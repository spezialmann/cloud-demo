package com.exxeta.clouddemo;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
public class CloudDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(CloudDemoApplication.class, args);
    }
}

@Slf4j
@Controller
class HelloController {
    @RequestMapping("/")
    public String hello(Model model, @RequestParam(value = "name", required = false, defaultValue = "World") String name) {
        log.info("HelloController@hello");
        model.addAttribute("name", name);
        return "hello";
    }
}

@Slf4j
@Controller
class DbController {
    
    private CustomerRepository customerRepository;

    public DbController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @RequestMapping("/db")
    public String db(Model model) {
        log.info("DbController@db");
        Customer customer = new Customer("Max", "Mustermann");
        customerRepository.save(customer);
        
        model.addAttribute("customerList", customerRepository.findAll());
        return "db";
    }
    
    @RequestMapping("/db/delete")
    public String dbDelete(Model model) {
        log.info("DbController@dbDelete");
        customerRepository.deleteAll();
        return "redirect:/db";
    }
}

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
}

interface CustomerRepository extends CrudRepository<Customer, Long> {
    List<Customer> findByLastName(String lastName);
}
