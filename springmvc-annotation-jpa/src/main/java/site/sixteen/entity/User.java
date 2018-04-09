package site.sixteen.entity;


import javax.persistence.*;
import java.util.Date;

@Entity
public class User {

    @Id
    private long id;
    private String name;
    private Date birth;
    private Integer sex;
    private String phone;
    private String email;
    private String profile;
    private String glory;

    public User() {
    }


   /* public User(long id, String name, Date birth, Integer sex, String phone, String email, String profile, String glory) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.sex = sex;
        this.phone = phone;
        this.email = email;
        this.profile = profile;
        this.glory = glory;
    }*/


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birth=" + birth +
                ", sex=" + sex +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", profile='" + profile + '\'' +
                ", glory='" + glory + '\'' +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }


    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getGlory() {
        return glory;
    }

    public void setGlory(String glory) {
        this.glory = glory;
    }
}
