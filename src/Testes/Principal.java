package Testes;

import java.sql.SQLException;
import java.util.Scanner;

import Dao.ClienteDao;
import Dao.ContatoDao;
import Dao.EnderecoDao;
import Model.Cliente;
import Model.Contato;
import Model.Endereco;

public class Principal {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Scanner ler = new Scanner(System.in);
		int opcao = 10;
		String dado;
		Long dadoLong;

		System.out.println("Bem vindo ao Projeto de Banco de Dados de Java 2 - JDBC!\n");
		System.out.println("CADASTRO DE CLIENTE\n");
		
		do {

			System.out.println(
					"Digite a opção desejada:" + "\n1 - Cadastrar cliente" + "\n2 - Cadastrar contato do cliente"
							+ "\n3 - Cadastrar endereço do cliente" + "\n4 - Atualizar cliente" + "\n5 - Apagar cliente"
							+ "\n6 - Localizar cliente" + "\n7 - Listar todos os clientes" + "\n0 - Sair\n");
			System.out.print("Opção: ");
			opcao = ler.nextInt();

			switch (opcao) {
			case 1:
				System.out.println("\nCADASTRAR CLIENTE\n");
				Cliente cliente = new Cliente();

				System.out.print("Nome: ");
				dado = ler.nextLine();
				dado = ler.nextLine();
				cliente.setNome(dado);

				System.out.print("CPF: ");
				dado = ler.nextLine();
				cliente.setCpf(dado);

				System.out.print("Gênero: ");
				dado = ler.nextLine();
				cliente.setGenero(dado);

				System.out.print("Ano de nascimento: ");
				dado = ler.nextLine();
				cliente.setAnoNasc(dado);

				ClienteDao clienteDao = new ClienteDao();
				clienteDao.salvar(cliente);
				
				System.out.println("\nCliente cadastrado com sucesso!\n");
				System.out.println("Pressione alguma tecla para continuar...\n");
				ler.nextLine();
				break;

			case 2:
				System.out.println("\nCADASTRAR CONTATO\n");
				Contato contato = new Contato();

				System.out.print("ID do cliente: ");
				dadoLong = ler.nextLong();
				contato.setIdCliente(dadoLong);
				
				System.out.print("E-mail: ");
				dado = ler.nextLine();
				dado = ler.nextLine();
				contato.setEmail(dado);

				System.out.print("DDD: ");
				dado = ler.nextLine();
				contato.setDdd(dado);

				System.out.print("Telefone: ");
				dado = ler.nextLine();
				contato.setTelefone(dado);

				ContatoDao contatoDao = new ContatoDao();
				contatoDao.salvar(contato);

				System.out.println("\nContato cadastrado com sucesso!\n");
				System.out.println("Pressione alguma tecla para continuar...\n");
				ler.nextLine();
				break;

			case 3:
				System.out.println("\nCADASTRAR ENDEREÇO\n");
				Endereco endereco = new Endereco();
				
				System.out.print("ID do cliente: ");
				dadoLong = ler.nextLong();
				endereco.setIdCliente(dadoLong);
				
				System.out.print("CEP: ");
				dado = ler.nextLine();
				dado = ler.nextLine();
				endereco.setCep(dado);

				System.out.print("Rua: ");
				dado = ler.nextLine();
				endereco.setRua(dado);

				System.out.print("Número: ");
				dado = ler.nextLine();
				endereco.setNumero(dado);

				System.out.print("Bairro: ");
				dado = ler.nextLine();
				endereco.setBairro(dado);

				System.out.print("Cidade: ");
				dado = ler.nextLine();
				endereco.setCidade(dado);

				System.out.print("Estado (UF): ");
				dado = ler.nextLine();
				endereco.setEstado(dado);

				EnderecoDao enderecoDao = new EnderecoDao();
				enderecoDao.salvar(endereco);

				System.out.println("\nEndereço cadastrado com sucesso!\n");
				System.out.println("Pressione alguma tecla para continuar...\n");
				ler.nextLine();
				break;

			case 4:
				System.out.println("\nATUALIZAR CLIENTE");

				Cliente cliente2 = new Cliente();
				Contato contato2 = new Contato();
				Endereco endereco2 = new Endereco();

				System.out.print("ID do cliente: ");
				dadoLong = ler.nextLong();
				cliente2.setId(dadoLong);
				contato2.setIdCliente(dadoLong);
				endereco2.setIdCliente(dadoLong);

				System.out.print("Nome: ");
				dado = ler.nextLine();
				dado = ler.nextLine();
				cliente2.setNome(dado);

				System.out.print("CPF: ");
				dado = ler.nextLine();
				cliente2.setCpf(dado);

				System.out.print("Gênero: ");
				dado = ler.nextLine();
				cliente2.setGenero(dado);

				System.out.print("Ano de nascimento: ");
				dado = ler.nextLine();
				cliente2.setAnoNasc(dado);

				ClienteDao clienteDao2 = new ClienteDao();
				clienteDao2.atualizar(cliente2);

				System.out.print("E-mail: ");
				dado = ler.nextLine();
				contato2.setEmail(dado);

				System.out.print("DDD: ");
				dado = ler.nextLine();
				contato2.setDdd(dado);

				System.out.print("Telefone: ");
				dado = ler.nextLine();
				contato2.setTelefone(dado);

				ContatoDao contatoDao2 = new ContatoDao();
				contatoDao2.atualizar(contato2);

				System.out.print("CEP: ");
				dado = ler.nextLine();
				endereco2.setCep(dado);

				System.out.print("Rua: ");
				dado = ler.nextLine();
				endereco2.setRua(dado);

				System.out.print("Número: ");
				dado = ler.nextLine();
				endereco2.setNumero(dado);

				System.out.print("Bairro: ");
				dado = ler.nextLine();
				endereco2.setBairro(dado);

				System.out.print("Cidade: ");
				dado = ler.nextLine();
				endereco2.setCidade(dado);

				System.out.print("Estado (UF): ");
				dado = ler.nextLine();
				endereco2.setEstado(dado);

				EnderecoDao enderecoDao2 = new EnderecoDao();
				enderecoDao2.atualizar(endereco2);

				System.out.println("\nCliente atualizado com sucesso!");
				System.out.println("Pressione alguma tecla para continuar...");
				ler.nextLine();
				break;
				
			case 5:
				System.out.println("APAGAR UM CLIENTE");
				Cliente cliente5 = new Cliente();
				System.out.print("ID do cliente: ");
				dadoLong = ler.nextLong();
				cliente5.setId(dadoLong);
				
				ClienteDao clienteDao5 = new ClienteDao();
				clienteDao5.deletar(cliente5.getId());
				
				System.out.println("Cliente apagado com sucesso!");
				System.out.println("Pressione alguma tecla para continuar...");
				ler.nextLine();
				ler.nextLine();
				break;
				
			case 6:
				System.out.println("LOCALIZAR CLIENTE POR ID");
				System.out.print("Digite o ID do cliente: ");
				System.out.println("Pressione alguma tecla para continuar...");
				ler.nextLine();
				ler.nextLine();
				break;
				
			case 7:
				System.out.println("LISTAR TODOS OS CLIENTES");
				ClienteDao clienteDao7 = new ClienteDao();
				System.out.println(clienteDao7.listarTodos());
				System.out.println("Pressione alguma tecla para continuar...");
				ler.nextLine();
				ler.nextLine();
				break;
				
			case 0:
				System.out.println("Até a próxima!!");
				break;
				
			default:
				System.err.println("VOCÊ DIGITOU UMA OPÇÃO INVÁLIDA!");
				break;
			}

		} while (opcao != 0);

	}
}
