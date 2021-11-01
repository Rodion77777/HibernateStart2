package models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "autos", schema = "public", catalog = "JRExample")
public class AutoEntity
{
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Basic
    @Column(name = "model", nullable = false, length = -1)
    private String model;

    @Basic
    @Column(name = "color", nullable = false, length = -1)
    private String color;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    public AutoEntity() {}

    public AutoEntity(String model, String color)
    {
        this.model = model;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public UserEntity getUsersEntity ()
    {
        return userEntity;
    }

    public void setUsersEntity (UserEntity userEntity)
    {
        this.userEntity = userEntity;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AutoEntity that = (AutoEntity) o;
        return id == that.id && Objects.equals(model, that.model) && Objects.equals(color, that.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, model, color);
    }
}
