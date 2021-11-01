package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users", schema = "public", catalog = "JRExample")
public class UserEntity
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

    @OneToMany(mappedBy = "userEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AutoEntity> autos;

    public UserEntity() {}

    public UserEntity(String name, int age)
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

    public List<AutoEntity> getAutos ()
    {
        return this.autos;
    }

    public void setAutos (List<AutoEntity> autos)
    {
        this.autos = autos;
    }

    public void addAuto (AutoEntity autoEntity)
    {
        autoEntity.setUsersEntity(this);
        autos.add(autoEntity);
    }

    public void removeAuto (AutoEntity autoEntity)
    {
        autos.remove(autoEntity);
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return id == that.id && age == that.age && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, age);
    }
}
