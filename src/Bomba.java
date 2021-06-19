
public class Bomba {
	private int tipoCombustivel;
	private float consumo;
	private int id;
	
	/* Exemplo:
	 * Combustível: 1 - (Etanol), ou 2 (Gasolina)
	 * Consumo: 1000 (corresponde ao total já abastecido pela bomba em litros) 
	 * Id: 1 (ordem numérica)*/
	
	public Bomba(int tipo, int id) {
		this.setId(id);
		if(tipo == 1 || tipo == 2) {
			this.setTipoCombustivel(tipo);
		}
		this.setConsumo(0);
	}
	
	public void printContabilidade() {
		String t = this.vTipo();
		System.out.println("Total abastecido na bomba" + this.getId() + "("+t+"): "+ this.getConsumo() +" litros");
	}
	
	public String vTipo() {
		String tipo = "";
		if(this.tipoCombustivel == 1) {
			tipo = "ETANOL";
		} else if(this.tipoCombustivel == 2) {
			tipo ="GASOLINA";
		}
		return tipo;
	}
	
	public void abastecer(float total) {
		this.consumo += total;
	}

	public float getConsumo() {
		return consumo;
	}

	public void setConsumo(float consumo) {
		this.consumo = consumo;
	}

	public int getTipoCombustivel() {
		return tipoCombustivel;
	}

	public void setTipoCombustivel(int tipoCombustivel) {
		this.tipoCombustivel = tipoCombustivel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
