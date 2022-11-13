package ra.model.service;

import java.util.List;

public interface ProductService<T,V> extends ProductManagementService<T,V> {
    List<T> searchByName(String name);
    List<T> searchByPrice(float value1,float value2);
    List<T> sortByPrice();
}
