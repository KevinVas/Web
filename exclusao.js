/**
 * 
 * 
 */
function excluir(nome){
	let resposta =confirm("Esse Coordenador será excluido")
if(resposta === true){
	window.location.href="delete?nome=" + nome
}

}
