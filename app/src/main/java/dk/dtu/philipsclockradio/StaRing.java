package dk.dtu.philipsclockradio;

public class StaRing  extends StateAdapter{

    @Override
    public void onEnterState(ContextClockradio context) {
        context.ui.statusTextview.setText("Alarm ringer");

    }

    @Override
    public void onClick_Snooze(ContextClockradio context) {

        context.ui.statusTextview.setText("Alarm er udskudt");

    }

    @Override
    public void onExitState(ContextClockradio context) {
        super.onExitState(context);
    }

    @Override
    public void onClick_AL1(ContextClockradio context) {

        context.ui.statusTextview.setText("Alarm slået fra");

    }
}
