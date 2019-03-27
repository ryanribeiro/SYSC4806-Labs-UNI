package model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class);
    }

    @Bean
    public CommandLineRunner demo(BuddyInfoRepository repository) {
        return (args) -> {
            // save a couple of customers
            repository.save(new BuddyInfo("Ryan", "Klondike", "555-555-5555"));
            repository.save(new BuddyInfo("Chloe", "O'Brian Street", "555-444-3333"));
            repository.save(new BuddyInfo("Kim", "Bauer Street", "333-222-5555"));
            repository.save(new BuddyInfo("David", "Palmer Road", "111-232-4421"));
            repository.save(new BuddyInfo("Michelle", "Dessler Ave", "888-222-1231"));

            // fetch all customers
            log.info("Customers found with findAll():");
            log.info("-------------------------------");
            for (BuddyInfo buddy : repository.findAll()) {
                log.info(buddy.toString());
            }
            log.info("");

            // fetch customers by last name
            log.info("Buddy found with findByName('Ryan'):");
            log.info("--------------------------------------------");
            repository.findByName("Ryan").forEach(ryan -> {
                log.info(ryan.toString());
            });
            // for (Customer bauer : repository.findByLastName("Bauer")) {
            // 	log.info(bauer.toString());
            // }
            log.info("");
        };
    }

}