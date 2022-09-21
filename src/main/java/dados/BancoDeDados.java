package dados;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import entidades.Cadastro;

public class BancoDeDados {
	private static Integer geradorDeId;
	private static List<Cadastro> bd = new ArrayList<Cadastro>();
	
	public static void insert(Cadastro c) {
		bd.add(c);
	}
	
	public static String select(){
		String retorno = "";
		for (Cadastro cad : bd) {
			retorno += "<tr><td>" + cad.getVariavel1() + "</td><td>" + cad.getVariavel2() + "</td></tr>";  
		}
		return retorno;
	}
}
