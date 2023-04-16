package cadastro.web.bean;

public class coordenador {
	
		public coordenador() {
		super();
		
	}
		public coordenador(String nome, String curso, String periodo) {
		super();
		this.nome = nome;
		this.curso = curso;
		this.periodo = periodo;
	}
		private String nome;
		private String curso;
		private String periodo;
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getCurso() {
			return curso;
		}
		public void setCurso(String curso) {
			this.curso = curso;
		}
		public String getPeriodo() {
			return periodo;
		}
		public void setPeriodo(String periodo) {
			this.periodo = periodo;
		}
		
	}

