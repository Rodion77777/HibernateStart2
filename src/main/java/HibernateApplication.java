import dao.AutosEntityDAOImpl;
import dao.UsersEntityDAOImpl;
import models.AutosEntity;
import models.UsersEntity;
import services.AutosEntityServiceImpl;
import services.UserEntityServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static java.lang.System.out;

public class HibernateApplication
{
    private final UserEntityServiceImpl userEntityService;
    private final AutosEntityServiceImpl autosEntityService;
    List<UsersEntity> usersEntityList;
    List<AutosEntity> autosEntityList;

    public HibernateApplication ()
    {
        this.userEntityService = new UserEntityServiceImpl(new UsersEntityDAOImpl());
        this.autosEntityService = new AutosEntityServiceImpl(new AutosEntityDAOImpl());
        usersEntityList = new ArrayList<>();
        autosEntityList = new ArrayList<>();
    }

    public void run ()
    {
        createUserAndCarsRodion();
        createUserAndCarsDmitry();
        showUsersFromDB();
        showCarsFromDB();
        showCarsByUserEntity(usersEntityList.get(1));
        clearDB();
    }

    public void createUserAndCarsRodion ()
    {
        out.println("Creating users and cars.");

        UsersEntity rodion = new UsersEntity("Rodion", 26);
        userEntityService.saveUser(rodion);

        AutosEntity porsche = new AutosEntity("Porsche", "Red");
        porsche.setUsersEntity(rodion);
        rodion.addAuto(porsche);

        AutosEntity lamborghini = new AutosEntity("Lamborghini", "Yellow");
        lamborghini.setUsersEntity(rodion);
        rodion.addAuto(lamborghini);

        userEntityService.updateUser(rodion);

        usersEntityList.add(rodion);
        autosEntityList.add(porsche);
        autosEntityList.add(lamborghini);
    }

    public void createUserAndCarsDmitry ()
    {
        out.println("Creating users and cars.");

        UsersEntity dmitry = new UsersEntity("Dmitry", 24);
        userEntityService.saveUser(dmitry);

        AutosEntity fiesta = new AutosEntity("Ford Fiesta", "Blue");
        fiesta.setUsersEntity(dmitry);
        dmitry.addAuto(fiesta);

        AutosEntity granda = new AutosEntity("Ford Granda", "Silver");
        granda.setUsersEntity(dmitry);
        dmitry.addAuto(granda);

        userEntityService.updateUser(dmitry);

        usersEntityList.add(dmitry);
        autosEntityList.add(fiesta);
        autosEntityList.add(granda);
    }

    public void showUsersFromDB ()
    {
        out.println("Mapping of users from the database.");

        List<UsersEntity> usersEntityList = userEntityService.findAllUsers();

        out.println("=".repeat(41));
        out.printf("|%5s |%25s |%4s |\n", "ID", "USERNAME", "AGE");
        out.println("=".repeat(41));

        for (UsersEntity ue: usersEntityList) {
            out.printf("|%5d |%25s |%4d |\n", ue.getId(), ue.getName(), ue.getAge());
        }

        out.println("=".repeat(41));
        out.println();
    }

    public void showCarsFromDB ()
    {
        out.println("Mapping of cars from the database.");
        List<AutosEntity> autosEntityList = autosEntityService.findAllAuto();
        showAutosEntity(autosEntityList);
    }

    public void showCarsById (int id)
    {
        out.println("Mapping of cars by id.");

        AutosEntity ae = autosEntityService.findAutoById(id);
        List<AutosEntity> list = new ArrayList<>();
        list.add(ae);
        showAutosEntity(list);
    }

    public void showCarsByUserEntity(UsersEntity usersEntity)
    {
        out.println("Mapping of cars by UsersEntity.");

        List<AutosEntity> autosEntityList = autosEntityService.findAutoByUserEntity(usersEntity);
        showAutosEntity(autosEntityList);
    }

    public void showAutosEntity (List<AutosEntity> list)
    {
        out.println("=".repeat(57));
        out.printf("|%5s |%20s |%15s |%8s |\n", "ID", "VEHICLE NAME", "COLOR", "USER_ID");
        out.println("=".repeat(57));

        for (AutosEntity ae: list) {
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
