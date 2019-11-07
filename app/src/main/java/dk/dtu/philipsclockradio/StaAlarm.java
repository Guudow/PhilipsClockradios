package dk.dtu.philipsclockradio;

import java.util.Date;

public class StaAlarm extends StateAdapter {

    Date mTime;
    String mDisplayText;


    @Override
    public void onEnterState(ContextClockradio context) {
        context.ui.turnOffLED(2);
        mTime = new Date();
        context.ui.turnOffTextBlink();

    }

    @Override
    public void onExitState(ContextClockradio context) {
        context.ui.turnOffTextBlink();

    }

    @Override
    public void onClick_Hour(ContextClockradio context) {

        mTime.setTime(mTime.getTime() + 3600000);
        updateDisplayTime(context);

    }

    @Override
    public void onClick_Min(ContextClockradio context) {

        mTime.setTime(mTime.getTime() + 60000);
        updateDisplayTime(context);


    }

    @Override
    public void onClick_AL1(ContextClockradio context) {
        context.ui.turnOffLED(1);
        context.ui.turnOnLED(2);
        context.setState(new StateStandby(context.getTime()));

    }

    @Override
    public void onClick_AL2(ContextClockradio context) {
        context.ui.turnOffLED(1);
        context.ui.turnOnLED(2);
        context.setState(new StateStandby(context.getTime()));

    }

    private void updateDisplayTime(ContextClockradio ccontext) {

        mDisplayText = mTime.toString().substring(11, 16);

        ccontext.ui.setDisplayText(mDisplayText);


    }


}



