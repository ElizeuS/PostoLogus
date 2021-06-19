import java.util.HashMap;


public class Posto {
	private String nome;
	private HashMap<Integer,  Bomba> bombas;
	
	public Posto(String nome) {
		this.nome = nome;
		this.bombas = new HashMap<Integer, Bomba>();
	}
	
	public void addBomba(Bomba b) {
		if(this.bombas.containsKey(b.getId())) {
			//TO-DO
		} else {
			this.bombas.put(b.getId(), b);
		}
	
	}
	
	public int totalBombas() {
		return this.bombas.size();
	}
	
	public void removeBomba(Bomba b) {
		this.bombas.remove(b.getId());
	}
	
	public Bomba getBomba(int id) {
		return this.bombas.get(id);
	}
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
