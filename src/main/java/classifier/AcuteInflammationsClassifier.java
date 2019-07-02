package classifier;

import classifier.instance.AcuteInflammationsInstance;
import classifier.model.ClassifierModel;
import weka.core.Instance;
import weka.core.Instances;

import java.io.IOException;
import java.util.HashMap;

public class AcuteInflammationsClassifier {
    private Instances dataSet;
    private ClassifierModel classifier;

    public AcuteInflammationsClassifier(String dataSetFileName) throws IOException {
        this.dataSet = ClassifierModel.loadDataSetFrom(dataSetFileName);
        this.dataSet.setClassIndex(dataSet.numAttributes() - 1);
    }

    public AcuteInflammationsClassifier loadModel(String fileName) throws Exception {
        classifier = new ClassifierModel(
                ClassifierModel.loadModelFrom(fileName),
                dataSet
        );

        return this;
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

    private Instance setUpInstance(AcuteInflammationsInstance acuteInflammationsInstance) {
        Instance instance = acuteInflammationsInstance.getInstance(dataSet);

        System.out.println();
        System.out.print("INSTANCE: ");
        System.out.println(instance);

        return instance;
    }

    public void classifyInstance(String fileName) throws Exception {
        AcuteInflammationsInstance inflammationsInstance = AcuteInflammationsInstance.deserializeFromJson(fileName);
        Instance instance = setUpInstance(inflammationsInstance);
        classifyInstance(instance);
    }

    private void classifyInstance(Instance instance) throws Exception {
        HashMap<Integer, String> diagnosisMap = new HashMap<>();
        diagnosisMap.put(0, "NEGATIVE");
        diagnosisMap.put(1, "POSITIVE");

        System.out.println();
        System.out.println("CLASS: NEPHRITIS OF RENAL PELVIS ORIGIN");
        System.out.println();
        System.out.print("DIAGNOSIS: ");
        System.out.println(diagnosisMap.get((int) classifier.get().classifyInstance(instance)));

        double[] distributionForInstance = classifier.get().distributionForInstance(instance);
        diagnosisMap.forEach((index, diagnosis) ->
                System.out.println(diagnosis + "\t-> " + distributionForInstance[index])
        );
    }
}
