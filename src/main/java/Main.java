import dao.UsersEntityDAOImpl;
import org.postgresql.util.PSQLException;
import services.UserEntityServiceImpl;

public class Main {
    public static void main(final String[] args) throws PSQLException {
        new HibernateApplication(new UserEntityServiceImpl(new UsersEntityDAOImpl())).run();
    }
}