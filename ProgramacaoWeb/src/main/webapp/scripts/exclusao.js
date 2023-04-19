/**
 * 
 * 
 */
function excluir(id){
	let resposta =confirm("Esse Coordenador será excluido")
if(resposta === true){
	window.location.href="delete?id=" + id
}

}
