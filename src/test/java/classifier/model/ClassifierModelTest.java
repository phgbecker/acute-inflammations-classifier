package classifier.model;

import org.junit.Test;
import weka.classifiers.trees.J48;
import weka.core.Instances;

import static org.assertj.core.api.Assertions.assertThat;

public class ClassifierModelTest {

    @Test
    public void givenOptionsAndDataSet_whenConstructNewInstance_thenSaveToFile() throws Exception {
        String[] options = new String[]{"-U", "-M", "2"};

        Instances dataSet = ClassifierModel.loadDataSetFrom("acute-inflammations.csv");
        dataSet.setClassIndex(dataSet.numAttributes() - 1);

        ClassifierModel classifier = new ClassifierModel(
                options,
                dataSet
        );
        classifier.evaluate();
        classifier.saveToFile("acute-inflammations.model");
    }

    @Test
    public void givenFileName_whenLoadModelFrom_thenIsInstanceOfJ48() throws Exception {
        assertThat(
                ClassifierModel.loadModelFrom("acute-inflammations.model")
        ).isInstanceOf(J48.class);
    }

    @Test
    public void givenFileName_whenLoadDataSetFrom_thenIsInstanceOfInstances() throws Exception {
        assertThat(
                ClassifierModel.loadDataSetFrom("acute-inflammations.csv")
        ).isInstanceOf(Instances.class);
    }

}