package com.brainmatics.pos;

import com.brainmatics.pos.core.employee.Employee;
import com.brainmatics.pos.core.product.Product;
import com.brainmatics.pos.core.product.ProductService;
import com.brainmatics.pos.core.sale.Sale;
import com.brainmatics.pos.core.sale.SaleLineItem;
import com.brainmatics.pos.core.sale.SaleRepo;
import com.brainmatics.pos.infra.data.jdbc.ProductJdbcRepo;
import com.brainmatics.pos.infra.data.jdbc.SaleJdbcRepo;
import com.brainmatics.pos.infra.data.mongodb.ProductMongoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.math.BigDecimal;
import java.time.LocalDate;

@SpringBootApplication
public class PosApplication implements CommandLineRunner {

	@Autowired
	JdbcTemplate jdbc;

	public static void main(String[] args) {
		SpringApplication.run(PosApplication.class, args); //untuk web
		//untuk spring
//		ApplicationContext ctx = SpringApplication.run(PosApplication.class, args);
//		ProductService service = ctx.getBean(ProductService.class);
//		System.out.println(service.generateCode());
		//
	}

	@Override
	public void run(String... strings) throws Exception {
		//jdbc.execute("CREATE TABLE Employee (id int primary key, name varchar(50))");
//		jdbc.execute("INSERT INTO Employee values(1,'Michael Suyama')");
//        jdbc.execute("INSERT INTO Employee values(2,'Nancy Devvalio')");
//		List<Employee> emps = jdbc.query("SELECT id, name FROM Employee Where id=?", new Object[]{2}, (rs, num) ->{
//			Employee e = new Employee();
//			e.setId(rs.getInt("id"));
//			e.setName(rs.getString("name"));
//			return e;
//		} );
//        for (Employee e: emps) {
//            System.out.println(e.getName());
//        }
//        ProductJdbcRepo prdJdbc  = new ProductJdbcRepo(jdbc);
//        for(Product p: prdJdbc.getAll()){
//            System.out.println(p.getName());
//        }
//        Product p = prdJdbc.getById(1);
//        System.out.println(p.getName());
//        System.out.println(prdJdbc.getCount());

//        Product p1 = new Product();
//        p1.setId(3);
//        p1.setCode("P3");
//        p1.setName("Ayam Goreng");
//        p1.setPrice(10000);
//        prdJdbc.insert(p1);

 //       prdJdbc.remove(3);

//        SaleJdbcRepo saleRepo = new SaleJdbcRepo(jdbc);
//        Sale s = saleRepo.getById(1);
//        for(SaleLineItem sli : s.getlineItems()){
//            System.out.println(sli.getProduct().getName());
//        }
//
//        s = saleRepo.getByIdEager(1);
//        for(SaleLineItem sli : s.getlineItems()){
//            System.out.println(sli.getProduct().getName());
//        }
		initDb();

	}

//	public void main1(String[] args) {
//		Product p1 = new Product();
//		p1.setId(1);
//		p1.setName("Momogi");
//		p1.setPrice(BigDecimal.valueOf(500));
//
//		Product p2 = new Product();
//		p2.setId(2);
//		p2.setName("Pepsi");
//		p2.setPrice(BigDecimal.valueOf(5_000));

//		ProductRepository repo = new ProductRepository();
//		repo.save(p1);
//		repo.save(p2);
//
//		Product prd2 = repo.getById(2);
//		System.out.println(prd2.getName());

		//tampilkan semu aproduct
//		ArrayList<Product> prdAll = repo.getAll();
//
//		for(Product p: prdAll){
//			System.out.println(p.getName());
//		}
//		ProductService service = new ProductService(new ProductMongoRepo());
//		System.out.println(service.generateCode());

//	}
	public void initDb() {
//		Employee e1 = new Employee();
//		e1.setId(1);
//		e1.setName("Michael Suyama");
//		e1.setBirthdate(LocalDate.of(2001, 3, 20));
//
		Employee e2 = new Employee();
		e2.setId(2);
		e2.setName("Nancy");
		//e2.setBirthdate(LocalDate.of(1998, 2, 1));

		Product p1 = new Product();
		p1.setId(4);
		p1.setName("Tisu");
		p1.setPrice(BigDecimal.valueOf(5000));

		Product p2 = new Product();
		p2.setId(5);
		p2.setName("Pencil");
		p2.setPrice(BigDecimal.valueOf(5000));

		Product p3 = new Product();
		p3.setId(6);
		p3.setName("Susu Ultra");
		p3.setPrice(BigDecimal.valueOf(5000));
//
		Sale s1 = new Sale();
		s1.setId(3);
		s1.setCashier(e2);

        s1.addlineItems(p1,1);
		s1.addlineItems(p2,2);

//		ProductJdbcRepo prdRepo = new ProductJdbcRepo(jdbc);
//		prdRepo.insert(p1);
//		prdRepo.insert(p2);

		SaleJdbcRepo saleRepo = new SaleJdbcRepo(jdbc);
		saleRepo.insert(s1);

//		Sale s2 = new Sale();
//		s2.setId(2);
//		s2.setCashier(e2);
//		s2.addProducts(p1);
//		s2.addProducts(p3);
//
//		System.out.println(s1.getCashier().getName());
//		System.out.println(s1.getTime());
//		for (Product p:s1.getProducts()) {
//			System.out.println(p.getName());
//		}
//		System.out.println(s1.getTotal());
//
//		System.out.println();
//
//		System.out.println(s2.getCashier().getName());
//		System.out.println(s2.getTime());
//		for (Product p:s2.getProducts()) {
//			System.out.println(p.getName());
//		}
//		System.out.println(s2.getTotal());
	}
}
