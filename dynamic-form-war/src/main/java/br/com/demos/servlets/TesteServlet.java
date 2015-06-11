package br.com.demos.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import br.com.demos.jpa.service.impl.EventoServiceImpl;
import br.com.demos.util.HostInfo;
import br.com.demos.vo.Eventos;

/**
 * Servlet implementation class TesteServlet
 */
@WebServlet("/teste")
public class TesteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private static final Logger LOGGER = Logger.getLogger(TesteServlet.class);

    /**
     * Default constructor.
     */
    public TesteServlet() {

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = null;
        
        
        
        StringBuffer sb = new StringBuffer();
        try {
            out = response.getWriter();
            response.setContentType("text/html");
            
            Enumeration<String> e = request.getHeaderNames();
            
            sb.append("RemoteAddr= "+request.getRemoteAddr());
            sb.append("RemoteHost= "+request.getRemoteHost());
            sb.append("Protocol= "+request.getProtocol());
            sb.append("RemoteUser= "+request.getRemoteUser());
            sb.append("Method= "+request.getMethod());
          
            
            while (e.hasMoreElements()) {
                String headers = (String) e.nextElement();
                String paramValue = request.getHeader(headers);
                sb.append(headers+"= "+paramValue);
            }

            LOGGER.info(sb.toString());
            EventoServiceImpl impl = new EventoServiceImpl();

            Eventos entity = new Eventos();

            entity.setDtcreate(new Date());
            entity.setSistema("SPY");
            entity.setMsg("RemoteAddr= "+request.getRemoteAddr()+" RemoteHost= "+request.getRemoteHost());
            entity.setTipo("INFO");
            entity.setHostname(HostInfo.getHostAddress());
            entity.setUsuario(request.getRemoteAddr());

            impl.persist(entity);
            //out.println("IP Client "+request.getRemoteAddr());
           
        } finally {
            out.close();
            response.sendRedirect("Formulario.html");
        }

    }

}
