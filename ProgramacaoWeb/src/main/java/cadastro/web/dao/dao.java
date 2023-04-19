package cadastro.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import cadastro.web.bean.coordenador;

public class dao {
	private String driver ="com.mysql.cj.jdbc.Driver";
	private String url="jdbc:mysql://127.0.0.1:3306/dbcadastro?";
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
		String create="insert into coordenador(nome,cursos,periodo) values (?,?,?)";
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
	  String read= "select * from coordenador order by id;";
	try {
		Connection con = conectar();
		PreparedStatement pst = con.prepareStatement(read);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			String id=rs.getString(1);
			String nome=rs.getString(2);
			String curso=rs.getString(3);
			String periodo=rs.getString(4);
         coo.add(new coordenador(id, nome, curso, periodo));
		}
		con.close();
		return coo;
	} catch (Exception e) {
     System.out.println(e);
         return null;
}
	}
	 public void selecionarCoordenador(coordenador coo) {
		 String read2= "select * from coordenador where id= ?";
		 try {
			Connection con=conectar();
			PreparedStatement pst = con.prepareStatement(read2);
			pst.setString(1, coo.getId());
			ResultSet rs= pst.executeQuery();
			while(rs.next()) {
				coo.setId(rs.getString(1));				
				coo.setNome(rs.getString(2));				
				coo.setCurso(rs.getString(3));
				coo.setPeriodo(rs.getString(4));

			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	 }
		 public void alterar(coordenador coo) {
			String create = "update coordenador set nome=?,cursos=?,periodo=? where id=?"; 
		 try {
			Connection con = conectar();
			PreparedStatement pst=con.prepareStatement(create);
		pst.setString(1,coo.getNome());
		pst.setString(2,coo.getCurso());
		pst.setString(3,coo.getPeriodo());
		pst.setString(4,coo.getId());
		pst.executeUpdate();
		con.close();
		 } catch (Exception e) {
           System.out.println(e);		
}
		 }
		public void excluirCoordenador(coordenador coo) {
			String delete="delete from coordenador where id=?";
			try {
				Connection con = conectar();
				PreparedStatement pst = con.prepareStatement(delete);
				pst.setString(1, coo.getId());
				pst.executeUpdate();
				con.close();
			} catch (Exception e) {
              System.out.println(e);
}
			}
		
	}