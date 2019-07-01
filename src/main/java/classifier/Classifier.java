package classifier;

class Classifier {

    public static void main(String[] args) throws Exception {
        /*
         * Build and save Model
         */
        new AcuteInflammationsClassifier("acute-inflammations.csv")
                .buildModel()
                .evaluate()
                .save("acute-inflammations.model");

        /*
         * Classify new Instance
         */
        new AcuteInflammationsClassifier("acute-inflammations.csv")
                .loadModel("acute-inflammations.model")
                .classifyInstance("acute-inflammations.json");
    }
}
