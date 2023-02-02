/*
Copyright (C) (2020) (Mathieu Bergeron) (mathieu.bergeron@cmontmorency.qc.ca)

This file is part of Ntro, an application framework designed with teaching in mind.

This is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <https://www.gnu.org/licenses/>.

*/
package ca.ntro.app.frontend;

import ca.ntro.app.services.Window;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class WindowFx implements Window {
    
    private Stage primaryStage;
    private Parent parent = (Parent) new DefaultRootView();
    
    private double width = 640;
    private double height = 360;

    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    public Parent getParent() {
        return parent;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }
    
    
    
    

    public WindowFx() {
    }

    public WindowFx(Stage primaryStage) {
        setPrimaryStage(primaryStage);
    }
    
    

    @Override
    public void resize(int width, int height) {

        Scene existingScene = getPrimaryStage().getScene();
        if(existingScene != null) {
            
            getPrimaryStage().setWidth(width);
            getPrimaryStage().setHeight(height);

            this.width = width;
            this.height = height;

            
        }else {

            setRootScene(width, height);
            
            this.width = getPrimaryStage().getWidth();
            this.height = getPrimaryStage().getHeight();
        }
    }

    private void setRootScene(double width, double height) {

        Scene rootScene = new Scene(getParent(), width, height);
        rootScene.setFill(Color.TRANSPARENT);
        getPrimaryStage().setScene(rootScene);
    }
    

    @Override
    public void installRootView(View<?> rootView) {
        if(rootView.rootNode() != null) {

            setParent((Parent) rootView.rootNode());
            
            double sceneWidth = width;
            double sceneHeight = height;
            
            Scene existingScene = getPrimaryStage().getScene();
            if(existingScene != null) {
                this.width = getPrimaryStage().getWidth();
                this.height = getPrimaryStage().getHeight();
                
                sceneWidth = existingScene.getWidth();
                sceneHeight = existingScene.getHeight();
            }

            setRootScene(sceneWidth, sceneHeight);

        }else {
            
            throw new RuntimeException("[WindowFx.installRootView] rootView.rootNode() is null");
        }

    }

    @Override
    public void show() {
        if(getPrimaryStage().getScene() == null){
            setRootScene(width, height);
        }

        /* TMP: for screenshots
        getPrimaryStage().setMinWidth(600);
        getPrimaryStage().setMaxWidth(600);
        getPrimaryStage().setMinHeight(400);
        getPrimaryStage().setMaxHeight(400);
        */

        getPrimaryStage().setIconified(false);
        getPrimaryStage().show();
    }

    @Override
    public void fullscreen(boolean isFullscreen) {
        getPrimaryStage().setFullScreen(isFullscreen);
    }

    @Override
    public void decorations(boolean hasDecorations) {
    	if(getPrimaryStage().isShowing()) {
    		System.out.println("[WARNING] window.decorations() must be called before window.show()");
    		return;
    	}

        if(hasDecorations) {

            getPrimaryStage().initStyle(StageStyle.DECORATED);

        }else {

            getPrimaryStage().initStyle(StageStyle.TRANSPARENT);

        }
    }

	@Override
	public void hide() {
		ObservableList<javafx.stage.Window> windows = getPrimaryStage().getWindows();
		
		javafx.stage.Window fxWindow = windows.get(0);
		
		fxWindow.hide();
	}


}
