package dk.dtu.philipsclockradio;

import java.util.Calendar;
import java.util.Date;

//
public class ContextClockradio {
    private State currentState;
    private Date mTime;
    private String mDisplayText;
    public boolean isClockRunning = false;
    private double amFrekvens = 99;
    private double fmFrekvens = 100.2;
    public double [] amFrekvenser = new double[10];
    public double [] fmFrekvenser = new double[10];
    public boolean choosToSave = false;
    public static MainUI ui;

    public ContextClockradio(State currentState, Date mTime, String mDisplayText,
                             boolean isClockRunning, double amFrekvens,
                             double fmFrekvens, double[] amFrekvenser,
                             double[] fmFrekvenser, boolean choosToSave) {

        this.currentState = currentState;
        this.mTime = mTime;
        this.mDisplayText = mDisplayText;
        this.isClockRunning = isClockRunning;
        this.amFrekvens = amFrekvens;
        this.fmFrekvens = fmFrekvens;
        this.amFrekvenser = amFrekvenser;
        this.fmFrekvenser = fmFrekvenser;
        this.choosToSave = choosToSave;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    public Date getmTime() {
        return mTime;
    }

    public void setmTime(Date mTime) {
        this.mTime = mTime;
    }

    public String getmDisplayText() {
        return mDisplayText;
    }

    public void setmDisplayText(String mDisplayText) {
        this.mDisplayText = mDisplayText;
    }

    public boolean isClockRunning() {
        return isClockRunning;
    }

    public void setClockRunning(boolean clockRunning) {
        isClockRunning = clockRunning;
    }

    public double getAmFrekvens() {
        return amFrekvens;
    }

    public void setAmFrekvens(double amFrekvens) {
        this.amFrekvens = amFrekvens;
    }

    public double getFmFrekvens() {
        return fmFrekvens;
    }

    public void setFmFrekvens(double fmFrekvens) {
        this.fmFrekvens = fmFrekvens;
    }

    public double[] getAmFrekvenser() {
        return amFrekvenser;
    }

    public void setAmFrekvenser(double[] amFrekvenser) {
        this.amFrekvenser = amFrekvenser;
    }

    public double[] getFmFrekvenser() {
        return fmFrekvenser;
    }

    public void setFmFrekvenser(double[] fmFrekvenser) {
        this.fmFrekvenser = fmFrekvenser;
    }

    public boolean isValgtForAtGemme() {
        return choosToSave;
    }

    public void setValgtForAtGemme(boolean valgtForAtGemme) {
        this.choosToSave = valgtForAtGemme;
    }

    public static MainUI getUi() {
        return ui;
    }

    public static void setUi(MainUI ui) {
        ContextClockradio.ui = ui;
    }


    public ContextClockradio(MainUI context){
        ui = context;

        //Sætter tiden til 12.00, hvis tiden ikke er sat endnu
        if(mTime == null){
            Calendar date = Calendar.getInstance();
            date.set(2019, 1, 1, 12, 00);
            mTime = date.getTime();
        }

        //Når app'en starter, så går vi ind i Standby State
        currentState = new StateStandby(mTime);
        currentState.onEnterState(this);
    }

    //setState er når vi skifter State
    void setState(final State newState) {
        currentState.onExitState(this);
        currentState = newState;
        currentState.onEnterState(this);
        System.out.println("Current state: "+ newState.getClass().getSimpleName());
    }

    //Opdaterer kontekst time state og UI
    void setTime(Date time){
        mTime = time;
        if(currentState.getClass().getSimpleName().equals("StateStandby")){
            updateDisplayTime();
        }
    }


    void updateDisplayTime(){
        mDisplayText = mTime.toString().substring(11,16);
        ui.setDisplayText(mDisplayText);
    }

    public Date getTime(){
        return mTime;
    }

    //Disse metoder bliver kaldt fra UI tråden
    public void onClick_Hour() {
        currentState.onClick_Hour(this);
    }

    public void onClick_Min() {
        currentState.onClick_Min(this);
    }

    public void onClick_Preset() {
        currentState.onClick_Preset(this);
    }

    public void onClick_Power() {
        currentState.onClick_Power(this);
    }

    public void onClick_Sleep() {
        currentState.onClick_Sleep(this);
    }

    public void onClick_AL1() {
        currentState.onClick_AL1(this);
    }

    public void onClick_AL2() {
        currentState.onClick_AL2(this);
    }

    public void onClick_Snooze() {
        currentState.onClick_Snooze(this);
    }

    public void onLongClick_Hour(){
        currentState.onLongClick_Hour(this);
    }

    public void onLongClick_Min(){
        currentState.onLongClick_Min(this);
    }

    public void onLongClick_Preset(){
        currentState.onLongClick_Preset(this);
    }

    public void onLongClick_Power(){
        currentState.onLongClick_Power(this);
    }

    public void onLongClick_Sleep(){
        currentState.onLongClick_Sleep(this);
    }

    public void onLongClick_AL1(){
        currentState.onLongClick_AL1(this);
    }

    public void onLongClick_AL2(){
        currentState.onLongClick_AL2(this);
    }

    public void onLongClick_Snooze(){
        currentState.onLongClick_Snooze(this);
    }
}