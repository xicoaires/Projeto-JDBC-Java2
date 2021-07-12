package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import JDBCUtil.ConexaoJDBC;
import Model.Cliente;
import Model.Contato;
import Model.Endereco;

public class ContatoDao {

//		CRIAR OBJETO DA TABELA CLIENTE
	public void salvar(Contato contato) throws ClassNotFoundException {

		String sql = "insert into CONTATO (EMAIL, DDD, TELEFONE, ID_CLIENTE) values (?,?,?,?)";
		Connection conexao;

		try {
			conexao = ConexaoJDBC.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);

			ps.setString(1, contato.getEmail());
			ps.setString(2, contato.getDdd());
			ps.setString(3, contato.getTelefone());
			ps.setLong(4, contato.getIdCliente());

			ps.execute();
//				conexao.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

//		ATUALIZAR OBJETO DA TABELA
	public void atualizar(Contato contato) throws ClassNotFoundException {
		Connection conexao;
		String sql = "UPDATE CONTATO SET EMAIL=?, DDD=?, TELEFONE=? WHERE ID_CLIENTE=?";

		try {
			conexao = ConexaoJDBC.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);

			ps.setString(1, contato.getEmail());
			ps.setString(2, contato.getDdd());
			ps.setString(3, contato.getTelefone());
			ps.setLong(4, contato.getIdCliente());

			ps.execute();
//				conexao.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

////		DELETAR OBJETO DA TABELA
//		public void deletar(Long id) throws ClassNotFoundException {
//			Connection conexao;
//			String sql = "DELETE FROM CONTATO WHERE ID_CONTATO=?";
//			
//			try {
//				conexao = ConexaoJDBC.getConexao();
//				PreparedStatement ps = conexao.prepareStatement(sql);
//				
//				ps.setLong(1, id);
//				ps.execute();
//				
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}

//		LISTAR TODOS OS OBJETOS DA TABELA
	public List<Contato> listarTodos() throws ClassNotFoundException {
		Connection conexao;
		String sql = "select * from cliente inner join contato on cliente.id_cliente = contato.id_cliente inner join endereco on cliente.id_cliente = endereco.id_cliente";

		List<Contato> listarContatos = new ArrayList<Contato>();

		try {
			conexao = ConexaoJDBC.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);

			ResultSet resultado = ps.executeQuery();
			while (resultado.next()) {
				Contato contato = new Contato();

				contato.setIdCliente(resultado.getLong("ID_CLIENTE"));
				contato.setEmail(resultado.getString("EMAIL"));
				contato.setDdd(resultado.getString("DDD"));
				contato.setTelefone(resultado.getString("TELEFONE"));

				listarContatos.add(contato);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listarContatos;
	}
}