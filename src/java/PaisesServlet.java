
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListaPessoasServlet", urlPatterns = {"/index.html"})
public class PaisesServlet extends HttpServlet{

    private Map<String, String> paises = new HashMap<String, String>();

    public PaisesServlet() {        
        paises.put("Brasil", "Azul");
        paises.put("Australia", "Amarelo");
        paises.put("Estados Unidos", "Vermelho");
        paises.put("Japão", "Branco");
        paises.put("Colombia", "Verde");
    }        

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try (PrintWriter out = response.getWriter()) {
            String comand = "";
            comand = request.getParameter("comando");

            response.setContentType("text/html;charset=UTF-8");
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Países</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Frutas</h1>");
            out.println("<ul>");            
            for (int i = 0; i < paises.size(); i++) {
                out.println("<li>" + paises.get(i).toString() + "</li>");
            }            
            out.println("</ul>");
            //out.println("<a href = '?comando=alfa'>Ordem Alfabetica</a><BR>");            
            //out.println("<a href = '?comando=rand'>Ordem Aleatória</a><BR>");
            //out.println("<a href = '?comando=tam'>Ordem Tamanho Palavra</a><BR>");
            out.println("</body>");
            out.println("</html>");
        }       
        

    }
}
