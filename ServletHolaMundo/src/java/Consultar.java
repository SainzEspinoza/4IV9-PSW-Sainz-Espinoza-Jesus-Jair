/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//Esta se encarga del objeto para la conexion con la base de datos
import java.sql.Connection;
import java.sql.DriverManager;
//Esta se encarga de poder realizar las sentencias SQl como son:
//insert, delete, update, create, alter, drop
import java.sql.Statement;
//Esta se encarga para generar un objeto para poder realizar las consultas SQL
import java.sql.ResultSet;
import javax.servlet.ServletConfig;

/**
 *
 * @author Hola
 */
public class Consultar extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private Connection con;
    private Statement set;
    private ResultSet rs;
    
    //constructor
    public void init(ServletConfig cfg) throws ServletException{
        
        //como se va a conectar a la base de datos
        String url = "jdbc:mysql:3306//localhost/registro4iv9";
                    //tipodriver:gestorBD:puerto//IP/nombrebd
                    
        String userName = "root";
        String password = "Jesus.sainz1";
       
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
             /*
            A veces el tipo de driver ya tiene incluido el puerto de comunicacion,
            es por ello que nos arroja un error de conexion, para resolver este error,
            simplemente hacemos lo siguiente:
            url ="jdbc:mysql://localhost/registro4iv9";
            */
            url = "jdbc:mysql://localhost/registro4iv9";
            con =DriverManager.getConnection(url, userName, password);
            set = con.createStatement();
        
            System.out.println("Conexion exitosa");
        
        }catch(Exception e){
            System.out.println("Conexion no exitosa");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        }
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Consultar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Tabla del Registro de Usuarios</h1>"
                    + "<table border='2'>"
                    + "<thead>"
                        + "<tr>"
                        + "<th>ID</th>"
                        + "<th>Nombre Completo</th>"
                        + "<th>Edad</th>"
                        + "<th>Correo</th>"
                        + "</tr>"
                    + "<thead>"
                    + "<tbody>");
            String nom, appat, apmat, correo, q;
            int edad, id;
            
            q = "select * from mregistro";
            try{
                set = con.createStatement();
                rs = set.executeQuery(q);
                while(rs.next()){
                    id = rs.getInt("id_usu");
                    nom = rs.getString("nom_usu");
                    appat = rs.getString("appat_usu");
                    apmat = rs.getString("apmat_usu");
                    edad = rs.getInt("edad_usu");
                    correo = rs.getString("email_usu");
                    out.println("<tr>"
                                + "<td>"+id+"</td>"
                                + "<td>"+nom+" "+appat+" "+apmat+"</td>"
                                + "<td>"+edad+"</td>"
                                + "<td>"+correo+"</td>"
                            + "</tr>");
                }
                System.out.println("Consulta exitosa");
                rs.close();
                set.close();
            
            }catch(Exception e){
                System.out.println("Error al realizar la consulta");
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
            
            }
            out.println("</tbody>"
                    + "</table>"
                    + "<br>"
                    + "<div class=\"contenedorActualizar\" >\n"
                    + "<br>\n"
                    +  "<h1>Modificar Usuario</h1>\n"
                    + "<form method=\"post\" name=\"formularioactualizar\" action=\"Actualizar\">\n"
                    + "<label>Ingresa el ID del usuario que desea Actualizar</label>\n"
                    + "<input type=\"number\" name=\"idactualizar\" >\n"
                    + "<label>Selecciona el campo a modificar</label>\n"
                    + "<select name=\"Seleccion\" id=\"Seleccion\" >\n"
                    + "<option value=\"nombre\">Nombre</option>\n"
                    + "<option value=\"appat\">Apellido paterno</option>\n"
                    + "<option value=\"apmat\">Appellido materno</option>\n"
                    + "<option value=\"edad\">Edad</option>\n"
                    + "<option value=\"correo\">Correo</option>\n"
                    + "</select>\n"
                    + "<label>Ingresa el valor por el que lo vas a modificar</label>\n"
                    + "<input type=\"text\" name=\"cambio\">             \n"
                    + "<input type=\"submit\" value=\"Actualizar Usuario\" class=\"boton\">\n"
                    + "</form>\n" 
                    + "<br>\n" 
                    + "<br>\n"
                    + "</div>"
                    + "<a href='index.html' >Regresar al Menu Principal</a>"
                    + "<br>"
                    + "<a href='index.html' >Nuevo Registro</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    public void destroy(){
        try{
            con.close();
        }catch(Exception e){
            super.destroy();
        }
    } 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
