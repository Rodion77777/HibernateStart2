import dao.AutoEntityDAOImpl;
import dao.UserEntityDAOImpl;
import models.AutoEntity;
import models.UserEntity;
import services.AutoEntityServiceImpl;
import services.UserEntityServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class HibernateApplication
{
    private final UserEntityServiceImpl userEntityService;
    private final AutoEntityServiceImpl autosEntityService;
    List<UserEntity> userEntityList;
    List<AutoEntity> autoEntityList;

    public HibernateApplication ()
    {
        this.userEntityService = new UserEntityServiceImpl(new UserEntityDAOImpl());
        this.autosEntityService = new AutoEntityServiceImpl(new AutoEntityDAOImpl());
        userEntityList = new ArrayList<>();
        autoEntityList = new ArrayList<>();
    }

    public void run ()
    {
        createUserAndCarsRodion();
        createUserAndCarsDmitry();
        showUsersFromDB();
        showCarsFromDB();
        showCarsByUserEntity(userEntityList.get(1));
        clearDB();
    }

    public void createUserAndCarsRodion ()
    {
        out.println("Creating users and cars.");

        UserEntity rodion = new UserEntity("Rodion", 26);
        userEntityService.saveUser(rodion);

        AutoEntity porsche = new AutoEntity("Porsche", "Red");
        porsche.setUsersEntity(rodion);
        rodion.addAuto(porsche);

        AutoEntity lamborghini = new AutoEntity("Lamborghini", "Yellow");
        lamborghini.setUsersEntity(rodion);
        rodion.addAuto(lamborghini);

        userEntityService.updateUser(rodion);

        userEntityList.add(rodion);
        autoEntityList.add(porsche);
        autoEntityList.add(lamborghini);
    }

    public void createUserAndCarsDmitry ()
    {
        out.println("Creating users and cars.");

        UserEntity dmitry = new UserEntity("Dmitry", 24);
        userEntityService.saveUser(dmitry);

        AutoEntity fiesta = new AutoEntity("Ford Fiesta", "Blue");
        fiesta.setUsersEntity(dmitry);
        dmitry.addAuto(fiesta);

        AutoEntity granda = new AutoEntity("Ford Granda", "Silver");
        granda.setUsersEntity(dmitry);
        dmitry.addAuto(granda);

        userEntityService.updateUser(dmitry);

        userEntityList.add(dmitry);
        autoEntityList.add(fiesta);
        autoEntityList.add(granda);
    }

    public void showUsersFromDB ()
    {
        out.println("Mapping of users from the database.");

        List<UserEntity> userEntityList = userEntityService.findAllUsers();

        out.println("=".repeat(41));
        out.printf("|%5s |%25s |%4s |\n", "ID", "USERNAME", "AGE");
        out.println("=".repeat(41));

        for (UserEntity ue: userEntityList) {
            out.printf("|%5d |%25s |%4d |\n", ue.getId(), ue.getName(), ue.getAge());
        }

        out.println("=".repeat(41));
        out.println();
    }

    public void showCarsFromDB ()
    {
        out.println("Mapping of cars from the database.");
        List<AutoEntity> autoEntityList = autosEntityService.findAllAuto();
        showAutosEntity(autoEntityList);
    }

    public void showCarsById (int id)
    {
        out.println("Mapping of cars by id.");

        AutoEntity ae = autosEntityService.findAutoById(id);
        List<AutoEntity> list = new ArrayList<>();
        list.add(ae);
        showAutosEntity(list);
    }

    public void showCarsByUserEntity(UserEntity userEntity)
    {
        out.println("Mapping of cars by UsersEntity.");

        List<AutoEntity> autoEntityList = autosEntityService.findAutoByUserEntity(userEntity);
        showAutosEntity(autoEntityList);
    }

    public void showAutosEntity (List<AutoEntity> list)
    {
        out.println("=".repeat(57));
        out.printf("|%5s |%20s |%15s |%8s |\n", "ID", "VEHICLE NAME", "COLOR", "USER_ID");
        out.println("=".repeat(57));

        for (AutoEntity ae: list) {
            out.printf("|%5d |%20s |%15s |%8d |\n", ae.getId(), ae.getModel(), ae.getColor(), ae.getUsersEntity().getId());
        }

        out.println("=".repeat(57));
        out.println();
    }

    public void clearDB ()
    {
        out.println("Start clear UsersEntity table from Database.");
        userEntityService.dropUsersEntity();
    }
}
