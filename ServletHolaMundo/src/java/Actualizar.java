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
import java.util.Scanner;
import javax.servlet.ServletConfig;

/**
 *
 * @author Hola
 */
public class Actualizar extends HttpServlet {

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
    
        //como se va a conectar a la bd
        String url = "jdbc:mysql:3306//localhost/registro4iv9";
                    //tipodriver:gestorbd:puerto//IP/nombrebd
                    
        String userName = "root";
        String password = "Jesus.sainz1";
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            /*
            A veces el tipo de driver ya tiene incluido el puerto de comunicacion, 
            es por ello que nos arroja un error de conexion, para resolver este error
            simplemente hacemos lo siguiente:
            url = "jdbc:mysql://localhost/registro4iv9";
            */
            url = "jdbc:mysql://localhost/registro4iv9";
            con = DriverManager.getConnection(url, userName, password);
            set = con.createStatement();
            
            System.out.println("Conexion exitosa");
        
        }catch(Exception e){
            System.out.println("Conexion no exitosa");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        
        }
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
       
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Actualizar</title>");            
            out.println("</head>");
            out.println("<body>");
            
            
            String nom, appat, apmat, correo, q="", seleccion, cambio;
            int edad, id;
            
            id = Integer.parseInt(request.getParameter("idactualizar"));
            
            seleccion = request.getParameter("Seleccion");
            
            cambio = request.getParameter("cambio");
            
            System.out.println(id +" "+seleccion +" "+cambio);
            
            try{
                switch(seleccion){
                    case "nombre":
                        q = "UPDATE mregistro SET nom_usu ='"+cambio+"' where id_usu ="+id;
                        break;
                    case "appat":
                        q = " UPDATE mregistro SET appat_usu ='"+cambio+"' where id_usu ="+id;
                        break;
                    case "apmat":
                        q = " UPDATE mregistro SET apmat_usu ='"+cambio+"' where id_usu ="+id;
                        break;
                    case "edad":
                        q = " UPDATE mregistro SET edad_usu ='"+cambio+"' where id_usu ="+id;
                        break;
                    case "correo":
                        q = "UPDATE mregistro SET email_usu ='"+cambio+"'where id_usu ="+id;
                        break;
                }
                
                set.executeUpdate(q);
                out.println("<h1>Usuario Actualizado</h1>");
                System.out.println("Registro Actualizado");
            
            }catch(Exception e){
                
                out.println("<h1>Usuario No Actualizado, ocurrio un error</h1>");
                System.out.println("Error al Actualizar el registro");
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
            
            }
            
            out.println("<h1>Usuario Actualizado</h1>"
                    + "<br>"
                    + "<a href='index.html' >Regresar al Menu Principal</a>"
                    + "<br>"
                    + "<a href='Registro' >Nuevo Registro</a>"
                    + "<br>"
                    + "<a href='Consultar' >Consultar Tabla General de Usuarios</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    
    public void destroy(){
        try{
            con.close();
        }catch(Exception e){
            super.destroy();
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
