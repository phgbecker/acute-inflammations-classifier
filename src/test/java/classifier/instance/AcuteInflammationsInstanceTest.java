package classifier.instance;

import classifier.instance.attribute.*;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AcuteInflammationsInstanceTest {
    private AcuteInflammationsInstance acuteInflammationsInstance;

    @Before
    public void setUp() {
        // 35.9,no,no,yes,yes,yes,yes,no
        acuteInflammationsInstance = new AcuteInflammationsInstance(
                new TemperatureOfPatient(35.9),
                OccurrenceOfNausea.NO,
                LumbarPain.NO,
                UrinePushing.YES,
                MicturitionPains.YES,
                BurningOfUrethra.YES,
                InflammationOfUrinaryBladder.YES,
                NephritisOfRenalPelvisOrigin.NO
        );
    }

    @Test
    public void givenAcuteInflammationsInstance_thenSerializeToJson() throws IOException {
        acuteInflammationsInstance.serializeToJson("acute-inflammations.json");
    }

    @Test
    public void givenJsonFile_whenDeserialize_thenIsEquals() throws IOException {
        assertThat(
                AcuteInflammationsInstance.deserializeFromJson("acute-inflammations.json")
        ).isEqualTo(acuteInflammationsInstance);
    }
}