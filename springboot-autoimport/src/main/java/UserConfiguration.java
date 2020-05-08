import org.springframework.context.annotation.Bean;

public class UserConfiguration {
    @Bean
    public User getUser() {
        return new User("importSleect",3);
    }
}
