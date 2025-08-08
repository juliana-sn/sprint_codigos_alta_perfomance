package aplicacao;

import listas.ListaCrescenteColaborador;
import modelos.Colaborador;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Onboarding {
	public static Scanner le = new Scanner(System.in);
	public static ListaCrescenteColaborador listaColaboradores = new ListaCrescenteColaborador();

	public static void main(String[] args) {

		geraLista(listaColaboradores);

		int opcao = 4;
		do {
			System.out.println("0 - Encerrar atendimento");
			System.out.println("1 - Obter colaboradores com piores notas presentes na lista");
			System.out.println("2 - Atualizar nota de um colaborador");
			System.out.println("3 - Inserir novo colaborador");
			System.out.println("Opcao: ");
			opcao = le.nextInt();
			switch (opcao) {
				case 0:
					break;
				case 1:
					obterPioresNotas();
					break;
				case 2:
					atualizarNota();
					break;
				case 3:
					inserirColaborador();
				default:
					System.out.println("Opcao Invalida");
			}

		} while (opcao != 0);

		le.close();

	}

	private static void inserirColaborador() {
		System.out.print("Insira o ID: ");
		int id = le.nextInt();

		System.out.print("Insira o nome: ");
		String nome = le.next();

		System.out.print("Insira o setor: ");
		String setor = le.next();

		System.out.print("Insira o buddy: ");
		String buddy = le.next();

		Colaborador colaborador = new Colaborador(id, nome, setor, buddy);
		listaColaboradores.add(colaborador);
	}

	private static void atualizarNota() {
		System.out.print("Digite o ID do colaborador: ");
		int id = le.nextInt();

		Colaborador colaborador = listaColaboradores.remove(id);

		System.out.print("Digite a nova nota: ");
		int nota = le.nextInt();

		colaborador.setNota(nota);
		listaColaboradores.add(colaborador);
	}

	private static void obterPioresNotas() {
        System.out.print("Digite a quantidade de colaboradores: ");
        int entrada = le.nextInt();
        listaColaboradores.show(entrada);
	}

	public static void geraLista(ListaCrescenteColaborador listaColaboradores) {

		String caminhoDoArquivo = "src/arquivos/Colaboradores.txt";
		
		try {
			// Criar um objeto File com o caminho do arquivo
			File arquivo = new File(caminhoDoArquivo);


			Scanner leArq = new Scanner(arquivo);

			while (leArq.hasNextLine()) {
				String linha = leArq.nextLine();
				String[] partes = linha.split(";");
				int id = Integer.parseInt(partes[0]);
				String nome = partes[1];
				String setor = partes[2];
				String buddy = partes[3];
				int nota = Integer.parseInt(partes[4]);
				Colaborador colaborador = new Colaborador(id, nome, setor, buddy, nota);
				listaColaboradores.add(colaborador);
			}
			leArq.close();
		} catch (FileNotFoundException e) {

			System.out.println("Arquivo n�o encontrado: " + e.getMessage());
		}
	}
}
