
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListaPessoasServlet", urlPatterns = {"/index.html"})
public class PaisesServlet extends HttpServlet implements Comparator<String>{

    private List<String> frutas;

    public PaisesServlet() {
        frutas = new ArrayList<String>();
        frutas.add("Banana");
        frutas.add("Laranja");
        frutas.add("Limao");
        frutas.add("Maca");
        frutas.add("Maracuja");
        frutas.add("Abacaxi");
    }
    
    @Override
    public int compare(String a, String b){        
        return a.length() - b.length();
    }
        

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try (PrintWriter out = response.getWriter()) {
            String comand = "alfa";
            comand = request.getParameter("comando");

            if("alfa".equals(comand)){
                Collections.sort(frutas);        
            }else if ("tam".equals(comand)){
                //Collections.sort(frutas, (a,b)-> a.length()-b.length());
                Collections.sort(frutas, this);
            }else{
                Collections.shuffle(frutas);
            }
            
        
            response.setContentType("text/html;charset=UTF-8");
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Pessoas</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Frutas</h1>");
            out.println("<ul>");            

            for (String frutas : frutas) {
                out.println("<li>" + frutas + "</li>");
            }
            
            out.println("</ul>");
            out.println("<a href = '?comando=alfa'>Ordem Alfabetica</a><BR>");            
            out.println("<a href = '?comando=rand'>Ordem Aleatória</a><BR>");
            out.println("<a href = '?comando=tam'>Ordem Tamanho Palavra</a><BR>");
            out.println("</body>");
            out.println("</html>");
        }       
        

    }
}
