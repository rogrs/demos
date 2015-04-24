package br.com.demos.components.html;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageHTML {

    private String title;

    private String getHeader() {
        StringBuilder sb = new StringBuilder();
        sb.append("<!DOCTYPE html>")
          .append("<html lang='pt-br'>")
          .append("<meta charset='UTF-8' />")
          .append("<title>" + title + "</title>")
          .append("<link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css'>")
           
         .append(" <script src='js/eventos.js'></script> ")
          .append("<script src='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js'></script>")
          .append("</head>")
          .append("<body>");

        return sb.toString();
    }
    
    private String  getHead2(){
        StringBuilder sb = new StringBuilder();
        
        sb.append(" <!doctype html> ")
          .append("<html> ")
          .append("<head> ")
          .append("<link rel='stylesheet' href='bootstrap-3.3.4-dist/css/bootstrap.css'>")
          .append("<meta charset='UTF-8'>")
          .append("  <title>Avaliação</title> ")
           .append(" <meta name='viewport' content='width=device-width'> ")
       .append(" </head> ")
        .append(" <body>")

         .append(" <div class='jumbotron'> ")
          .append("<div class='container'> ")
           .append(" <h1>Questionário</h1> ")
          .append("  <p>Responda as perguntas de maneira correta e no final clique no botão 'Enviar Dados'.</p> ")
          .append("<div> ")
         .append(" <div> ")

         .append(" <div class='panel panel-default'> ")
          .append("<div class='panel-heading'> ")
          .append("  <h2 class='panel-title'>Perguntas</h2> ")
         .append(" </div> ")
         .append(" <div class='panel-body'> ")

          .append("  <form action='/cadastrar.*' method='POST'> ");
        
        return sb.toString();
    }

    
    private String getFooter2() {
        StringBuilder sb = new StringBuilder();

   
        sb.append(" <div> ")
        .append(" <input type='submit' value='Enviar Dados'> ")
          .append(" <input type='reset' name='reset' value='Limpar Dados'> ")
          .append(" </div> ")
          .append(" </form>")
        
      .append("</div>")
     .append(" </div>")

    .append("</body>")
    .append("</html>");

        return sb.toString();
    }

    private String getFooter() {
        StringBuilder sb = new StringBuilder();

        sb.append("</body>")
          .append("</html>");

        return sb.toString();
    }

    public String doPage(String data) {
        StringBuilder sb = new StringBuilder();
        sb.append(getHeader())
          .append(data)
          .append(getFooter());

        return sb.toString();
    }
    
    
    public String doPage2(String data) {
        StringBuilder sb = new StringBuilder();
        sb.append(getHead2())
          .append(data)
          .append(getFooter2());

        return sb.toString();
    }
    
    
    public String addContanier(String data){
        StringBuilder sb = new StringBuilder();
        sb.append("<div class='container'>")
        .append("<div class='header clearfix'>")
          .append("<nav>")
           .append(" <ul class='nav nav-pills pull-right'>")
        .append(" <li role='presentation' class='active'><a href='http://getbootstrap.com/examples/jumbotron-narrow/#'>Home</a></li>")
          
          .append("  </ul> ")
          .append("</nav>")
          .append("<h3 class='text-muted'>Projeto Mobile</h3>")
        .append("</div>")

        .append("<div class='row marketing'>")
         .append(" <div class='col-lg-6'>")

          .append(data)
          
          .append(" </div> ")

        
        .append(" </div> ")

        .append(" <footer class='footer'> ")
          .append(" <p>© Company 2015</p> ")
         .append("</footer> ")

       .append("</div> <!-- /container --> ");
        
        return sb.toString();
    }

}
