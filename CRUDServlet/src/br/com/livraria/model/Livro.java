package br.com.livraria.model;

public class Livro {
	
	private Integer id;
	private String titulo;
	private String autor;
	private Float preco;
	
	public Livro(){
		
	}
	
	public Livro(Integer id){
		this.id = id;
	}
	
	public Livro(Integer id, String titulo, String autor, Float preco){
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.preco = preco;
	}
	
	public Livro(String titulo, String autor, Float preco){
		this.titulo = titulo;
		this.autor = autor;
		this.preco = preco;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		this.preco = preco;
	}
	
}
