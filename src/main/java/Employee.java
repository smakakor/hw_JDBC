import java.util.Objects;

public class Employee {
private int id;
private String firstname;
private String lastname;
private String gender;
private int age;
private City city;

private int cityId;


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

    public Employee(String firstname, String lastname, String gender, int age, int cityId) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.gender = gender;
        this.age = age;
        this.cityId = cityId;
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

    public City getCity() {
        return city;
    }

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public void setCity(City city) {
        this.city = city;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return id == employee.id && age == employee.age && cityId == employee.cityId && Objects.equals(firstname, employee.firstname) && Objects.equals(lastname, employee.lastname) && Objects.equals(gender, employee.gender) && Objects.equals(city, employee.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, gender, age, city, cityId);
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
                ", cityId=" + cityId +
                '}';
    }
}
