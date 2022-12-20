package ru.kata.spring.boot_security.demo.liner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;
import ru.kata.spring.boot_security.demo.repository.UserRepository;

import java.util.HashSet;
import java.util.Set;

@Component
public class Liner implements CommandLineRunner {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    // @Autowired
    public Liner(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public void run(String... arg) throws Exception {
        Role roleAdmin = new Role("ROLE_ADMIN");
        Role roleUser = new Role("ROLE_USER");
        Set<Role> adminRoles = new HashSet<>();
        Set<Role> userRoles = new HashSet<>();
        roleRepository.save(roleAdmin);
        roleRepository.save(roleUser);
        adminRoles.add(roleAdmin);
        adminRoles.add(roleUser);
        userRoles.add(roleUser);


        // пользователи Admin  и User
        User userAdmin = new User("artyom", "das", "das@mail.ru", "$2a$12$3f1kSHRGz7YMEAuxRlBXJ.XCUuk6/gjhs5TE8Oy/DovgQm3Ncc4Ci", adminRoles);
        User userUser = new User("lost", "tool", "tool@mail.ru", "$2a$12$3f1kSHRGz7YMEAuxRlBXJ.XCUuk6/gjhs5TE8Oy/DovgQm3Ncc4Ci", userRoles);
        System.out.println(userAdmin);
        userRepository.save(userAdmin);
        System.out.println(userUser);
        userRepository.save(userUser);

    }
}
