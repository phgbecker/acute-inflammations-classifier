package classifier.model;

import weka.classifiers.AbstractClassifier;
import weka.classifiers.evaluation.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.SerializationHelper;
import weka.core.converters.CSVLoader;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class ClassifierModel {
    private final AbstractClassifier classifier;
    private final Instances dataSet;

    public ClassifierModel(String[] options, Instances dataSet) throws Exception {
        this.dataSet = dataSet;
        this.classifier = build(options, dataSet);
    }

    public AbstractClassifier build(String[] options, Instances dataSet) throws Exception {
        AbstractClassifier classifier = new J48();
        classifier.setOptions(options);
        classifier.buildClassifier(dataSet);

        return classifier;
    }

    public static AbstractClassifier loadModelFrom(String fileName) throws Exception {
        return (AbstractClassifier) SerializationHelper.read(fileName);
    }

    public static Instances loadDataSetFrom(String CsvFileName) throws IOException {
        CSVLoader csvLoader = new CSVLoader();
        csvLoader.setSource(new File(CsvFileName));

        return csvLoader.getDataSet();
    }

    public void evaluate() throws Exception {
        Evaluation evaluation = new Evaluation(dataSet);
        evaluation.crossValidateModel(
                classifier,
                dataSet,
                10,
                new Random(1)
        );

        System.out.println(evaluation.toSummaryString());
        System.out.println(evaluation.toClassDetailsString());
        System.out.println(evaluation.toMatrixString());
    }

    public void saveToFile(String fileName) throws Exception {
        SerializationHelper.write(fileName, classifier);
    }
}
