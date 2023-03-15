import java.util.List;

public interface CityDAO {
    void create(City city);

    City readBy(int id);

    List<City> readAll();

    void updateAmountById(City city);

    void deleteById(City city);
}
