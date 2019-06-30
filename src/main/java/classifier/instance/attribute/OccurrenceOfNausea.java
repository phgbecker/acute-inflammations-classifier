package classifier.instance.attribute;

public enum OccurrenceOfNausea {
    YES("yes"),
    NO("no");

    private final String value;

    OccurrenceOfNausea(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
