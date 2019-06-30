package classifier.instance.attribute;

public enum InflammationOfUrinaryBladder {
    YES("yes"),
    NO("no");

    private final String value;

    InflammationOfUrinaryBladder(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
