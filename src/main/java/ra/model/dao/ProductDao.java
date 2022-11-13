package ra.model.dao;

import java.util.List;

public interface ProductDao<T,V> extends ProductManagementDao<T,V> {
    List<T> searchByName(String name);
    List<T> searchByPrice(float value1,float value2);
    List<T> sortByPrice();
}
