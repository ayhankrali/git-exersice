package runner;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import repository.UserRepository;

import java.util.Set;

public class CommandRunner  implements CommandLineRunner {
    @Autowired
    UserRepository userRepository ;

    @Override
    public void run(String... args) throws Exception {
        User user1 = User.builder()
                .firstName("Ivan")
                .lastName("Ivanov")
                .age(22)
                .build();

       User savedUser = userRepository.save(user1);
        System.out.println(savedUser.toString());

        Set<User> users = userRepository.findAllByFirstName("Ivan");

        users.forEach(System.out::println);

    }
}
