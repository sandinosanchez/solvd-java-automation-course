package enums;

public enum FilePath {
    INPUT(""
            , "src/main/java/input.txt",
            "input.txt"),
    OUTPUT("",
            "src/main/java/output.txt",
            "output.txt");

    public String sourceRootPath;
    public String contentRootPath;
    private String absolutePath;

    FilePath(String absolutePath, String contentRootPath, String sourceRootPath) {
        this.sourceRootPath = sourceRootPath;
        this.contentRootPath = contentRootPath;
        this.absolutePath = absolutePath;
    }

    public String getContentRootPath() { return this.contentRootPath; }

    public String getSourceRootPath() { return this.sourceRootPath; }

    public String getAbsolutePath() { return absolutePath; }
}
