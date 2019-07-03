package classifier.instance;

import classifier.instance.attribute.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;

import java.io.File;
import java.io.IOException;

@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class AcuteInflammationsInstance {
    private TemperatureOfPatient temperatureOfPatient;
    private OccurrenceOfNausea occurrenceOfNausea;
    private LumbarPain lumbarPain;
    private UrinePushing urinePushing;
    private MicturitionPains micturitionPains;
    private BurningOfUrethra burningOfUrethra;

    public void serializeToJson(String fileName) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writer(new DefaultPrettyPrinter());
        objectWriter.writeValue(
                new File(fileName),
                this
        );
    }

    public static AcuteInflammationsInstance deserializeFromJson(String fileName) throws IOException {
        return new ObjectMapper().readValue(
                new File(fileName),
                AcuteInflammationsInstance.class
        );
    }

    @JsonIgnore
    public Instance getInstance(Instances dataSet) {
        Instance acuteInflammationsInstance = new DenseInstance(6);
        acuteInflammationsInstance.setDataset(dataSet);

        try {
            acuteInflammationsInstance.setValue(0, temperatureOfPatient.getDenormalized());
            acuteInflammationsInstance.setValue(1, occurrenceOfNausea.getValue());
            acuteInflammationsInstance.setValue(2, lumbarPain.getValue());
            acuteInflammationsInstance.setValue(3, urinePushing.getValue());
            acuteInflammationsInstance.setValue(4, micturitionPains.getValue());
            acuteInflammationsInstance.setValue(5, burningOfUrethra.getValue());
        } catch (NullPointerException e) {
            throw new NullPointerException("Oops, a attribute has not been set. Setup the instance and try again!");
        }

        return acuteInflammationsInstance;
    }
}
