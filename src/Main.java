import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	/**
	 * @author candidato1 (ELizeu Sandro da SIlva)**/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String pathVeiculos = "/home/candidato1/Desktop/prova/veiculos.csv";
		List<Veiculo> listaVeiculos;
	
		
		Posto primeiroPosto = new Posto("Posto 1");
		System.out.println(primeiroPosto.getNome());
		primeiroPosto.addBomba(new Bomba(1, 1));
		primeiroPosto.addBomba(new Bomba(2, 2));
		
		try {
			listaVeiculos = openFile(pathVeiculos);
			
			for(int i = 0; i < listaVeiculos.size(); i++) {
				if(listaVeiculos.get(i).getCombustivel() == 1) {
					primeiroPosto.getBomba(1).abastecer(listaVeiculos.get(i).getCapacidade());
					System.out.println("Veículo modelo "+ listaVeiculos.get(i).getModelo()+","
							+ " placa "+ listaVeiculos.get(i).getPlaca()+ "oi abastecido com "+listaVeiculos.get(i).getCapacidade()
							+ " litros de ETANOL.");
				} else {
					primeiroPosto.getBomba(2).abastecer(listaVeiculos.get(i).getCapacidade());
					System.out.println("Veículo modelo "+ listaVeiculos.get(i).getModelo()+","
							+ " placa "+ listaVeiculos.get(i).getPlaca()+ "oi abastecido com "+listaVeiculos.get(i).getCapacidade()
							+ " litros de GASOLINA.");
				}
			}
			 
			for(int i = 1; i <= primeiroPosto.totalBombas(); i++) {
				primeiroPosto.getBomba(i).printContabilidade();
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
	}
	
	/**
	 * Este método lê a lista de veículos e associa qual a melhor escolha de combustível,
	 * como referencia o valor da capacidade do carro de acordo com o modelo.**/
	public static float[] checaViculos(String modelo) {
		BufferedReader modelos;
		String[] data = null;
		String pathDados = "/home/candidato1/Desktop/prova/modelos.csv";
		
		float result[] = new float[2];
		try {
			File arquivo = new File(pathDados);
			if(arquivo.isFile()) {
				modelos = new BufferedReader(new FileReader(pathDados));
				String linha;
				float capacidade = 0;
				float combustivel = 0;
				String header = modelos.readLine();  //Lendo o cabeçalho separadamente
				while((linha = modelos.readLine()) != null) {
					data = linha.split(";");
					int c = modelo.compareTo(data[0]);
					if(c == 0) {
						result[0] = Integer.parseInt(data[3]);
						
						if(Float.parseFloat(data[1].replace(",", ".")) > Float.parseFloat(data[2].replace(",", "."))) {
							combustivel = 1;
							result[1] = combustivel;
						} else {
							combustivel = 2;
							result[1] = combustivel;
						}
						
					}
					 
									
				}
				modelos.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return result;
	}
	
	
	//Método responsável por ler o CSV com as placas e modelos dos carros, retorna List com os dados recebidos.
	public static List<Veiculo> openFile(String path) {
		BufferedReader carros;
		String[] data = null;
		List<Veiculo> listaVeiculos = new ArrayList<Veiculo>();
		try {
			File arquivo = new File(path);
			if(arquivo.isFile()) {
				carros = new BufferedReader(new FileReader(path));
				String linha;
				float temp[];
				int i = 0;
				String header = carros.readLine();  //Lendo o cabeçalho separadamente
				while((linha = carros.readLine()) != null) {
					data = linha.split(";");
					temp = checaViculos(data[0]);
					
					
						listaVeiculos.add(new Veiculo(data[0], data[1], temp[0], temp[1]));
					
				}
				carros.close();
				System.out.println("Existe!");
			}
		
		} catch (Exception e) {
				System.out.println(e);
		}
		
		return listaVeiculos;
	
	}
	

}
