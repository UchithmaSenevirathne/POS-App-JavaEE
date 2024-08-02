package lk.ijse.posbackend.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
@WebServlet(urlPatterns = "/item", loadOnStartup = 2)
public class Item extends HttpServlet {
}
