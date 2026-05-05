import javafx.beans.property.*;

public class WashStep {
    private final StringProperty action = new SimpleStringProperty();
    private final IntegerProperty time = new SimpleIntegerProperty();
    private final IntegerProperty temp = new SimpleIntegerProperty();
    private final IntegerProperty liters = new SimpleIntegerProperty();
    private final StringProperty chemical = new SimpleStringProperty();

    public WashStep(String action, int time, int temp, int liters, String chemical) {
        this.action.set(action);
        this.time.set(time);
        this.temp.set(temp);
        this.liters.set(liters);
        this.chemical.set(chemical);
    }

    public String getAction() { return action.get(); }
    public void setAction(String value) { action.set(value); }
    public StringProperty actionProperty() { return action; }

    public int getTime() { return time.get(); }
    public void setTime(int value) { time.set(value); }
    public IntegerProperty timeProperty() { return time; }

    public int getTemp() { return temp.get(); }
    public void setTemp(int value) { temp.set(value); }
    public IntegerProperty tempProperty() { return temp; }

    public int getLiters() { return liters.get(); }
    public void setLiters(int value) { liters.set(value); }
    public IntegerProperty litersProperty() { return liters; }

    public String getChemical() { return chemical.get(); }
    public void setChemical(String value) { chemical.set(value); }
    public StringProperty chemicalProperty() { return chemical; }
}
