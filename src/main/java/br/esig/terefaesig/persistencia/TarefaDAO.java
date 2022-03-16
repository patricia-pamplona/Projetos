package br.esig.terefaesig.persistencia;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import br.esig.tarefaesig.dominio.Responsavel;
import br.esig.tarefaesig.dominio.Tarefa;

public class TarefaDAO {

	private Conexao minhaConexao;
	private final String selectGeral = "select * from tarefas t inner join responsavel rsp on rsp.id = t.id_responsavel";
	private final String SelectPorId = "select * from tarefas where Id = ?";
	private final String insert = "INSERT INTO tarefas (Titulo, Descricao, Deadline, Prioridades, Situacao, id_responsavel) values (?, ?, ?, ?, ?, ?)";
	private final String Excluir = "delete from tarefas where id = ?";
	private final String Alterar = "Update tarefas set Titulo = ?, Descricao = ?, Deadline = ?, Prioridades = ?, Situacao = ?, id_responsavel = ? where id = ?";
	private final String Concluir = "Update tarefas set Situacao = true where id = ?";
	
	public TarefaDAO() {
		minhaConexao = new Conexao ("jdbc:postgresql://localhost:5432/Tarefas_ESIG", "postgres", "abc123");	
	}
	
	public void Adicionar (Tarefa tar) {
		try {
			minhaConexao.conectar();
			PreparedStatement instrucao = minhaConexao.getConexao().prepareStatement(insert);
			instrucao.setString(1, tar.getTitulo());
			instrucao.setString(2, tar.getDescricao());
			instrucao.setDate(3, new Date(tar.getDeadline().getTime()));
			instrucao.setString(4, tar.getPrioridade());
			instrucao.setBoolean(5, false);
			instrucao.setInt(6, tar.getId_responsavel());
			instrucao.execute();
			minhaConexao.desconectar();
		}catch (Exception e) {
			System.out.println("Erro TarefaDAO.Adicionar: " + e.getMessage());
		}
	}
	
	public ArrayList<Tarefa> listar () {
		ArrayList<Tarefa> resultado = new ArrayList();
		
		try {
		minhaConexao.conectar();
		Statement instrucao = minhaConexao.getConexao().createStatement();
		ResultSet resultSet = instrucao.executeQuery(selectGeral);
		while(resultSet.next()) {
			Responsavel r = new Responsavel(resultSet.getInt("id_responsavel"), resultSet.getString("nome"));
			
			Tarefa t = new Tarefa (resultSet.getInt("id"), resultSet.getInt("id_responsavel"), resultSet.getString("titulo"), resultSet.getString("descricao"), resultSet.getDate("deadline"), resultSet.getBoolean("situacao"), resultSet.getString("prioridades"));
			t.setResponsavel(r);
			
			resultado.add(t);
		}
		minhaConexao.desconectar();
		}catch (Exception e) {
			System.out.println("Erro TarefaDAO.Listar: " + e.getMessage());
		}
		return resultado;
	}
	
	public void Excluir (Tarefa tar) {
		try {
			minhaConexao.conectar();
			PreparedStatement instrucao = minhaConexao.getConexao().prepareStatement(Excluir);
			instrucao.setInt(1, tar.getId());
			instrucao.execute();
			minhaConexao.desconectar();
		}catch (Exception e) {
			System.out.println("Erro TarefaDAO.Excluir: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void Alterar (Tarefa tar) {
		try {
			minhaConexao.conectar();
			PreparedStatement instrucao = minhaConexao.getConexao().prepareStatement(Alterar);
			instrucao.setString(1, tar.getTitulo());
			instrucao.setString(2, tar.getDescricao());
			instrucao.setDate(3, new Date(tar.getDeadline().getTime()));
			instrucao.setString(4, tar.getPrioridade());
			instrucao.setBoolean(5, false);
			instrucao.setInt(6, tar.getId_responsavel());
			instrucao.setInt(7, tar.getId());
			instrucao.execute();
			minhaConexao.desconectar();
		}catch (Exception e) {
			System.out.println("Erro TarefaDAO.Alterar: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	public void concluir (Tarefa tar) {
		try {
			minhaConexao.conectar();
			PreparedStatement instrucao = minhaConexao.getConexao().prepareStatement(Concluir);
			instrucao.setInt(1, tar.getId());
			instrucao.execute();
			minhaConexao.desconectar();
		}catch (Exception e) {
			System.out.println("Erro TarefaDAO.Concluir: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
}
