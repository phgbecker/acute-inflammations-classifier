package classifier.instance.attribute;

public enum BurningOfUrethra {
    YES("yes"),
    NO("no");

    private final String value;

    BurningOfUrethra(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
