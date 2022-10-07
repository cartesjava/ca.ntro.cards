package ca.ntro.cards.shift2.models.values;

import ca.ntro.app.frontend.views.controls.canvas.World2dGraphicsContext;
import ca.ntro.cards.common.models.enums.Sorte;
import ca.ntro.cards.common.models.values.cards.Carte;
import ca.ntro.cards.shift2.models.world2d.Shift2ProcedureDrawingOptions;
import javafx.scene.canvas.GraphicsContext;

public abstract class CarteIncomplete extends Carte<Shift2ProcedureDrawingOptions> {

	private static final long serialVersionUID = -7658957428600519658L;

	public CarteIncomplete() {
		super();
	}

	public CarteIncomplete(int numero, Sorte sorte) {
		super(numero,sorte);
	}

	@SuppressWarnings("rawtypes")
	public void drawFaceUp(World2dGraphicsContext gc, 
			               double topLeftX, 
			               double topLeftY, 
			               double width, 
			               double height, 
			               int levelOfDetails, 
			               Shift2ProcedureDrawingOptions options) {

		gc.translate(topLeftX, topLeftY);
		
		GraphicsContext gcFx = (GraphicsContext) gc.getRawGraphicsContext();

		dessinerCarte(gcFx);
	}
	
	protected abstract void dessinerCarte(GraphicsContext gc);
	

}
