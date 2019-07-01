package classifier;

class Classifier {

    public static void main(String[] args) throws Exception {
        AcuteInflammationsClassifier classifier = new AcuteInflammationsClassifier("acute-inflammations.csv");

        classifier
                .buildModel()
                .evaluate()
                .save("acute-inflammations.model");

        classifier.classifyInstance("acute-inflammations.json");
    }
}
