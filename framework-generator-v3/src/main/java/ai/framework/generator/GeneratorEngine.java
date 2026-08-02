package ai.framework.generator;

import ai.framework.model.FrameworkProject;

import java.util.ArrayList;
import java.util.List;

public class GeneratorEngine {

    private final List<Generator> generators = new ArrayList<>();

    public void register(Generator generator) {
        generators.add(generator);
    }

    public void generate(FrameworkProject project) throws Exception {

        for (Generator generator : generators) {
            generator.generate(project);
        }

    }

}