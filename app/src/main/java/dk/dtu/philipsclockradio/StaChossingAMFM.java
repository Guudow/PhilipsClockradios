package dk.dtu.philipsclockradio;

public class StaChossingAMFM extends StateAdapter {

    private int savedValue = 1;
    private boolean choosToSave;



    StaChossingAMFM(boolean choosFrekvens, int s) {

        this.choosToSave = choosFrekvens;

    }

    @Override
    public void onEnterState(ContextClockradio context) {

        context.ui.turnOnTextBlink();
        context.ui.setDisplayText(choosToSave + " ");

    }

    public void onExitState (ContextClockradio context) {

        context.ui.turnOffTextBlink();
        if (choosToSave) {
            context.amFrekvenser[savedValue - 1] = context.getAmFrekvens();

        } else {

            context.fmFrekvenser[savedValue - 1] = context.getFmFrekvens();

        }

    }

    public void onLongClick_Preset (ContextClockradio context) {

        if (savedValue <= 10){

            savedValue++;

        } else if (savedValue > 10){

            savedValue = 1;
        }
        context.ui.setDisplayText(savedValue + "");

    }
}




