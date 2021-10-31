import models.AutosEntity;
import models.UsersEntity;
import services.UserEntityServiceImpl;

import java.sql.SQLException;
import java.util.List;

import static java.lang.System.out;

public class HibernateApplication {
    private UserEntityServiceImpl userEntityService;

    public HibernateApplication (UserEntityServiceImpl userEntityService) {
        this.userEntityService = userEntityService;
    }

    public void run () throws SQLException
    {
        createUserAndCarsRodion();
        createUserAndCarsDmitry();
        showUsersFromDB();
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
    {
        List<UsersEntity> usersEntityList = userEntityService.findAllUsers();

        out.println();
        out.println("=".repeat(40));
        out.printf("|%5s |%25s |%4s |\n", "ID", "NAME", "AGE");
        out.println("=".repeat(40));

        for (UsersEntity ue: usersEntityList) {
            out.printf("|%5d |%25s |%4d |\n", ue.getId(), ue.getName(), ue.getAge());
        }

        out.println("=".repeat(40));
        out.println();
    }

    public void showCarsFromDB ()
    {}

    public void clearDB () {
        out.println("Start clear UsersEntity table from Database.");
        userEntityService.dropUsersEntity();
    }
}
