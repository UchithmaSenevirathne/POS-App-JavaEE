package lk.ijse.posbackend.filter;

import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;

@WebFilter(urlPatterns = "/*")
public class CORSFilter extends HttpFilter {
}
