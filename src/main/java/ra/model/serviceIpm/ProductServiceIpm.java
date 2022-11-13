package ra.model.serviceIpm;

import ra.model.dao.ProductDao;
import ra.model.daoIpm.ProductDaoIpm;
import ra.model.emtity.Product;
import ra.model.service.ProductService;

import java.util.List;

public class ProductServiceIpm implements ProductService<Product,Integer> {
private ProductDao<Product,Integer> productDao=new ProductDaoIpm();

    @Override
    public List<Product> getAll() {
        return productDao.getAll();
    }

    @Override
    public boolean save(Product product) {
        return productDao.save(product);
    }

    @Override
    public boolean update(Product product) {
        return productDao.update(product);
    }

    @Override
    public boolean delete(Integer id) {
        return productDao.delete(id);
    }

    @Override
    public Product getById(Integer id) {
        return productDao.getById(id);
    }

    @Override
    public List<Product> searchByName(String name) {
        return productDao.searchByName(name);
    }

    @Override
    public List<Product> searchByPrice(float value1, float value2) {
        return productDao.searchByPrice(value1,value2);
    }

    @Override
    public List<Product> sortByPrice() {
        return productDao.sortByPrice();
    }
}
