package com.kgisl.demo1.Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kgisl.demo1.Entity.Product;

public class ProductController extends HttpServlet {
    
 @Override
 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     doPost(req, resp);
 }
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  
  String action = req.getServletPath();
  System.out.println(action);

  switch (action) {
      case "/new":
          showNewForm(req, resp);
          break;
      case "/insert":
          insertBook(req, resp);
          break;
      case "/delete":
          deleteBook(req, resp);
          break;
      case "/edit":
          showNewForm(req, resp);
          break;
      case "/update":
          updateBook(req, resp);
          break;
      default:
          listProduct(req, resp);
          break;
  }
    
    }
private void updateBook(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1/bookstore?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "root", "")) {
            int Product_id = Integer.parseInt(req.getParameter("Product_id"));
            String Product_name = req.getParameter("Product_name");
            String Product_price = req.getParameter("Product_price");
            float Product_weight = Float.parseFloat(req.getParameter("Product_weight"));
            Product products = new Product(Product_id,Product_name,Product_price,Product_weight);
            String sql = "UPDATE productss SET Product_name = ?, Product_price = ?, Product_weight= ?";
            sql += " WHERE Product_id = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, products.getProduct_id());
            statement.setString(2, products.getProduct_name());
            statement.setInt(3, products.getProduct_price());
            statement.setFloat(4, products.getProduct_weight());
            statement.executeUpdate();
            statement.close();
            con.close();
            resp.sendRedirect("/list");

        } catch (SQLException e) {
            e.printStackTrace();
        }
}
private void deleteBook(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1/bookstore?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "root", "")) {
            int id = Integer.parseInt(req.getParameter("id"));
            Product products = new Product(id, null, 0,0);
            String sql = "DELETE FROM productss where Product_id = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, products.getProduct_id());
            statement.executeUpdate();
            statement.close();
            con.close();
            resp.sendRedirect("/list");

        } catch (SQLException e) {
            e.printStackTrace();
        }
}
private void insertBook(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    try (Connection con = DriverManager.getConnection(
        "jdbc:mysql://127.0.0.1/bookstore?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
        "root", "")) {

    String product_name= req.getParameter("Product_name");
    String product_price = req.getParameter("Product_price");
    float product_weight = Float.parseFloat(req.getParameter("Product_weight"));
   Product products = new Product(product_name, product_price, product_weight);
    String sql = "INSERT INTO Product (Product_name,Product_price,Product_weight) VALUES (?, ?, ?)";
    PreparedStatement statement = con.prepareStatement(sql);
    statement.setString(1, products.getProduct_name());
    statement.setInt(2, products.getProduct_price());
    statement.setFloat(3, products.getProduct_weight());
    statement.executeUpdate();
    statement.close();
    con.close();
    resp.sendRedirect("/list");
} catch (SQLException e) {
    e.printStackTrace();
}
}
private void listProduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1/productss?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "root", "")) {
             ArrayList<Product> productlist = new ArrayList<Product>();
            java.sql.Statement stmt = con.createStatement();
            ResultSet rset = stmt.executeQuery("select * from product");
            while (rset.next()) {
                productlist.add(new Product(rset.getInt("product_id"), rset.getString("product_name"), rset.getInt("product_price"),
                        rset.getFloat("product_weight")));
            }
    
            stmt.close();
            con.close();
            productlist.forEach(System.out::println);
            req.setAttribute("productlist", productlist);
            RequestDispatcher dispatcher = req.getRequestDispatcher("Productlist.jsp");
            dispatcher.forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void showNewForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("ProductForm.jsp");
            dispatcher.forward(req, resp);
    }
    public void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
            try (Connection con = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1/bookstore?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
                "root", "")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Product Product = null;
            String sql = "SELECT * FROM Productss WHERE Product_id = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String Product_name = resultSet.getString("Product_name");
                String Product_price = resultSet.getString("Product_price");
                float Product_weight = resultSet.getFloat("Product_weight");
                Product = new Product(0, null, 0, 0);
            }
            resultSet.close();
            statement.close();
            con.close();
            RequestDispatcher dispatcher = request.getRequestDispatcher("ProductForm.jsp");
            request.setAttribute("Productlist", Product);
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
    
}


}