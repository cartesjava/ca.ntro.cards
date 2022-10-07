package ca.ntro.cards.common.models.enums;

import ca.ntro.cards.common.models.world2d.CommonDrawingOptions;
import ca.ntro.core.initialization.Ntro;

public enum Sorte {
	
	COEUR("♥", "#e6194B"), CARREAU("♦", "#4363d8"), TREFLE("♣", "#3cb44b"), PIQUE("♠", "#000000");

	private String symbol;
	private String color;
	
	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	Sorte(String symbol, String color){
		setSymbol(symbol);
		setColor(color);
	}

	public String color(CommonDrawingOptions options) {
		String color = this.color;

		if(this == CARREAU
				&& !options.useFourCardColors()) {
			
			color = COEUR.color;

		}else if(this == TREFLE
				&& !options.useFourCardColors()) {
			
			color = PIQUE.color;

		}

		return color;
	}

	public static Sorte random() {
		return Ntro.random().choice(Sorte.values());
	}

}
