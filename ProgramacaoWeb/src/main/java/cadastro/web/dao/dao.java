package cadastro.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import cadastro.web.bean.coordenador;

public class dao {
	private String driver ="com.mysql.cj.jdc.Driver";
	private String url="jdv:mysql;//127.0.0.1:3306/dbcadastro";
	private String user="root";
	private String password="ceuvermelho";
	 

	private Connection conectar() {
		Connection con=null;
		try {
		Class.forName(driver);
		con = DriverManager.getConnection(url, user, password);
		return con;
	}catch (Exception e) {
		 System.out.println(e);
			return null;
	}
	}
	public void inserirCoordenador(coordenador coo) {
		String creat=" insert into cordenador(nome,cursos,periodos) values (?,?,?)";
	try{
		Connection con=conectar();
		PreparedStatement pst=con.prepareStatement(creat);
		pst.setString(1, coo.getNome());
		pst.setString(2, coo.getCurso());
		pst.setString(3, coo.getPeriodo());
		pst.executeUpdate();
		con.close();

		}catch (Exception e) {
			System.out.println(e);
		}
	}
	}