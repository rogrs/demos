package br.com.demos.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.demos.components.html.PageHTML;
import br.com.demos.jpa.service.impl.PerguntaServiceImpl;
import br.com.demos.jpa.service.impl.PerguntaValuesServiceImpl;
import br.com.demos.vo.Perguntas;
import br.com.demos.vo.PerguntaValues;

@WebServlet("/formulario")
public class FormularioServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private PerguntaServiceImpl service;
    private PerguntaValuesServiceImpl serviceValues;

    public FormularioServlet() {
        super();

        service = new PerguntaServiceImpl();
        serviceValues = new PerguntaValuesServiceImpl();

        // http://bazalt-cms.com/ng-table/example/3
        // http://hello-angularjs.appspot.com/angularjs-http-service-ajax-post-json-data-code-example
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PageHTML page = new PageHTML();
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        StringBuilder data = new StringBuilder();

        List<Perguntas> perguntas = service.findAll();

        for (Perguntas pergunta : perguntas) {

            data.append(" <label for='" + pergunta.getId() + "'>")
                    .append(pergunta.getSequencia() + " - " + pergunta.getPergunta() + "</label>").append(doInputRespost(pergunta));

        }

        out.println(page.doPage2(data.toString()));

        out.close();
    }

    private String getSelectValues(Perguntas obj) {
        StringBuilder sb = new StringBuilder();
        List<PerguntaValues> values = null;

        values = serviceValues.findPergunta(obj);
        sb.append("<select name='list" + obj.getId() + "'>");
        for (PerguntaValues value : values) {
            sb.append("<option value='" + value.getChave() + "'>");
            sb.append(value.getValor() + "</option>");
        }
        sb.append("</select>");
        return sb.toString();
    }

    private String getRadioValues(Perguntas obj) {
        StringBuilder sb = new StringBuilder();
        List<PerguntaValues> values = null;

        values = serviceValues.findPergunta(obj);

        for (PerguntaValues value : values) {
            sb.append(" <input type='" + obj.getComponente() + "' name='radio" + obj.getId() + "' id='" + obj.getId() + "' value='"
                    + obj.getId() + "' checked>");
            sb.append(" <label for='label+" + value.getId() + "'>" + value.getValor() + "</label>  ");

        }

        return sb.toString();
    }

    private String getInput(Perguntas obj) {
        StringBuilder sb = new StringBuilder();
        sb.append("<input type='" + obj.getComponente() + "' name='input" + obj.getId() + "' id='" + obj.getId() + "'> ");
        return sb.toString();
    }

    private String doInputRespost(Perguntas obj) {
        StringBuilder sb = new StringBuilder();

        sb.append(" <p> ");
        switch (obj.getComponente()) {
        case "select":
            sb.append(getSelectValues(obj));
            break;
        case "radio":
            sb.append(getRadioValues(obj));

            break;
        case "text":
            sb.append(getInput(obj));
            break;

        case "number":
            sb.append(getInput(obj));
            break;
        default:
            sb.append(getInput(obj));
        }

        sb.append(" </p> ");

        return sb.toString();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
