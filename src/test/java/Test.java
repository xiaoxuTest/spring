import com.test.dao.impl.UserDaoImpl;
import com.test.vo.User;
import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        UserDaoImpl udi = context.getBean("userDaoImpl", UserDaoImpl.class);
        //udi.addUser(getAddUserParam());
        User user=udi.getUserInfoById(5).get(0);
        user.setAge(999);
        udi.updateUser(user);
        List<User> allUser=udi.getUserList();
        System.out.println(allUser);
    }


    public static User getAddUserParam() {
        User user = new User();
        user.setName("李白");
        user.setAge(37);
        user.setEmail("111111112@qq.com");
        user.setAddress("浙江杭州");
        return user;
    }
}
