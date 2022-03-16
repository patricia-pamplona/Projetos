package br.esig.tarefaesig.controllers;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.esig.tarefaesig.dominio.Responsavel;
import br.esig.tarefaesig.dominio.Tarefa;
import br.esig.terefaesig.persistencia.ResponsavelDAO;
import br.esig.terefaesig.persistencia.TarefaDAO;
@ManagedBean
@SessionScoped


public class TarefasMBean {
	
	//atributo
	private Tarefa tarefa;
	private TarefaDAO tarefaDAO;
	private ResponsavelDAO responsavelDAO;
	
	//construtor
	public TarefasMBean() {
		tarefa = new Tarefa();
		tarefaDAO = new TarefaDAO();
		responsavelDAO = new ResponsavelDAO();
	}
	
		
	public Tarefa getTarefa() {
		return tarefa;
	}
	
	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}
	
	//metodo para inserir tarefa
	//@return
	public String cadastrar() {
		if(tarefa.getId()==0) {
			tarefaDAO.Adicionar(tarefa);
			
		}else {
			tarefaDAO.Alterar(tarefa);
		}
		return "/sucess.jsf";
	}
	
	public String exibirFormulario() {
		return "/form.jsf";
	}
	
	public String exibirLista() {
		return "/index.jsf";
	}
	
	public List<Tarefa> getListaTarefas(){
		return tarefaDAO.listar();
	}
	public List<Responsavel> getListaResponsavel(){
		return responsavelDAO.listar();
	}
	public String excluir(Tarefa tf) {
		tarefaDAO.Excluir(tf);
		return "/index.jsf";
	}
	public String alterar(Tarefa tf) {
		this.tarefa = tf;
		return "/form.jsf";
	}
	public String concluir(Tarefa tf) {
		tarefaDAO.concluir(tf);
		return "/index.jsf";
	}
		
}
