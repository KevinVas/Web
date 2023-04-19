package cadastro.web.bean;

public class coordenador {
    	private String id;
	    private String nome;
		private String curso;
		private String periodo;
		
		public coordenador() {
		super();
		
	}

		public coordenador(String id, String nome, String curso, String periodo) {
			super();
			this.id = id;
			this.nome = nome;
			this.curso = curso;
			this.periodo = periodo;
		}

		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getCurso() {
			return curso;
		}
		public void setCurso(String cursos) {
			this.curso = cursos;
		}
		public String getPeriodo() {
			return periodo;
		}
		public void setPeriodo(String periodo) {
			this.periodo = periodo;
		}
		
	}

