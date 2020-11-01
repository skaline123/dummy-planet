/**
 * 
 */
package mx.com.danito.api.sample.planet.exception;

/**
 * @author danito
 *
 */
public class BlogicException extends Exception {

	/**
	 * The default {@code serialVersionUID} for interoperability.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Crea una nueva instancia de {@code BlogicException}.
	 * 
	 * @param message
	 *        mensaje
	 * @param cause
	 *        la causa
	 */
	public BlogicException(final String message, final Throwable cause) {
		super(message, cause);
	}

	/**
	 * Crea una nueva instancia de {@code BlogicException}.
	 * 
	 * @param message
	 *        mensaje
	 */
	public BlogicException(final String message) {
		super(message);
	}

	public BlogicException(String message, String string) {
		super(string);
	}

}
