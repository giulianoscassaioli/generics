package actions;

import java.io.IOException;

import business.GenericsEJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface Actions <T>{
	
	public void esegui(HttpServletRequest request, HttpServletResponse response,GenericsEJB ej) throws ServletException, IOException;

}
