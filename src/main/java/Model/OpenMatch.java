package Model;

public class OpenMatch extends Match {
    private int maxDurationTime;
    private int maxPlayerAmount;

    public OpenMatch(String name, int duration, String localization, int maxPlayerAmount) {
        super(name, duration, localization);
        this.maxPlayerAmount = maxPlayerAmount;
    }

    public int getMaxPlayerAmount() {
        return maxPlayerAmount;
    }

    public void setMaxPlayerAmount(int maxPlayerAmount) {
        this.maxPlayerAmount = maxPlayerAmount;
    }

    @Override
    public boolean finishMatch() { // polimorficzne wołanie metod
        if(super.getDuration() == maxDurationTime){
            return true;
        }
        return false;
    }
}
