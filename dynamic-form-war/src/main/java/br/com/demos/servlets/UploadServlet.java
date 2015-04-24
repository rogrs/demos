package br.com.demos.servlets;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import br.com.demos.jpa.service.impl.EventoServiceImpl;
import br.com.demos.jpa.service.impl.PropriedadeServiceImpl;
import br.com.demos.util.HostInfo;
import br.com.demos.vo.Evento;
import br.com.demos.vo.Propriedades;

/**
 * Servlet implementation class UploadServlet
 */
@WebServlet("/upload")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50)
// 50MB
public class UploadServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final String UPLOAD_PATH = "UPLOAD_PATH";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
    }

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length() - 1);
            }
        }
        return "";
    }

    private Propriedades getPropetyDB(String chave) {
        PropriedadeServiceImpl impl = new PropriedadeServiceImpl();

        return impl.findKey(chave);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        EventoServiceImpl impl = new EventoServiceImpl();

        Evento entity = new Evento();
        // gets absolute path of the web application
        // String appPath = request.getServletContext().getRealPath("");

        Propriedades p = getPropetyDB(UPLOAD_PATH);
        // constructs path of the directory to save uploaded file
        String savePath = p.getValor(); // appPath + File.separator + SAVE_DIR;

        // creates the save directory if it does not exists
        File fileSaveDir = new File(savePath);
        if (!fileSaveDir.exists()) {
            fileSaveDir.mkdir();
        }

        for (Part part : request.getParts()) {
            String fileName = extractFileName(part);
            part.write(savePath + File.separator + fileName);
        }

        entity.setDtcreate(new Date());
        entity.setSistema("DEMO");
        entity.setMsg("Realizando upload do arquivo " + savePath);
        entity.setTipo("INFO");
        entity.setHostname(HostInfo.getHostAddress());
        entity.setUsuario(request.getRemoteAddr());

        impl.persist(entity);
        request.setAttribute("message", "Upload has been done successfully!");
        getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
    }

}
