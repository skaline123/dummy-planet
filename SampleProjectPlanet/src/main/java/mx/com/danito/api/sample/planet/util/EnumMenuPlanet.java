/**
 * 
 */
package mx.com.danito.api.sample.planet.util;

/**
 * @author danito
 *
 */
public enum EnumMenuPlanet {

	MENU_PROCESS_ALL("MENU_PROCESS_ALL","ALL"),
	MENU_PROCESS_FILE_CSV("MENU_PROCESS_FILE_CSV","PROCESS_FILE_CSV"),
	MENU_PROCESS_FILE_ASCII("MENU_PROCESS_FILE_ASCII","PROCESS_FILE_ASCII")
	;
	
	
	private String id; 
	private String titulo;
	
	EnumMenuPlanet(String id, String titulo){
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
