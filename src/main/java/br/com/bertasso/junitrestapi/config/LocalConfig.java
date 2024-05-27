package br.com.bertasso.junitrestapi.config;

import br.com.bertasso.junitrestapi.domain.User;
import br.com.bertasso.junitrestapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UserRepository repository;


    public Object startDB() {
        User u1 = new User(null, "Pedro", "pedro@pedro.com", "123");
        User u2 = new User(null, "Victor", "victor@victor.com", "123");

        repository.saveAll(List.of(u1, u2));

        return new Object();
    }
}