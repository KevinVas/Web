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
		alert("Preencha o campo Curso")
		Cadastro.curso.focus()
		return false
	}else if(periodo===""){
		alert("Preencha o campo Periodo")
		Cadastro.periodo.focus()
		return false
}else{
	document.forms["Cadastro"].submit()
}

}