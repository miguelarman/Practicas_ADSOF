package cine;



/**
 * 
 * @author Miguel Arconada (miguel.arconada@estudiante.uam.es) Alberto Gonzalez (alberto.gonzalezk@estudiante.uam.es)
 *
 */
public class Pelicula {
	private String titulo;
	private String director;
	private int anno;
	private String sinopsis;
	private Genero genero;
	private int duracion;

	public Pelicula(String titulo, String director, int anno, String sinopsis, Genero genero, int duracion) {
		this.titulo = titulo;
		this.director = director;
		this.anno = anno;
		this.sinopsis = sinopsis;
		this.genero = genero;
		this.duracion = duracion;
	}

	// Getters
	public String getTitulo() {
		return titulo;
	}

	public String getDirector() {
		return director;
	}

	public int getAnno() {
		return anno;
	}

	public String getSinopsis() {
		return sinopsis;
	}

	public Genero getGenero() {
		return genero;
	}
	
	public int getDuracion() {
		return duracion;
	}

	
	
	// Setters
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	
	
	// ToString
	public String toString() {
		String cadena = "";
		
		cadena += "Titulo: " + titulo;
		cadena += "\nDirector: " + director;
		cadena += "\nAnno: " + anno;
		cadena += "\nSinopsis: " + sinopsis;
		cadena += "\nGenero: " + genero;
		
		
		
		return cadena;
	}
}
