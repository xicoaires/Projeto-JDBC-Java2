package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import JDBCUtil.ConexaoJDBC;
import Model.Endereco;

public class EnderecoDao {

//		CRIAR OBJETO DA TABELA CLIENTE
	public void salvar(Endereco endereco) throws ClassNotFoundException {

		String sql = "insert into ENDERECO (CEP, RUA, NUMERO, BAIRRO, CIDADE, ESTADO, ID_CLIENTE) values (?,?,?,?,?,?,?)";
		Connection conexao;

		try {
			conexao = ConexaoJDBC.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);

			ps.setString(1, endereco.getCep());
			ps.setString(2, endereco.getRua());
			ps.setString(3, endereco.getNumero());
			ps.setString(4, endereco.getBairro());
			ps.setString(5, endereco.getCidade());
			ps.setString(6, endereco.getEstado());
			ps.setLong(7, endereco.getIdCliente());

			ps.execute();
//				conexao.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

//		ATUALIZAR OBJETO DA TABELA
	public void atualizar(Endereco endereco) throws ClassNotFoundException {
		Connection conexao;
		String sql = "UPDATE ENDERECO SET CEP=?, RUA=?, NUMERO=?, BAIRRO=?, CIDADE=?, ESTADO=? WHERE ID_CLIENTE=?";

		try {
			conexao = ConexaoJDBC.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);

			ps.setString(1, endereco.getCep());
			ps.setString(2, endereco.getRua());
			ps.setString(3, endereco.getNumero());
			ps.setString(4, endereco.getBairro());
			ps.setString(5, endereco.getCidade());
			ps.setString(6, endereco.getEstado());
			ps.setLong(7, endereco.getIdCliente());

			ps.execute();
//				conexao.commit();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

//		LISTAR TODOS OS OBJETOS DA TABELA
	public List<Endereco> listarTodos() throws ClassNotFoundException {
		Connection conexao;
		String sql = "select * from cliente inner join contato on cliente.id_cliente = contato.id_cliente inner join endereco on cliente.id_cliente = endereco.id_cliente";

		List<Endereco> listarEnderecos = new ArrayList<Endereco>();

		try {
			conexao = ConexaoJDBC.getConexao();
			PreparedStatement ps = conexao.prepareStatement(sql);

			ResultSet resultado = ps.executeQuery();
			while (resultado.next()) {
				Endereco endereco = new Endereco();

				endereco.setIdCliente(resultado.getLong("ID_CLIENTE"));
				endereco.setCep(resultado.getString("CEP"));
				endereco.setRua(resultado.getString("RUA"));
				endereco.setNumero(resultado.getString("NUMERO"));
				endereco.setBairro(resultado.getString("BAIRRO"));
				endereco.setCidade(resultado.getString("CIDADE"));
				endereco.setEstado(resultado.getString("ESTADO"));

				listarEnderecos.add(endereco);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listarEnderecos;
	}
}