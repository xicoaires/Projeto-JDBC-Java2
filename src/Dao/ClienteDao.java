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

public class ClienteDao {

//		CRIAR OBJETO DA TABELA CLIENTE
	public void salvar(Cliente cliente) throws ClassNotFoundException {

		String sql = "insert into CLIENTE (nome, cpf, genero, ano_nasc) values (?,?,?,?)";
		Connection conexao;

		try {
			conexao = ConexaoJDBC.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);

			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getCpf());
			ps.setString(3, cliente.getGenero());
			ps.setString(4, cliente.getAnoNasc());

			ps.execute();
//				conexao.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

//		ATUALIZAR OBJETO DA TABELA
	public void atualizar(Cliente cliente) throws ClassNotFoundException {
		Connection conexao;
		String sql = "UPDATE CLIENTE SET NOME=?, CPF=?, GENERO=?, ANO_NASC=? WHERE ID_CLIENTE=?";

		try {
			conexao = ConexaoJDBC.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);

			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getCpf());
			ps.setString(3, cliente.getGenero());
			ps.setString(4, cliente.getAnoNasc());
			ps.setLong(5, cliente.getId());

			ps.execute();
//				conexao.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//		DELETAR OBJETO DA TABELA
	public void deletar(Long id) throws ClassNotFoundException {
		Connection conexao;
		String sql = "DELETE FROM CLIENTE WHERE ID_CLIENTE=?";

		try {
			conexao = ConexaoJDBC.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);

			ps.setLong(1, id);
			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//	 inner join contato on cliente.id_cliente = contato.id_cliente inner join endereco on cliente.id_cliente = endereco.id_cliente//		LISTAR TODOS OS OBJETOS DA TABELA
	public List<Cliente> listarTodos() throws ClassNotFoundException {
		Connection conexao;
		String sql = "select * from cliente order by ID_CLIENTE";

		List<Cliente> listarClientes = new ArrayList<Cliente>();

		try {
			conexao = ConexaoJDBC.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);

			ResultSet resultado = ps.executeQuery();
			while (resultado.next()) {
				Cliente cliente = new Cliente();

				cliente.setId(resultado.getLong("ID_CLIENTE"));
				cliente.setNome(resultado.getString("NOME"));
				cliente.setCpf(resultado.getString("CPF"));
				cliente.setGenero(resultado.getString("GENERO"));
				cliente.setAnoNasc(resultado.getString("ANO_NASC"));

				listarClientes.add(cliente);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listarClientes;
	}
}
