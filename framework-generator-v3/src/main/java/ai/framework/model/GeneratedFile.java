package ai.framework.model;

public class GeneratedFile {

    private String packageName;
    private String fileName;
    private String content;

    public GeneratedFile() {
    }

    public GeneratedFile(String packageName, String fileName, String content) {
        this.packageName = packageName;
        this.fileName = fileName;
        this.content = content;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}