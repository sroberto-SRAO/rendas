package exception;

public class ErroSistema extends Exception {
	public ErroSistema(String msg) {
		super(msg);
	}
	public ErroSistema(String msg, Throwable causa) {
		super(msg, causa);
	}
}
