package ExercicioArquivo;

public class Produto {

	private String nome;
	
	private double price;
	private int qtd;
	

	public Produto(String nome, double price, int qtd) {
		this.nome = nome;
		this.price = price;
		this.qtd = qtd;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public int getQtd() {
		return qtd;
	}


	public void setQtd(int qtd) {
		this.qtd = qtd;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}
	
	
	public double sum() {

		return getPrice()*getQtd();
		
	}
	
	
}
