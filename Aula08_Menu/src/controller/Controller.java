package controller;

import java.util.List;
import java.util.Scanner;

import dao.Dao;
import entidade.Pato;
import view.View;

public class Controller {
	
	private enum Opcoes {MOSTRAR_PATOS, LE_PATOS, SAIR}
	static final String PATH = "files/patos.csv";
	View view = new View();
	Dao dao = new Dao();
	
	public void init() {
		
		Opcoes opcao = null;
		
		List<Pato> patos;
		do {
			opcao = pegaOpcao();
			switch (opcao) {
			case MOSTRAR_PATOS: 
				patos = dao.loadPatos(PATH);
				view.mostraPatos(patos);
				break;
			case LE_PATOS: 
				Pato pato = view.lePato();
				patos = dao.loadPatos(PATH);
				patos.add(pato);
				dao.savePatos(PATH, patos);
				break;
			case SAIR:
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + opcao);
			}
		} while(opcao != Opcoes.SAIR); 
	}
	
	Opcoes pegaOpcao() {
		System.out.println("Entre com a opção desejada");
		System.out.println("1 - Para mostrar patos");
		System.out.println("2 - para entrar com um novo Pato");
		System.out.println("0 - para sair");
		
		Scanner in = new Scanner(System.in);
		String opcaoPalavra = in.nextLine();
		int opcaoInt = -1;
		try {
			opcaoInt = Integer.parseInt(opcaoPalavra);
			switch (opcaoInt) {
			case 1:
				return Opcoes.MOSTRAR_PATOS;
			case 2:
				return Opcoes.LE_PATOS;
			case 0:
				return Opcoes.SAIR;
			default:
				throw new IllegalArgumentException();
			}
		}catch (NumberFormatException e) {
			System.out.println("Opcao invalida: " + opcaoPalavra);
			System.out.println("Opcao deve ser um numero inteiro");
			System.out.println("Tente Novamente");
			return pegaOpcao();
		}catch (IllegalArgumentException e) {
			System.out.println("Opcao invalida: " + opcaoInt);
			System.out.println("Tente Novamente");
			return pegaOpcao();
		}
	}

}
