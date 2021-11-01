package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "public", catalog = "JRExample")
public class UsersEntity
{
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "name", nullable = false, length = -1)
    private String name;

    @Basic
    @Column(name = "age", nullable = false)
    private int age;

    @OneToMany(mappedBy = "usersEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AutosEntity> autos;

    public UsersEntity () {}

    public UsersEntity (String name, int age)
    {
        this.name = name;
        this.age = age;
        autos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<AutosEntity> getAutos ()
    {
        return this.autos;
    }

    public void setAutos (List<AutosEntity> autos)
    {
        this.autos = autos;
    }

    public void addAuto (AutosEntity autosEntity)
    {
        autosEntity.setUsersEntity(this);
        autos.add(autosEntity);
    }

    public void removeAuto (AutosEntity autosEntity)
    {
        autos.remove(autosEntity);
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsersEntity that = (UsersEntity) o;
        return id == that.id && age == that.age && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }
}
