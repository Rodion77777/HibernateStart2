import models.AutosEntity;
import models.UsersEntity;
import services.UserEntityServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class HibernateApplication {
    private UserEntityServiceImpl userEntityService;

    UsersEntity rodion = new UsersEntity("Rodion", 26);
    UsersEntity dmitry = new UsersEntity("Dmitry", 24);
    AutosEntity porsche = new AutosEntity("Porsche", "Red");
    AutosEntity lamborghini = new AutosEntity("Lamborghini", "Yellow");

    public HibernateApplication (UserEntityServiceImpl userEntityService) {
        this.userEntityService = userEntityService;
    }

    public void run () throws SQLException
    {
        userEntityService.saveUser(rodion);
        userEntityService.saveUser(dmitry);
        porsche.setUsersEntity(rodion);
        rodion.addAuto(porsche);

        lamborghini.setUsersEntity(rodion);
        rodion.addAuto(lamborghini);

        userEntityService.updateUser(rodion);
        userEntityService.updateUser(dmitry);

    }

    public void clearDB () {
        List<UsersEntity> list = userEntityService.findAllUsers();
        for (UsersEntity ue: list) {
            userEntityService.deleteUser(ue);
        }
    }
}
