package it.projectwork.login;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public LoginServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     doGet(request, response);
     
     //istanza
     ConnettiDB connessione = new ConnettiDB();
     
     //controllo se le credenziali inserite esistono del DB
     String insertUser = request.getParameter("user");
     String insertPass = request.getParameter("pass");
     
     try {
    	//metodo per controllare tutti gli username e password 
		if(connessione.controllaCredenziali(insertUser, insertPass) == true) {
			response.sendRedirect("Benvenuto.jsp");
		} else {response.resetBuffer();
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
     
     
	}

}
