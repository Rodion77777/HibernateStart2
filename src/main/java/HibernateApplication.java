import models.AutosEntity;
import models.UsersEntity;
import services.UserEntityServiceImpl;

import java.sql.SQLException;
import java.util.List;

public class HibernateApplication {
    private UserEntityServiceImpl userEntityService;

    public HibernateApplication (UserEntityServiceImpl userEntityService) {
        this.userEntityService = userEntityService;
    }

    public void run () throws SQLException
    {
        createUserAndCarsRodion();
        createUserAndCarsDmitry();
    }

    public void createUserAndCarsRodion ()
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

    public void createUserAndCarsDmitry ()
    {
        UsersEntity dmitry = new UsersEntity("Dmitry", 24);
        userEntityService.saveUser(dmitry);

        AutosEntity fiesta = new AutosEntity("Ford Fiesta", "Blue");
        fiesta.setUsersEntity(dmitry);
        dmitry.addAuto(fiesta);

        AutosEntity granda = new AutosEntity("Ford Granda", "Silver");
        granda.setUsersEntity(dmitry);
        dmitry.addAuto(granda);

        userEntityService.updateUser(dmitry);
    }

    public void showUsersFromDB ()
    {}

    public void showCarsFromDB ()
    {}

    public void clearDB () {
        List<UsersEntity> list = userEntityService.findAllUsers();
        for (UsersEntity ue: list) {
            userEntityService.deleteUser(ue);
        }
    }
}
