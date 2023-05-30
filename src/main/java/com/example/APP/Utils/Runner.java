package com.example.APP.Utils;

import com.example.APP.Model.Authority;
import com.example.APP.Model.User;
import com.example.APP.Repository.repAuthority;
import com.example.APP.Repository.repUser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Runner implements CommandLineRunner {

    private final repUser userRepository;
    private final repAuthority authorityRepository;

    public Runner(repUser userRepository, repAuthority authorityRepository) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (this.authorityRepository.count() == 0) {
            this.authorityRepository.saveAll(List.of(
                    new Authority(AuthorityName.Administrador),
                    new Authority(AuthorityName.Usuario)
            ));
        }

        if (this.userRepository.count() == 0) {
            var encoders = PasswordEncoderFactories.createDelegatingPasswordEncoder();
            this.userRepository.saveAll(List.of(
                            new User("uncledave", encoders.encode("UncleDave123"), List.of(this.authorityRepository.findByName(AuthorityName.Administrador).get())),
                            new User("user02", "User02123", List.of(this.authorityRepository.findByName(AuthorityName.Usuario).get()))
                    )
            );
        }
    }
}
