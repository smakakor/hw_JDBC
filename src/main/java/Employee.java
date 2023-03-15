import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "first_name")
    private String firstname;
    @Column(name = "last_name")
    private String lastname;
    @Column(name = "gender")
    private String gender;
    @Column(name = "age")
    private int age;
//    @Column(name = "city_id")
//    private int cityId;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private City city;

//    public Employee(int id, String firstname, String lastname, String gender, int age, int cityId) {
//        this.id = id;
//        this.firstname = firstname;
//        this.lastname = lastname;
//        this.gender = gender;
//        this.age = age;
//        this.cityId = cityId;
//    }

//    public Employee(String firstname, String lastname, String gender, int age, int cityId) {
//        this.firstname = firstname;
//        this.lastname = lastname;
//        this.gender = gender;
//        this.age = age;
//        this.cityId = cityId;
//    }

    public Employee(int id, String firstname, String lastname, String gender, int age, City city) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.age = age;
        this.city = city;
    }

    public Employee() {

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

//    public int getCityId() {
//        return cityId;
//    }
//
//    public void setCityId(int cityId) {
//        this.cityId = cityId;
//    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", city=" + city +
                '}';
    }
}
