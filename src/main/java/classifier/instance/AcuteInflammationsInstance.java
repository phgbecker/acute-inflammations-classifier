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
    private InflammationOfUrinaryBladder inflammationOfUrinaryBladder;
    private NephritisOfRenalPelvisOrigin nephritisOfRenalPelvisOrigin;

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
        Instance acuteInflamamtionsInstance = new DenseInstance(8);
        acuteInflamamtionsInstance.setDataset(dataSet);

        try {
            acuteInflamamtionsInstance.setValue(0, temperatureOfPatient.getNormalized());
            acuteInflamamtionsInstance.setValue(1, occurrenceOfNausea.getValue());
            acuteInflamamtionsInstance.setValue(2, lumbarPain.getValue());
            acuteInflamamtionsInstance.setValue(3, urinePushing.getValue());
            acuteInflamamtionsInstance.setValue(4, micturitionPains.getValue());
            acuteInflamamtionsInstance.setValue(5, burningOfUrethra.getValue());
            acuteInflamamtionsInstance.setValue(6, inflammationOfUrinaryBladder.getValue());
            acuteInflamamtionsInstance.setValue(7, nephritisOfRenalPelvisOrigin.getValue());
        } catch (NullPointerException e) {
            throw new NullPointerException("Oops, an attribute has not been set. Setup the instance, and try again!");
        }

        return acuteInflamamtionsInstance;
    }
}
