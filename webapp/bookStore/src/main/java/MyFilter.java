import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter("/servlet1")
public class MyFilter implements Filter {
    public void init(FilterConfig arg0) throws ServletException {}  
      
public void doFilter(ServletRequest req, ServletResponse resp,  
        FilterChain chain) throws IOException, ServletException {  
          
    PrintWriter out=resp.getWriter();  
          
    String password=req.getParameter("password");  
    String name=req.getParameter("name");
    
    if(password.equals("admin")){  
    chain.doFilter(req, resp);//sends request to next resource  
    }  
    else{  
        String invalid =("username or password error!");
        req.setAttribute("invalid",invalid);
   // System.out.print("username or password error!");  
    RequestDispatcher rd=req.getRequestDispatcher("index.jsp");  
    rd.include(req, resp);  
    }  
          
}  
    public void destroy() {}

   
  
}  

    

