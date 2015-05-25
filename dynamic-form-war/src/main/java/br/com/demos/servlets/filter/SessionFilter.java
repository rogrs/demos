package br.com.demos.servlets.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class SessionFilter
 */
//@WebFilter(value = "/SessionFilter", initParams = { @WebInitParam(name = "avoid-urls", value = "Home.html") })

@WebFilter(filterName = "TimeOfDayFilter",
urlPatterns = {"/private/*"},
initParams = {
    @WebInitParam(name = "avoid-urls", value = "Home.html")})
public class SessionFilter implements Filter {

    private ArrayList<String> urlList;

    /**
     * Default constructor.
     */
    public SessionFilter() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
        // TODO Auto-generated method stub
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        String url = request.getServletPath();
        boolean allowedRequest = false;

     /*   if (urlList.contains(url)) {
            allowedRequest = true;
        }

        if (!allowedRequest) {
            HttpSession session = request.getSession(false);
            if (session == null) {
            
                response.sendRedirect("../Home.html");
            }
        }*/
        System.out.println(req.toString()+" "+res.toString());
        
       
        chain.doFilter(req, res);
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig config) throws ServletException {
        String urls = config.getInitParameter("avoid-urls");
        StringTokenizer token = new StringTokenizer(urls, ",");

        urlList = new ArrayList<String>();

        while (token.hasMoreTokens()) {
            urlList.add(token.nextToken());

        }
    }

}
