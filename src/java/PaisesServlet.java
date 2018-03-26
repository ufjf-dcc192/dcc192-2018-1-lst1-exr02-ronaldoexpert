
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListaPessoasServlet", urlPatterns = {"/index.html"})
public class PaisesServlet extends HttpServlet implements Comparator<String>{

    private final HashMap<String, String> paises = new HashMap<String, String>();
    
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
            out.println("<h1>Países</h1>");
            out.println("<ul>");       
            
            /*Set<String> chaves = paises.keySet();
            for (String chave : chaves)
            {
                if(chave != null)
                    out.println("<li>" + chave + " - "+ paises.get(chave) + "</li>");
            }*/
            
            TreeMap treePreCurso=new TreeMap(paises);
            Iterator k=treePreCurso.keySet().iterator();
            while (k.hasNext()){
                    String curso=(String)k.next();
                    String preco=(String)paises.get(curso);
                    out.println("<li>" + curso + " : " + preco + "</li>");
            }
            out.println("</ul>");
            //out.println("<a href = '?comando=alfa'>Ordem Alfabetica</a><BR>");            
            //out.println("<a href = '?comando=rand'>Ordem Aleatória</a><BR>");
            //out.println("<a href = '?comando=tam'>Ordem Tamanho Palavra</a><BR>");
            out.println("</body>");
            out.println("</html>");
        }       
        

    }

    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }
}
