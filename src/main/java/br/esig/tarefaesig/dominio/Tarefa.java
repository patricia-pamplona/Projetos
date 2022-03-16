package br.esig.tarefaesig.dominio;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Tarefa {
	
	private int id;
	private int id_responsavel;
	private Responsavel responsavel ;
	private String titulo;
	private String Descricao;
	private Date deadline;
	private boolean situacao;
	private String prioridade;
	
	public Tarefa(int id,int id_responsavel, String titulo, String Descricao, Date deadline, boolean situacao, String prioridade) {
		this.id = id;
		this.id_responsavel = id_responsavel;
		this.titulo= titulo;
		this.Descricao= Descricao;
		this.deadline = deadline;
		this.situacao = situacao;
		this.prioridade = prioridade;
	}
	
	public Tarefa() {
		this.id = 0;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Responsavel getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(Responsavel responsavel) {
		this.responsavel = responsavel;
	}
	
	public int getId_responsavel() {
		return id_responsavel;
	}
	public void setId_responsavel(int id_responsavel) {
		this.id_responsavel = id_responsavel;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescricao() {
		return Descricao;
	}
	public void setDescricao(String descricao) {
		Descricao = descricao;
	}
	public Date getDeadline() {
		return deadline;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public boolean getSituacao() {
		return situacao;
	}
	public String getSituacaoString() {
		if (this.situacao) {
			return "Concluído";
		}else {
			return "Em andamento";
		}
	
	}
	public void setSituacao(boolean situacao) {
		this.situacao = situacao;
	}
	public String getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(String prioridade) {
		this.prioridade = prioridade;
	}
	
	
	
}
