package ca.ntro.cards.fibonacci.models.world2d;

import java.util.ArrayList;
import java.util.List;

import ca.ntro.app.NtroApp;
import ca.ntro.app.world2d.Object2d;
import ca.ntro.cards.common.CommonConstants;
import ca.ntro.cards.common.models.values.cards.Carte;
import ca.ntro.cards.fibonacci.FibonacciConstants;
import ca.ntro.cards.fibonacci.messages.FibonacciMsgAcceptManualModel;
import ca.ntro.cards.fibonacci.models.Calculateur;
import ca.ntro.cards.messages.ProcedureMsgAcceptManualModel;
import ca.ntro.cards.models.world2d.ProcedureObject2d;
import ca.ntro.cards.models.world2d.ProcedureWorld2d;

public class FibonacciProcedureWorld2d extends ProcedureWorld2d<FibonacciProcedureWorld2d, FibonacciProcedureDrawingOptions> {
    
    private FibonacciMsgAcceptManualModel msgManualExecutionStep = NtroApp.newMessage(FibonacciMsgAcceptManualModel.class);
    
    @Override
    public void buildAndSendManualModel() {

        // TODO: analyser les cartes2d existantes et créer un CardsModel 
        
        Calculateur manualModel = new Calculateur();
        
        msgManualExecutionStep.setManualModel(manualModel);
        msgManualExecutionStep.send();
    }


}
