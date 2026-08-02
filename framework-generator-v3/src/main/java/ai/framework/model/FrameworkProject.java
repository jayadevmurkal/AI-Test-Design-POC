package ai.framework.model;

import java.util.ArrayList;
import java.util.List;

public class FrameworkProject {

    private FrameworkMetadata metadata;
    private FrameworkConfiguration configuration;
    private List<GeneratedFile> files = new ArrayList<>();

    public FrameworkMetadata getMetadata() {
        return metadata;
    }

    public void setMetadata(FrameworkMetadata metadata) {
        this.metadata = metadata;
    }

    public FrameworkConfiguration getConfiguration() {
        return configuration;
    }

    public void setConfiguration(FrameworkConfiguration configuration) {
        this.configuration = configuration;
    }

    public List<GeneratedFile> getFiles() {
        return files;
    }

    public void addFile(GeneratedFile file) {
        files.add(file);
    }
}