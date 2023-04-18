package cadastro.web.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cadastro.web.bean.coordenador;
import cadastro.web.dao.dao;


@WebServlet(urlPatterns={"/controller","/main","/insert","/select","/update","/delete"})
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
          }else if (action.equals("/select")) {
        	  listarCoordenador(request,response);
          }else if (action.equals("/update")) {
        	  editarCoordenador(request,response);
          } else if (action.equals("/excluir")) {
        	  excluirCoordenador(request,response);
          } else {
        	  response.sendRedirect("index.htmal");
          }
}
	protected void coordenadores(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		ArrayList<coordenador>lista = dao.listarCoordenador();
		request.setAttribute("coordenador", lista);
		RequestDispatcher rd= request.getRequestDispatcher("coordenadores.jsp");
		rd.forward(request, response);
		
	}
	
	protected void novoCoordenador(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
        coo.setNome(request.getParameter("nome"));
        coo.setCurso(request.getParameter("curso"));
        coo.setPeriodo(request.getParameter("periodo"));
        dao.inserirCoordenador(coo);
        response.sendRedirect("main");
      
	}
	
	protected void listarCoordenador(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException  {
		String nome=request.getParameter("nome");
        coo.setNome(nome);
        dao.selecionarCoordenador(coo); 
        request.setAttribute("nome", coo.getNome());
        request.setAttribute("curso", coo.getCurso());
        request.setAttribute("periodo", coo.getPeriodo());
        RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
           rd.forward(request, response);

  }
	protected void editarCoordenador(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException  {
		//System.out.println(request.getParameter("nome"));
		//System.out.println(request.getParameter("curso"));
		//System.out.println(request.getParameter("periodo"));

		coo.setNome(request.getParameter("nome"));
		coo.setCurso(request.getParameter("curso"));
	    coo.setPeriodo(request.getParameter("periodo"));
		dao.alterar(coo);
		response.sendRedirect("main");


	}
	protected void excluirCoordenador(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException  {
		String nome=request.getParameter("nome");
        coo.setNome(nome);
        dao.excluirCoordenador(coo);
        response.sendRedirect("main");
	}
  }
	
	


