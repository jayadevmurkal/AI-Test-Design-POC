package ai.framework;

import ai.framework.generator.framework.FrameworkGeneratorV3;
import ai.framework.model.FrameworkConfiguration;
import ai.framework.model.FrameworkMetadata;
import ai.framework.model.FrameworkProject;

public class FrameworkGeneratorApplication {

    public static void main(String[] args) {

        try {

            FrameworkProject project = new FrameworkProject();

            project.setMetadata(new FrameworkMetadata());

            project.setConfiguration(new FrameworkConfiguration());

            FrameworkGeneratorV3 generator = new FrameworkGeneratorV3("generated-output");

            generator.generate(project);

            System.out.println("====================================");
            System.out.println("Framework Generation Completed");
            System.out.println("Output : generated-output");
            System.out.println("====================================");

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}