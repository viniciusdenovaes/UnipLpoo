package view;

import java.util.List;
import java.util.Scanner;

import entidade.Pato;

public class View {
	
	public void mostraPatos(List<Pato> patos) {
		System.out.println("Mostrando todos os Patos");
		for(Pato p: patos) {
			System.out.println(p);
		}
	}
	
	public Pato lePato() {
		System.out.println("Entre com os dados do Pato:");
		String nome = leNome();
		int idade = leIdade();
		
		return new Pato(nome, idade);
	}
	
	private String leNome() {
		System.out.println("Entre com o nome do pato");
		Scanner in = new Scanner(System.in);
		String nome = in.nextLine();
		return nome;
	}
	
	private int leIdade() {
		System.out.println("Entre com a idade do pato");
		Scanner in = new Scanner(System.in);
		String idadeTexto = in.nextLine();
		int idade;
		try {
			idade = Integer.parseInt(idadeTexto);
			if(idade<0) {
				throw new IllegalArgumentException();
			}else {
				return idade;
			}
		}catch (Exception e) {
			System.out.println("Idade invalida: " + idadeTexto);
			System.out.println("Tente novamente");
			return leIdade();
		}
	}

}
