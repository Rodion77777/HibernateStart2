import dao.UsersEntityDAOImpl;
import services.UserEntityServiceImpl;

public class Main
{
    public static void main(final String[] args)
    {
        var application = new HibernateApplication(new UserEntityServiceImpl(new UsersEntityDAOImpl()));
        application.run();
        application.clearDB();
    }
}