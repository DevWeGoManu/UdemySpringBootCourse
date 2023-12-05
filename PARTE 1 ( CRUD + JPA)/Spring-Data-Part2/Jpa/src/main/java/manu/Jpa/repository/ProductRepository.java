package manu.Jpa.repository;

import jakarta.persistence.Id;
import manu.Jpa.entity.Product;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {


    /*
     * FIND BY NAME IN SQL
     */

    @Query("SELECT id,name,description,isactive,imageUrl,price,skuu "+
            "FROM Product "+
            "WHERE name = "+name)
    Product findByName(String name);


    /*
     * FIND BY EMAIL AND LAST NAME
     */
    @Query("SELECT u FROM Product"+
            "WHERE u.emailAdress = " +emailAdress+
            "AND u.lastName = " +lastName)
    List<Product> findByEmailAdressAndLastName(String emailAdress,String lastName);


/*
 * 
 */

    /* 

    @Query("SELECT p FROM Product WHERE " +
            "p.name LIKE CONCAT('%',:query,'%')" +
            "Or p.description LIKE CONCAT('%', :query ,'%') ")
    List<Product> searchProducts(String query);

    @Query(value = "SELECT * FROM products WHERE " +
            "p.name LIKE CONCAT('%',:query,'%')" +
            "Or p.description LIKE CONCAT('%', :query ,'%')", nativeQuery = true)
    List<Product> searchProductsSQL(String query);*/
}
