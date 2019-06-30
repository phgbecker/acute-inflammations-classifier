package classifier.model;

import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.SerializationHelper;

public class J48Model {
    private J48 j48;
    private String[] options;
    private Instances dataSet;

    public J48Model(String[] options, Instances dataSet) throws Exception {
        this.options = options;
        this.dataSet = dataSet;
        this.j48 = build();
    }

    public J48 build() throws Exception {
        j48 = new J48();
        j48.setOptions(options);
        j48.buildClassifier(dataSet);

        return j48;
    }

    public J48 get() {
        return j48;
    }

    public void saveToFile(String fileName) throws Exception {
        SerializationHelper.write(fileName, j48);
    }
}
