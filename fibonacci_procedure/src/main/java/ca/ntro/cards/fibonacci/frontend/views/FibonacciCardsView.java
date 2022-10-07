package ca.ntro.cards.fibonacci.frontend.views;

import java.net.URL;
import java.util.ResourceBundle;

import ca.ntro.app.views.controls.canvas.World2dCanvasFx;
import ca.ntro.app.views.controls.canvas.World2dResizableCanvasFx;
import ca.ntro.cards.fibonacci.FibonacciConstants;
import ca.ntro.cards.fibonacci.frontend.views.controls.FibonacciPreviewCanvas;
import ca.ntro.cards.fibonacci.frontend.views.controls.FibonacciMainCanvas;
import ca.ntro.cards.frontend.views.ProcedureCanvasView;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class FibonacciCardsView extends ProcedureCanvasView {

	@FXML
	private VBox cardsViewContainer;

	@FXML
	private FibonacciPreviewCanvas previewCanvas;

	@FXML
	private FibonacciMainCanvas mainCanvas;

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
		return FibonacciConstants.INITIAL_WORLD_HEIGHT;
	}

	@Override
	protected double initialWorldWidth() {
		return FibonacciConstants.INITIAL_WORLD_WIDTH;
	}

	@Override
	protected double initialPreviewCanvasScreenHeight() {
		return FibonacciConstants.INITIAL_PREVIEW_CANVAS_SCREEN_HEIGHT;
	}

}
