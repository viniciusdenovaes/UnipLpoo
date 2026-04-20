package dao;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import entidade.Pato;

public class Dao {

	public List<Pato> loadPatos(String path){
		List<Pato> patos = new ArrayList<Pato>();
		try (InputStream is = new FileInputStream(path);
				InputStreamReader isr = new InputStreamReader(is, StandardCharsets.UTF_8);
				BufferedReader br = new BufferedReader(isr);
				){
			String linha;
			while((linha = br.readLine()) != null){
				String[] palavras = linha.split(",");
				String nome = palavras[0];
				int idade = Integer.parseInt(palavras[1]);
				patos.add(new Pato(nome, idade));
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		return patos;
	}

	public void savePatos(String path, List<Pato> patos) {
		try(OutputStream os = new FileOutputStream(path/*, true*/);
				OutputStreamWriter osw = new OutputStreamWriter(os, StandardCharsets.UTF_8);
				PrintWriter pw = new PrintWriter(osw, true);
				){
			for(Pato p: patos){
				pw.println(p.getNome()+","+p.getIdade());
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
