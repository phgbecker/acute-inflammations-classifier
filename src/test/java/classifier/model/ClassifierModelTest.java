package classifier.model;

import org.junit.Test;
import weka.classifiers.trees.J48;
import weka.core.Instances;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class ClassifierModelTest {

    @Test
    public void givenFileName_whenLoadModel_thenIsInstanceOfJ48() throws IOException, ClassNotFoundException {
        assertThat(
                new ClassifierModel<>().loadModel("acute-inflammations.model")
        ).isInstanceOf(J48.class);
    }

    @Test
    public void givenFileName_whenLoadDataSetFromCsv_thenIsInstanceOfInstances() throws IOException {
        assertThat(
                new ClassifierModel<>().loadDataSetFromCsv("acute-inflammations.csv")
        ).isInstanceOf(Instances.class);
    }
}