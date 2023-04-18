package cadastro.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import cadastro.web.bean.coordenador;

public class dao {
	private String driver ="com.mysql.cj.jdbc.Driver";
	private String url="jdbc:mysql://127.0.0.1:3306/cadastros?";
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
		String create=" insert into Coordenadores(nome,cursos,periodo) values (?,?,?)";
	try{
		Connection con=conectar();
		PreparedStatement pst=con.prepareStatement(create);
		pst.setString(1, coo.getNome());
		pst.setString(2, coo.getCurso());
		pst.setString(3, coo.getPeriodo());
		pst.executeUpdate();
		con.close();
}catch (Exception e) {
			System.out.println(e);
		}
	}
	public ArrayList<coordenador> listarCoordenador(){
	  ArrayList<coordenador> coo = new ArrayList<>();
	  String read= "select * from Coordenadores order by nome;";
	try {
		Connection con = conectar();
		PreparedStatement pst = con.prepareStatement(read);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			String nome = rs.getString(1);
			String curso = rs.getString(2);
			String periodo = rs.getString(3);
         coo.add(new coordenador(nome,curso,periodo));
		}
		con.close();
		
		return coo;
	} catch (Exception e) {
     System.out.println(e);
         return null;
}
	}
	 public void selecionarCoordenador(coordenador coo) {
		 String read2= "select * from Coordenadores where nome= ?";
		 try {
			Connection con=conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, coo.getNome());
			ResultSet rs= pst.executeQuery();
			while(rs.next()) {
				coo.setNome(rs.getString(1));				
				coo.setCurso(rs.getString(2));
				coo.setPeriodo(rs.getString(3));

			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	 }
		 public void alterar(coordenador coo) {
			String create = "update Coordenadores set nome=?,cursos=?,periodo=? where nome=?"; 
		 try {
			Connection con = conectar();
			PreparedStatement pst=con.prepareStatement(create);
		pst.setString(1,coo.getNome());
		pst.setString(2,coo.getCurso());
		pst.setString(3,coo.getPeriodo());
		pst.setString(4,coo.getNome());
		pst.executeUpdate();
		con.close();
		 } catch (Exception e) {
           System.out.println(e);		
}
		 }
		public void excluirCoordenador(coordenador coo) {
			String delete="delete from Coordenadores where nome=?";
			try {
				Connection con = conectar();
				PreparedStatement pst = con.prepareStatement(delete);
				pst.setString(1, coo.getNome());
				pst.executeUpdate();
				con.close();
			} catch (Exception e) {
              System.out.println(e);
}
			}
		
	}