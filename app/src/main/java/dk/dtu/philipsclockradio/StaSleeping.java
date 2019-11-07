package dk.dtu.philipsclockradio;

import android.os.CountDownTimer;

public class StaSleeping extends StateAdapter {

    private boolean mTimerR;
    private CountDownTimer mCDTimer;
    private long mTimeleftIMilliSecond = StartTid;
    private static final long StartTid = 5000;
    int [] interval = new int[] {120, 90, 60, 30, 15};
    int click = 1;


    @Override
    public void onEnterState(ContextClockradio context) {
        startTimer(context);
        context.ui.setDisplayText(interval[0] + "");
        context.ui.turnOnLED(3);
    }

    public void startTimer (final ContextClockradio context) {

        // 1 sekund
        mCDTimer = new CountDownTimer(mTimeleftIMilliSecond, 1000) {
            @Override
            public void onTick(long finished) {
                mTimeleftIMilliSecond = finished;

            }

            @Override
            public void onFinish() {

                mTimerR = false;
                context.setState(new StateStandby(context.getTime()));

            }
        }.start();

        mTimerR = true;

    }

    @Override
    public void onClick_Sleep(ContextClockradio ccontext) {

        stopTimer();
        startTimer(ccontext);

        if (click <= 4) {

            ccontext.ui.turnOnLED(3);
            ccontext.ui.setDisplayText(interval[click] + "");
            click++;

        }

    }

    @Override
    public void onLongClick_Sleep(ContextClockradio context) {

        context.setState(new StateStandby(context.getTime()));

    }


    public void stopTimer (){

        mCDTimer.cancel();

    }

}
