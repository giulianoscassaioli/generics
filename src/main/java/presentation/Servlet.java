package presentation;

import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import actions.MostraTuttiAction;
import business.GenericsEJB;
import entity.Corso;
import entity.Studente;


@WebServlet("/gestione/*")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public Servlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doPost(request, response);
	}

	
	
	@EJB
	GenericsEJB ej;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		String path= request.getPathInfo();
		
		switch (path) {
			case "/studente/mostratutti":
				new MostraTuttiAction<Studente>(Studente.class).esegui(request, response, ej);
				break;
			case "/corso/mostratutti":
				new MostraTuttiAction<Corso>(Corso.class).esegui(request, response, ej);
				break;
		
		}
	
	}

}
