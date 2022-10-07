package ca.ntro.cards.models.world2d;

import ca.ntro.app.frontend.views.controls.canvas.World2dGraphicsContext;
import ca.ntro.app.views.controls.canvas.World2dMouseEventFx;
import ca.ntro.cards.common.models.enums.Sorte;
import ca.ntro.cards.common.models.values.cards.AbstractCard;
import ca.ntro.cards.common.models.values.cards.Carte;
import ca.ntro.cards.common.models.values.cards.NullCard;
import javafx.scene.input.MouseEvent;

@SuppressWarnings("rawtypes")
public abstract class   ProcedureCard2d<WORLD2D  extends ProcedureWorld2d<WORLD2D, OPTIONS>,
                                        OPTIONS  extends ProcedureDrawingOptions>

                extends ProcedureObject2d<WORLD2D, OPTIONS> {
	
	private boolean faceUp = true;
	
	private String id;
	private AbstractCard card;
	

	public AbstractCard getCard() {
		return card;
	}

	public void setCard(AbstractCard card) {
		this.card = card;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ProcedureCard2d() {
		NullCard card = new NullCard();
		setCard(card);
		setId(card.id());
	}

	public ProcedureCard2d(int rank, Sorte suit) {
		Carte card = new Carte(rank,suit);
		setCard(card);
		setId(card.id());
	}

	public ProcedureCard2d(String id, AbstractCard card) {
		setCard(card);
		setId(id);
	}

	protected abstract double initialWidth();
	protected abstract double initialHeight();

	@Override
	public String id() {
		return getId();
	}

	@Override
	public void initialize() {
		setWidth(initialWidth());
		setHeight(initialHeight());
	}


	protected void flipCard() {
		this.faceUp = !faceUp;

	}

	@SuppressWarnings({ "unchecked" })
	@Override
	public void draw(World2dGraphicsContext gc, OPTIONS options) {
		if(faceUp) {

			card.drawFaceUp(gc, 
					        getTopLeftX(), 
					        getTopLeftY(),
					        getWidth(),
					        getHeight(),
					        levelOfDetails(gc),
					        options);
			
		}else {

			card.drawFaceDown(gc, 
					          getTopLeftX(), 
					          getTopLeftY(),
					          getWidth(),
					          getHeight(),
					          levelOfDetails(gc),
					          options);
			
		}
	}
	
	@SuppressWarnings("rawtypes")
	private int levelOfDetails(World2dGraphicsContext gc) {
		int levelOfDetails = 10;

		if(gc.widthOnScreen(getWidth()) <= 10
				|| gc.heightOnScreen(getHeight()) <= 30) {
			
			levelOfDetails = 4;

		}

		return levelOfDetails;
	}

	public boolean isNullCard() {
		return card.isNullCard();
	}

	public void setFaceUp(boolean faceUp) {
		this.faceUp = faceUp;
	}

	@Override
	protected boolean onMouseEvent(World2dMouseEventFx mouseEvent) {
		if(!super.onMouseEvent(mouseEvent)) {

			MouseEvent evtFx = mouseEvent.rawMouseEvent();

			if(evtFx.getEventType().equals(MouseEvent.MOUSE_PRESSED) 
					&& evtFx.isSecondaryButtonDown()) {
				
				flipCard();
				getWorld().buildAndSendManualModel();
				return true;
			}
		}
		
		return false;
	}

	public boolean isFaceUp() {
		return faceUp;
	}

}
