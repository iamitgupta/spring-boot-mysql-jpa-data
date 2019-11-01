package com.amit.springmysql;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringMysqlApplication implements CommandLineRunner {

    private static final Logger log = LoggerFactory.getLogger(SpringMysqlApplication.class);

    @Autowired
    private EmployeeRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(SpringMysqlApplication.class, args);
        
    }

    @Override
    public void run(String... args) {

        log.info("StartApplication...");
        
        //insert
        repository.save(new Employee("Amit",21));
        repository.save(new Employee("Nithish",22));
        repository.save(new Employee("Ravi",22));

        System.out.println("\nfindAll()");
        List<Employee> list = repository.findAll();
        for(Employee e : list) {
        	System.out.println(e);
        }
        
        
        System.out.println("\nfindById(1L)");
        System.out.println(repository.findById(1l));
        

        
        System.out.println("\nfindByName('Amit')");
        System.out.println(repository.findByName("Amit"));
        
        System.out.println("\ndeleteById(2l)");
        repository.deleteById(2l);
        
        
        
        

    }

}