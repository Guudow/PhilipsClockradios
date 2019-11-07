package dk.dtu.philipsclockradio;

public class StaRadio extends StateAdapter {

    private double AMFrekvens = 0;
    private double FMFrekvens = 0;
    private boolean valgtForAtGemme;


    @Override
    public void onEnterState(ContextClockradio context) {

        context.ui.turnOnLED(1);
        valgtForAtGemme = context.isValgtForAtGemme();
        AMFrekvens = context.getAmFrekvens();
        FMFrekvens = context.getFmFrekvens();
        context.ui.statusTextview.setText("FM");


        if (valgtForAtGemme()){

            context.ui.setDisplayText(AMFrekvens + "");

        } else {

            context.ui.setDisplayText(FMFrekvens + "");

        }
    }

    private boolean valgtForAtGemme() {

        return valgtForAtGemme;
    }


    public void setValgtForAtGemme (boolean valgtForAtGemme) {

        this.valgtForAtGemme = valgtForAtGemme;

    }


    @Override
    public void onClick_Min (ContextClockradio ccontext) {

        if (valgtForAtGemme){

            AMFrekvens += 1;
            ccontext.ui.setDisplayText(AMFrekvens + "");

        } else {

            FMFrekvens += 1;
            ccontext.ui.setDisplayText(FMFrekvens + "");

        }
    }

    @Override
    public void onClick_Hour (ContextClockradio ccontext) {

        if (valgtForAtGemme){

            AMFrekvens -= 1;
            ccontext.ui.setDisplayText(AMFrekvens + "");

        } else {

            FMFrekvens -= 1;
            ccontext.ui.setDisplayText(FMFrekvens + "");

        }
    }

    @Override
    public void onLongClick_Power(ContextClockradio ccontext) {

        ccontext.setValgtForAtGemme(valgtForAtGemme());
        ccontext.setAmFrekvens(AMFrekvens);
        ccontext.setFmFrekvens(FMFrekvens);
        ccontext.setState(new StateStandby(ccontext.getTime()));

    }

    @Override
    public void onClick_Power(ContextClockradio ccontext) {

        if (valgtForAtGemme) {

            ccontext.setValgtForAtGemme(true);
            ccontext.ui.setDisplayText(AMFrekvens + "");
            ccontext.ui.statusTextview.setText("AM");

        } else {

            ccontext.setValgtForAtGemme(false);
            ccontext.ui.setDisplayText(FMFrekvens + "");
            ccontext.ui.statusTextview.setText("FM");

        }
    }

    @Override
    public void onExitState (ContextClockradio context) {

        context.ui.statusTextview.setText("");
        context.ui.turnOffLED(1);

    }

}
