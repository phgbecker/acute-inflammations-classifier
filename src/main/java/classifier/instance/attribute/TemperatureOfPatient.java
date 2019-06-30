package classifier.instance.attribute;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class TemperatureOfPatient {
    private double denormalized;

    public TemperatureOfPatient() {
    }

    public TemperatureOfPatient(double temperature) {
        this.denormalized = temperature;
    }

    public double getDenormalized() {
        return denormalized;
    }

    @JsonIgnore
    public double getNormalized() {
        double minTemperature = 35;
        double maxTemperature = 42;

        double amplitude = maxTemperature - minTemperature;
        double proportion = denormalized - minTemperature;

        return proportion / amplitude;
    }
}
