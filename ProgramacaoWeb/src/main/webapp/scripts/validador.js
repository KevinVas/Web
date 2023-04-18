/**
 * 
 */
function validar(){
	let nome=Cadastro.nome.value;
	let curso=Cadastro.curso.value;
	let periodo=Cadastro.periodo.value;
	if(nome===""){
		alert("Preencha o campo Nome")
		Cadastro.nome.focus()
		return false
	}else if(curso===""){
		alert("Preenchao campo Curso")
		Cadastro.curso.focus()
		return false
	}else if(periodo===""){
		alert("Preenchao campo Periodo")
		Cadastro.periodo.focus()
		return false
}else{
	document.forms["Cadastro"].submit()
}

}