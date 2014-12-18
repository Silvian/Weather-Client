package hello.models;

/**
 * Created by silvian on 16/12/14.
 */
public class WeatherDataModel {

    String date;
    String description;
    String lowTemp;
    String highTemp;

    public WeatherDataModel(String date, String description, String lowTemp, String highTemp) {
        this.date = date;
        this.description = description;
        this.lowTemp = lowTemp;
        this.highTemp = highTemp;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLowTemp() {
        return lowTemp;
    }

    public void setLowTemp(String lowTemp) {
        this.lowTemp = lowTemp;
    }

    public String getHighTemp() {
        return highTemp;
    }

    public void setHighTemp(String highTemp) {
        this.highTemp = highTemp;
    }
}
