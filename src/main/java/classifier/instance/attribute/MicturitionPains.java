package classifier.instance.attribute;

public enum MicturitionPains {
    YES("yes"),
    NO("no");

    private final String value;

    MicturitionPains(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
