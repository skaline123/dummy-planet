/**
 * 
 */
package mx.com.danito.api.sample.planet.util;

/**
 * @author danito
 *
 */
public enum EnumOrderDataPlanet {
	
	ORDER_FIRST_NAME("ORDER_FIRST_NAME","FIRST_NAME"),
	ORDER_LAST_NAME("ORDER_LAST_NAME","LAST_NAME"),
	ORDER_START_DATE("ORDER_START_DATE","START_DATE")
	;
	
	
	private String id; 
	private String titulo;
	
	EnumOrderDataPlanet(String id, String titulo){
		this.id = id;	
		this.titulo = titulo;
	}

	/**
	 * @return the id
	 */
	public final String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public final void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the titulo
	 */
	public final String getTitulo() {
		return titulo;
	}

	/**
	 * @param titulo the titulo to set
	 */
	public final void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
