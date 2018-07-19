package com.brainmatics.pos.infra.data.jdbc;

import com.brainmatics.pos.core.employee.Employee;
import com.brainmatics.pos.core.product.Product;
import com.brainmatics.pos.core.sale.Sale;
import com.brainmatics.pos.core.sale.SaleLineItem;
import com.brainmatics.pos.core.sale.SaleRepo;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SaleJdbcRepo implements SaleRepo {
    private JdbcTemplate jdbc;

    public SaleJdbcRepo(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Sale getByIdEager(int id){
        String sql = "SELECT * FROM sale s join salelineitem sli on s.id = sli.saleid join product p on p.id = sli.productid WHERE s.id=?";
        return jdbc.query(sql, new Object[] { id },(rs) -> {
            Sale sale = new Sale();
            sale.setId(id);
            Employee e = new Employee();
            rs.next();
            e.setId(rs.getInt("employeeid"));
            sale.setCashier(e);
            do {
                Product p = new Product();
                p.setId(rs.getInt("productid"));
                p.setName(rs.getString("name"));
                p.setPrice(rs.getBigDecimal("price"));
                sale.addlineItems(p,rs.getInt("quantity"));
            } while(rs.next());
            return sale;
        });
    }

    @Override
    public int getCount() {
        return 0;
    }

    public Sale getById(int id){
        String sql = "SELECT * FROM sale s join salelineitem sli on s.id = sli.saleid WHERE s.id=?";
       return jdbc.query(sql, new Object[] { id },(rs) -> {
            Sale sale = new Sale();
            sale.setId(id);
            Employee e = new Employee();
            rs.next();
            e.setId(rs.getInt("employeeid"));
            sale.setCashier(e);
           do {
                Product p = new Product();
                p.setId(rs.getInt("productid"));
                sale.addlineItems(p,rs.getInt("quantity"));
            } while(rs.next());
           return sale;
        });
    }

    @Override
    public List<Sale> getAll() {
        return null;
    }

    @Override
    public void insert(Sale sale) {
//        String sqlSale = "INSERT INTO sale VALUES(?,?)";
//        jdbc.update(sqlSale, sale.getId(), sale.getCashier().getId());
//        String sqlSli = "INSERT INTO salelineitem(saleid, productid, quantity, price) VALUES(?,?,?,?)";
//        for(SaleLineItem sli: sale.getlineItems()){
//            jdbc.update(sqlSli, sale.getId(), sli.getProduct().getId(), sli.getQuantity(), sli.getUnitprice());
//        }

//        String saleSql = String.format("INSERT INTO sale VALUES(%d,%d)",sale.getId(), sale.getCashier().getId());
//        StringBuilder sb = new StringBuilder();
//        for(SaleLineItem sli: sale.getlineItems()){
//            String sliSql = String.format("INSERT INTO salelineitem  VALUES(%d,%d,%d,%d); ",
//                    sli.getQuantity(), 500, sli.getProduct().getId(),sale.getId() );
//            sb.append(sliSql);
//        }
//        jdbc.batchUpdate(saleSql, sb.toString());

        String sqlSale = "INSERT INTO sale VALUES(?,?)";
        jdbc.update(sqlSale, sale.getId(), sale.getCashier().getId());
        String sqlSli = "INSERT INTO salelineitem(saleid, productid, quantity, price) VALUES(?,?,?,?)";

 //       List parmList = new ArrayList();
//        for(SaleLineItem sli : sale.getlineItems()){
//            Object[] params = new Object[] { sale.getId(), sli.getProduct().getId(), sli.getQuantity(), sli.getUnitprice()};
//            parmList.add(params);
//        }
        List<Object[]> paramList = sale.getlineItems()
              .stream()
              .map(sli -> new Object[]{sale.getId(), sli.getProduct().getId(), sli.getQuantity(), sli.getUnitprice()})
              .collect(Collectors.toList());
        jdbc.batchUpdate(sqlSli, paramList);
    }

    @Override
    public void update(Sale entity) {

    }

    @Override
    public void remove(int id) {

    }
}
