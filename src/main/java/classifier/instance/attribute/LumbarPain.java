package classifier.instance.attribute;

public enum LumbarPain {
    YES("yes"),
    NO("no");

    private final String value;

    LumbarPain(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
