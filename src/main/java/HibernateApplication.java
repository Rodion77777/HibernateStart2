import models.AutosEntity;
import models.UsersEntity;
import org.postgresql.util.PSQLException;
import services.UserEntityServiceImpl;

public class HibernateApplication {
    private UserEntityServiceImpl userEntityService;

    public HibernateApplication (UserEntityServiceImpl userEntityService)
    {
        this.userEntityService = userEntityService;
    }

    public void run () throws PSQLException
    {
        UsersEntity rodion = new UsersEntity("Rodion", 26);
        userEntityService.saveUser(rodion);

        AutosEntity porsche = new AutosEntity("Porsche", "Red");
        porsche.setUsersEntity(rodion);
        rodion.addAuto(porsche);

        AutosEntity lamborghini = new AutosEntity("Lamborghini", "Yellow");
        lamborghini.setUsersEntity(rodion);
        rodion.addAuto(lamborghini);

        userEntityService.updateUser(rodion);
    }
}
