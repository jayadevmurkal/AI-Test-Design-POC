package ai.framework;

import ai.framework.generator.GeneratorEngine;
import ai.framework.generator.framework.BasePageGeneratorV3;
import ai.framework.model.FrameworkProject;

public class FrameworkGeneratorV3 {

    public static void main(String[] args) throws Exception {

        // Create an empty framework project
        FrameworkProject project = new FrameworkProject();

        // Create the engine
        GeneratorEngine engine = new GeneratorEngine();

        // Register generators
        engine.register(new BasePageGeneratorV3());

        // Execute generators
        engine.generate(project);

        // Verify generated files
        System.out.println("======================================");
        System.out.println("Generated Files");
        System.out.println("======================================");

        project.getFiles().forEach(file -> {
            System.out.println(file.getPackageName() + "." + file.getFileName());
        });

        System.out.println();
        System.out.println("Total Files Generated : " + project.getFiles().size());

    }

}