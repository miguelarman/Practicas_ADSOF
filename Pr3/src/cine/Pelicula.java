package cine;



/**
 * Esta clase Pelicula almacena todos los datos necesarios de una pelicula. Es una clase bastante simple, puesto que no
 * hace llamadas a otras clases, exceptuando la enumeracion de Genero
 * @author Miguel Arconada (miguel.arconada@estudiante.uam.es) Alberto Gonzalez (alberto.gonzalezk@estudiante.uam.es)
 *
 */
public class Pelicula {
	
	/**
	 * Titulo de la pelicula
	 */
	private String titulo;
	/**
	 * Nombre del director de la pelicula
	 */
	private String director;
	/**
	 * Anno de la pelicula
	 */
	private int anno;
	/**
	 * Sinopsis de la pelicula
	 */
	private String sinopsis;
	/**
	 * Genero de la pelicula. Es de un tipo de enumeracion
	 */
	private Genero genero;
	/**
	 * Duracion en minutos de la pelicula
	 */
	private int duracion;
	
	
	
	/**
	 * Constructor de la clase Pelicula
	 * @param titulo Titulo deseado de la pelicula
	 * @param director Nombre del director de la pelicula
	 * @param anno Anno de grabacion de la pelicula
	 * @param sinopsis Sinopsis de la pelicula
	 * @param genero Genero de la pelicula
	 * @param duracion Duracion en minutos de la pelicula
	 */
	public Pelicula(String titulo, String director, int anno, String sinopsis, Genero genero, int duracion) {
		this.titulo = titulo;
		this.director = director;
		this.anno = anno;
		this.sinopsis = sinopsis;
		this.genero = genero;
		this.duracion = duracion;
	}

	// Getters
	
	/**
	 * Metodo getter del titulo
	 * @return Titulo de la pelicula
	 */
	public String getTitulo() {
		return titulo;
	}
	
	/**
	 * Metodo getter del director
	 * @return Director de la pelicula
	 */
	public String getDirector() {
		return director;
	}
	
	/**
	 * Metodo getter del anno
	 * @return Anno de la pelicula
	 */
	public int getAnno() {
		return anno;
	}
	
	/**
	 * Metodo getter de la sinopsis
	 * @return Sinopsis de la pelicula
	 */
	public String getSinopsis() {
		return sinopsis;
	}
	
	/**
	 * Metodo getter del genero
	 * @return Genero de la pelicula
	 */
	public Genero getGenero() {
		return genero;
	}
	
	/**
	 * Metodo getter de la duracion
	 * @return Duracion de la pelicula
	 */
	public int getDuracion() {
		return duracion;
	}

	
	
	// Setters
	
	/**
	 * Metodo setter del titulo
	 * @param titulo Titulo nuevo de la pelicula
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	/**
	 * Metodo setter del director
	 * @param director Director nuevo de la pelicula
	 */
	public void setDirector(String director) {
		this.director = director;
	}
	
	/**
	 * Metodo setter del anno
	 * @param anno Anno nuevo de la pelicula
	 */
	public void setAnno(int anno) {
		this.anno = anno;
	}
	
	/**
	 * Metodo setter de la sinopsis
	 * @param sinopsis Sinopsis nueva de la pelicula
	 */
	public void setSinopsis(String sinopsis) {
		this.sinopsis = sinopsis;
	}
	
	/**
	 * Metodo setter del genero
	 * @param genero Genero nuevo de la pelicula
	 */
	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	/**
	 * Metodo setter de la duracion
	 * @param duracion Duracion nueva de la pelicula
	 */
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	
	
	// ToString
	
	@Override
	/**
	 * Metodo toString de la clase Pelicula. Necesario para imprimir por pantalla una pelicula en formato legible
	 * @return Cadena imprimible con los datos de la pelicula
	 */
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
