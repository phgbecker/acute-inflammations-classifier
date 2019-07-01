package classifier;

import classifier.instance.AcuteInflammationsInstance;
import classifier.model.ClassifierModel;
import weka.core.Instance;
import weka.core.Instances;

import java.io.IOException;

public class AcuteInflammationsClassifier {
    private Instances dataSet;
    private ClassifierModel classifier;

    AcuteInflammationsClassifier(String dataSetFileName) throws IOException {
        this.dataSet = ClassifierModel.loadDataSetFrom(dataSetFileName);
        this.dataSet.setClassIndex(dataSet.numAttributes() - 1);
    }

    public AcuteInflammationsClassifier buildModel() throws Exception {
        classifier = new ClassifierModel(
                new String[]{"-U", "-M", "2"},
                dataSet
        );

        return this;
    }

    public AcuteInflammationsClassifier evaluate() throws Exception {
        classifier.evaluate();

        return this;
    }

    public void save(String fileName) throws Exception {
        classifier.saveToFile(fileName);
    }

    public void classifyInstance(String instanceFileName) throws Exception {
        AcuteInflammationsInstance inflammationsInstance = AcuteInflammationsInstance.deserializeFromJson(instanceFileName);
        Instance instance = inflammationsInstance.getInstance(dataSet);
        System.out.println(instance);
    }
}
