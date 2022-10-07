package ca.ntro.cards.shift.frontend.views;

import java.net.URL;
import java.util.ResourceBundle;

import ca.ntro.app.views.controls.canvas.World2dCanvasFx;
import ca.ntro.app.views.controls.canvas.World2dResizableCanvasFx;
import ca.ntro.cards.shift.ShiftConstants;
import ca.ntro.cards.shift.frontend.views.controls.ShiftPreviewCanvas;
import ca.ntro.cards.shift.frontend.views.controls.ShiftMainCanvas;
import ca.ntro.cards.frontend.views.ProcedureCanvasView;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class ShiftCardsView extends ProcedureCanvasView {

	@FXML
	private VBox cardsViewContainer;

	@FXML
	private ShiftPreviewCanvas previewCanvas;

	@FXML
	private ShiftMainCanvas mainCanvas;

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
		return ShiftConstants.INITIAL_WORLD_HEIGHT;
	}

	@Override
	protected double initialWorldWidth() {
		return ShiftConstants.INITIAL_WORLD_WIDTH;
	}

	@Override
	protected double initialPreviewCanvasScreenHeight() {
		return ShiftConstants.INITIAL_PREVIEW_CANVAS_SCREEN_HEIGHT;
	}

}
