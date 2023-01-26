package Repository;

import ProductManager.Product;

public class ProductRepository {
    private Product[] products = new Product[0];

    // Метод сохранения товаров
    public void save (Product product) {
        Product[] tmp = new Product[products.length + 1];
        for (int i = 0; i < products.length; i++) {
            tmp[i] = products[i];
        }
        tmp[tmp.length - 1] = product;
        products = tmp;
    }

    // Метод вывода всех сохраненных товаров
    public Product[]  findAll() {
        return products;
    }

    // Метод удаления товара по ID
    public void removeById(int id) {
        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getProductID() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        products = tmp;
    }


}
