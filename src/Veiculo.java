
public class Veiculo {
	
	private String modelo;
	private String placa;
	private float capacidade;
	private int combustivel;
	
	/* Exemplo:
	 * Modelo: GOL-99
	 * Placa: UTD-0000
	 * Capacidade: 50 (correspondente a litros)
	 * Combustível: 1 - (Etanol), ou 2 (Gasolina)*/
	
	public Veiculo(String modelo, String placa, float capacidade, float combustivel) {
		this.setModelo(modelo);
		this.setPlaca(placa);
		this.setCapacidade(capacidade);
		this.setCombustivel((int)combustivel);
	
	
	}


	public int getCombustivel() {
		return combustivel;
	}


	public void setCombustivel(int combustivel) {
		this.combustivel = combustivel;
	}


	public float getCapacidade() {
		return capacidade;
	}


	public void setCapacidade(float capacidade) {
		this.capacidade = capacidade;
	}


	public String getPlaca() {
		return placa;
	}


	public void setPlaca(String placa) {
		this.placa = placa;
	}


	public String getModelo() {
		return modelo;
	}


	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

}
