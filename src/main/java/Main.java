

public class Main
{
    public static void main(final String[] args)
    {
        var application = new HibernateApplication();
        application.run();
        application.clearDB();
    }
}