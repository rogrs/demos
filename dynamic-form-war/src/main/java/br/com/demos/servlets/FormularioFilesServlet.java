package br.com.demos.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.demos.jpa.service.impl.FormularioFilesServiceImpl;
import br.com.demos.jpa.service.impl.PropriedadeServiceImpl;
import br.com.demos.util.ID;
import br.com.demos.vo.FormularioFiles;
import br.com.demos.vo.Propriedades;

/**
 * Servlet implementation class FormularioFilesServlet
 */
@WebServlet("/files")
public class FormularioFilesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    private static final String URL_PATH = "URL_PATH";
    
    private static  FormularioFilesServiceImpl service; 

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormularioFilesServlet() {
        super();
        service = new FormularioFilesServiceImpl();
    }
    
    private Propriedades getPropetyDB(String chave) {
        PropriedadeServiceImpl impl = new PropriedadeServiceImpl();
        return impl.findKey(chave);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
      
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        List<FormularioFiles> listFiles = null;
        ID idFormulario = new ID(request.getParameter("formulario"));
        StringBuilder sb = new StringBuilder();
       
        try {
           
            listFiles = service.findFilesByFormulario(idFormulario.getValue());
            for (FormularioFiles formFiles : listFiles) {
                sb.append(tagIMG(formFiles.getFilepath()));
            }

            
            out.println(doPage(sb.toString()));
        } finally {
            out.close();
        }
    }

    private String doPage(String tag) {

        StringBuilder sb = new StringBuilder();
        sb.append(" <!DOCTYPE html> ")
          .append(" <html lang='pt-br'> ")
          .append(" <head> ")
          .append("  <meta charset='UTF-8' /> ")
          .append("  <title>Listagem de Imagens</title> ")
          .append(" </head> ")
          .append("  <body> ")
          .append(tag)
           .append("<p> ")
          .append(" </body> ")
          .append(" </html>");

        return sb.toString();
    }

    private String tagIMG(String fileName) {
        Propriedades property = getPropetyDB(URL_PATH);

        StringBuilder sb = new StringBuilder();
        sb.append("<label for='componente'>" + fileName + "</label>");
        sb.append("<p><img data-src='holder.js/200x200' class='img-thumbnail' src='"+property.getValor() + fileName + "' alt='" + fileName + "' data-holder-rendered='true' style='width: 400px; height: 400px;' > </p>");

        return sb.toString();
    }

   
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

}
