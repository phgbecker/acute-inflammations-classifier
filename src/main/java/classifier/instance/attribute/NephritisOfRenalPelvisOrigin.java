package classifier.instance.attribute;

public enum NephritisOfRenalPelvisOrigin {
    YES("yes"),
    NO("no");

    private final String value;

    NephritisOfRenalPelvisOrigin(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
