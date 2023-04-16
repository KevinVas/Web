package cadastro.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cadastro.web.bean.*;
import cadastro.web.dao.*;


@WebServlet(urlPatterns={"/controller","/main","/insert"})
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	dao dao=new dao();
	
	coordenador coo= new coordenador();
    
    public controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action =request.getServletPath();
		System.out.println(action);
       if(action.equals("/main")) {
    	   coordenadores(request,response);
          }else if (action.equals("/insert")) {
        	  novoCoordenador(request,response);
          }else {
        	  response.sendRedirect("index.htmal");
          }
}
	protected void coordenadores(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("coordenadores.jsp");
	}
	protected void novoCoordenador(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
        coo.setNome(request.getParameter("nome"));
        coo.setCurso(request.getParameter("curso"));
        coo.setPeriodo(request.getParameter("periodo"));
        dao.inserirCoordenador(coo);
        response.sendRedirect("main");

	}
}
	
	


