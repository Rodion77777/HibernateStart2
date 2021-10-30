import models.AutosEntity;
import models.UsersEntity;
import services.UserEntityServiceImpl;

import java.sql.SQLException;

public class HibernateApplication {
    private UserEntityServiceImpl userEntityService;


    UsersEntity rodion = new UsersEntity("Rodion", 26);
    AutosEntity porsche = new AutosEntity("Porsche", "Red");
    AutosEntity lamborghini = new AutosEntity("Lamborghini", "Yellow");

    public HibernateApplication (UserEntityServiceImpl userEntityService)
    {
        this.userEntityService = userEntityService;
    }

    public void run () throws SQLException
    {
        userEntityService.saveUser(rodion);

        porsche.setUsersEntity(rodion);
        rodion.addAuto(porsche);

        lamborghini.setUsersEntity(rodion);
        rodion.addAuto(lamborghini);

        userEntityService.updateUser(rodion);
    }

    public void clearDB () {
        userEntityService.deleteUser(rodion);
        porsche.setUsersEntity(null);
        lamborghini.setUsersEntity(null);
    }
}
