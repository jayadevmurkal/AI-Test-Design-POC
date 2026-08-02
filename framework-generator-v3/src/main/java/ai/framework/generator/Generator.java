package ai.framework.generator;

import ai.framework.model.FrameworkProject;

public interface Generator {

    void generate(FrameworkProject project) throws Exception;

}