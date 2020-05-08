import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@EnableUserConfig
public class UserTest {
    public static void main(String[] args){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(UserTest.class);
        User u = ac.getBean(User.class);
        System.out.println(u.toString());
    }
}
