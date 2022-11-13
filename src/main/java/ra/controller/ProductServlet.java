package ra.controller;

import ra.model.emtity.Product;
import ra.model.service.ProductService;
import ra.model.serviceIpm.ProductServiceIpm;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.swing.*;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    private ProductService<Product, Integer> productService = new ProductServiceIpm();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action= request.getParameter("action");
        if (action!=null && action.equals("Update")){
            Product pr=new Product();
            pr= productService.getById(Integer.parseInt(request.getParameter("productId")));
            request.setAttribute("product",pr);
            request.getRequestDispatcher("views/updateProduct.jsp").forward(request,response);
        } else if(action!=null && action.equals("Delete")){
            boolean check= productService.delete(Integer.parseInt(request.getParameter("productId")));
            if (check) {
                getAll(request, response);
            }else {
                request.getRequestDispatcher("views/err.jsp").forward(request,response);
            }
        }
        getAll(request, response);
    }

    public void getAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productService.getAll();
        request.setAttribute("productList", productList);
        request.getRequestDispatcher("views/products.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null && action.equals("Creat")) {
            Product pr = new Product();
            pr.setProductName(request.getParameter("Name"));
            pr.setProductPrice(Float.parseFloat(request.getParameter("Price")));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                pr.setDateCreated(sdf.parse(request.getParameter("Creat Date")));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            pr.setDescriptions(request.getParameter("Descriptions"));
            pr.setProductStatus(Boolean.parseBoolean(request.getParameter("Status")));
            boolean result = productService.save(pr);
            if (result) {
                getAll(request, response);
            }
        } else if (action!=null && action.equals("Update")) {
            Product pr = new Product();
            pr.setProductId(Integer.parseInt(request.getParameter("Id")));
            pr.setProductName(request.getParameter("Name"));
            pr.setProductPrice(Float.parseFloat(request.getParameter("Price")));
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            try {
                pr.setDateCreated(sdf.parse(request.getParameter("Creat Date")));
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
            pr.setDescriptions(request.getParameter("Descriptions"));
            pr.setProductStatus(Boolean.parseBoolean(request.getParameter("status")));
            boolean result = productService.update(pr);
            if (result) {
                getAll(request, response);
            }else {
                request.getRequestDispatcher("views/err.jsp").forward(request,response);
            }
        } else if (action!=null && action.equals("Search")){
            String searchProduct= request.getParameter("searchProduct");
            if (searchProduct.contains("~")){
                String[] value=searchProduct.split("\\~");
                float value1=Float.parseFloat(value[0]);
                float value2=Float.parseFloat(value[1]);
                List<Product>searchProductList =productService.searchByPrice(value1,value2);
                if (searchProductList!=null){
                    request.setAttribute("productList", searchProductList);
                    request.getRequestDispatcher("views/products.jsp").forward(request, response);
                }else {
                    getAll(request,response);
                }
            }else {
                List<Product>searchProductList =productService.searchByName(searchProduct);
                request.setAttribute("productList", searchProductList);
                request.getRequestDispatcher("views/products.jsp").forward(request, response);
                if (searchProductList!=null){
                    request.setAttribute("productList",searchProductList);
                    request.getRequestDispatcher("views/products.jsp").forward(request, response);
                }else {
                    getAll(request,response);
                }
            }
        } else if (action!=null && action.equals("SortByPrice")){
            List<Product> productList = productService.sortByPrice();
            request.setAttribute("productList", productList);
            request.getRequestDispatcher("views/products.jsp").forward(request, response);

        }
    }
}
