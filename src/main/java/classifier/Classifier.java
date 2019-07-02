package classifier;

class Classifier {

    public static void main(String[] args) throws Exception {
        String dataSetFile = "acute-inflammations.csv";

        new AcuteInflammationsClassifier(dataSetFile)
                .buildModel()
                .evaluate()
                .save("acute-inflammations.model");

        new AcuteInflammationsClassifier(dataSetFile)
                .loadModel("acute-inflammations.model")
                .classifyInstance("acute-inflammations.json");
    }
}
