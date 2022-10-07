package ca.ntro.cards.shift2.frontend.views;

import java.net.URL;
import java.util.ResourceBundle;

import ca.ntro.app.views.controls.canvas.World2dCanvasFx;
import ca.ntro.app.views.controls.canvas.World2dResizableCanvasFx;
import ca.ntro.cards.shift2.Shift2Constants;
import ca.ntro.cards.shift2.frontend.views.controls.Shift2PreviewCanvas;
import ca.ntro.cards.shift2.frontend.views.controls.Shift2MainCanvas;
import ca.ntro.cards.frontend.views.ProcedureCanvasView;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class Shift2CardsView extends ProcedureCanvasView {

	@FXML
	private VBox cardsViewContainer;

	@FXML
	private Shift2PreviewCanvas previewCanvas;

	@FXML
	private Shift2MainCanvas mainCanvas;

	@FXML
	private StackPane dashboardContainer;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		Ntro.assertNotNull("cardsViewContainer", cardsViewContainer);
		Ntro.assertNotNull("previewCanvas", previewCanvas);
		Ntro.assertNotNull("mainCanvas", mainCanvas);
		Ntro.assertNotNull("dashboardContainer", dashboardContainer);

		super.initialize(location, resources);
	}

	@SuppressWarnings("rawtypes")
	@Override
	protected World2dResizableCanvasFx mainCanvas() {
		return mainCanvas;
	}

	@SuppressWarnings("rawtypes")
	@Override
	protected World2dCanvasFx previewCanvas() {
		return previewCanvas;
	}

	@Override
	protected Pane dashboardContainer() {
		return dashboardContainer;
	}

	@Override
	protected Pane cardsViewContainer() {
		return cardsViewContainer;
	}

	@Override
	protected double initialWorldHeight() {
		return Shift2Constants.INITIAL_WORLD_HEIGHT;
	}

	@Override
	protected double initialWorldWidth() {
		return Shift2Constants.INITIAL_WORLD_WIDTH;
	}

	@Override
	protected double initialPreviewCanvasScreenHeight() {
		return Shift2Constants.INITIAL_PREVIEW_CANVAS_SCREEN_HEIGHT;
	}

}
