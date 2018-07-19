package com.brainmatics.pos.infra.data.jdbc;

import com.brainmatics.pos.core.product.Product;
import com.brainmatics.pos.core.product.ProductRepo;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ProductJdbcRepo implements ProductRepo {

    private final String COUNT = "SELECT count(*) FROM product";
    private final String INSERT = "INSERT INTO product (id, code, name, price) values(?,?,?,?)";
    private final String DELETE = "DELETE FROM product Where id=?";
    private final String GET_ALL = "SELECT * FROM product";
    private final String GET_BYID = "SELECT id, code, name, price FROM product WHERE id=?";
    private JdbcTemplate jdbc;

    public ProductJdbcRepo(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public int getCount() {
        return jdbc.query(COUNT, rs ->{
            rs.next();
            return rs.getInt(1);
        });
    }

    @Override
    public Product getById(int id) {
        return jdbc.query(GET_BYID, new Object[] {id}, rs ->{
            rs.next();
            return map(rs);
        });
    }

    @Override
    public List<Product> getAll() {
        return jdbc.query(GET_ALL,  (rs, num) -> map(rs));
    }

    @Override
    public void insert(Product product) {
        jdbc.update(INSERT, product.getId(), product.getCode(), product.getName(), product.getPrice());
    }

    @Override
    public void update(Product entity) {

    }

    @Override
    public void remove(int id) {
        jdbc.update(DELETE, id);
    }

    private Product map(ResultSet rs) throws SQLException {
        Product p = new Product();
        p.setId(rs.getInt("id"));
        p.setCode(rs.getString("code"));
        p.setName(rs.getString("name"));
        p.setPrice(rs.getBigDecimal("price"));
        return p;
    }
}
