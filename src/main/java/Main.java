import dao.UsersEntityDAOImpl;
import services.UserEntityServiceImpl;

import java.sql.SQLException;

public class Main {
    public static void main(final String[] args) throws SQLException {
        var application = new HibernateApplication(new UserEntityServiceImpl(new UsersEntityDAOImpl()));
        application.run();
        System.out.println("=============");
        application.clearDB();
    }
}