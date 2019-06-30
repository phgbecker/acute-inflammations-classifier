package classifier.instance.attribute;

public enum UrinePushing {
    YES("yes"),
    NO("no");

    private final String value;

    UrinePushing(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
