package org.wds.controller;

import com.sun.net.httpserver.HttpServer;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.wds.beans.Product;
import org.wds.beans.ProductForm;
import org.wds.service.SaveProductAction;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * @author : TenYun
 * @date : 2020-05-16 23:24
 * @description :
 **/

//@Controller
//@RequestMapping("/h")
public class ControllerServlet extends HttpServlet {
    private static final long serialVersionUID = 1579L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);
    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String uri = req.getRequestURI();
        int lastIndex = uri.lastIndexOf("/");
        String action = uri.substring(lastIndex + 1);
        String dispatchUrl = null;
        if ("input-product".equals(action)) {
            dispatchUrl = "/jsp/ProductFrom.jsp";
        } else if ("save-product".equals(action)) {
            ProductForm productForm = new ProductForm();
            productForm.setName(req.getParameter("name"));
            productForm.setDescription(
                    req.getParameter("description"));
            productForm.setPrice(req.getParameter("price"));

            Product product = new Product();
            product.setName(productForm.getName());
            product.setDescription(productForm.getDescription());
            try {
                product.setPrice(new BigDecimal(productForm.getPrice()));
            } catch (NumberFormatException e) {
            }
            SaveProductAction saveProductAction =
                    new SaveProductAction();
            saveProductAction.save(product);
            // store model in a scope variable for the view
            req.setAttribute("product", product);
            dispatchUrl = "/jsp/ProductDetails.jsp";
        }

        if (dispatchUrl != null) {
            RequestDispatcher rd =
                    req.getRequestDispatcher(dispatchUrl);
            rd.forward(req, resp);
        }

    }


    @RequestMapping("/hello")
    public String sayHello(Model model) {
        model.addAttribute("msg", "hello,SpringMVC");
        return "hello";
    }


}
