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
package ca.ntro.app;

import ca.ntro.app.frontend.FrontendRegistrarFx;
import ca.ntro.app.services.LocaleServiceJdk;
import ca.ntro.core.initialization.Ntro;
import javafx.application.Application;
import ntro.core.NtroFx;
import ntro.core.services.ColorServiceFx;
import services.ExitServiceFx;
import services.MessageServiceFx;

public interface NtroClientFx extends App<FrontendRegistrarFx> {
    
    void registerArgs(String[] args);
    
    private static void checkJavaVersion() {
        /*
        String javaVersion = System.getProperty("java.version");
        if(!javaVersion.startsWith("11")) {
            System.err.println("[FATAL ERROR]: java-11 is required (provided: " + javaVersion + ")");
            System.exit(0);
        }
        */
    }

    @SuppressWarnings("unchecked")
    public static void launch(String[] args) {

        initialize();
        
        Class<? extends NtroClientFx> callerClass = (Class<? extends NtroClientFx>) Ntro.stackAnalyzer().callerClass();
        
        launchImpl(callerClass, args);
    }

    public static void initialize() {
        checkJavaVersion();

        NtroApp.registerLocaleService(new LocaleServiceJdk());
        NtroApp.registerExitService(new ExitServiceFx());
        NtroApp.registerMessageService(new MessageServiceFx());
        NtroApp.registerColorService(new ColorServiceFx());

        try {

            NtroFx.initializer().executeBlocking();

        } catch (Throwable e) {

            throw new RuntimeException(e);
        }
    }

    public static void launch(Class<? extends NtroClientFx> callerClass, String[] args) {

        initialize();
        
        launchImpl(callerClass, args);
    }

    private static void launchImpl(Class<? extends NtroClientFx> callerClass, String[] args) {

        AppWrapperFx.appClass = callerClass;
        AppWrapperFx.args = args;

        Application.launch(AppWrapperFx.class, args);
    }
}
