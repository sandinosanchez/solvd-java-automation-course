package enums;

public enum EncodingType {
    UTF8("utf-8", true),
    UTF16("utf-16", false),
    UTF32("utf-32", false);

    public String encodingType;
    private boolean isSupported;

    EncodingType(String encodingType, boolean isSupported) {
        this.encodingType = encodingType;
        this.isSupported = isSupported;
    }

    public String getEncodingType() { return encodingType; }

    public boolean isSupported() { return isSupported; }
}
