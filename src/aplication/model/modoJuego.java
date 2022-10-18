package aplication.model;

public enum modoJuego {

	MODOCLASICO(0), MODODUELO(1);
	
	private int modoJuego;
	
	private modoJuego(int modoJuego) {
		this.modoJuego = modoJuego;
	}

	

	public int getModoJuego() {
		return modoJuego;
	}

	
	
}
