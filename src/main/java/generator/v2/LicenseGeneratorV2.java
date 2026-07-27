package generator.v2;

public class LicenseGeneratorV2 {

    public static void generate() throws Exception {

        StringBuilder code = new StringBuilder();

        code.append("MIT License\n\n");

        code.append("Copyright (c) 2026 Jayadev M.M\n\n");

        code.append("Permission is hereby granted, free of charge, to any person obtaining a copy ");
        code.append("of this software and associated documentation files (the \"Software\"), ");
        code.append("to deal in the Software without restriction, including without limitation ");
        code.append("the rights to use, copy, modify, merge, publish, distribute, sublicense, ");
        code.append("and/or sell copies of the Software, and to permit persons to whom the ");
        code.append("Software is furnished to do so.\n\n");

        code.append("THE SOFTWARE IS PROVIDED \"AS IS\", WITHOUT WARRANTY OF ANY KIND, ");
        code.append("EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF ");
        code.append("MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.\n");

        GeneratorFileUtil.writeFile(
                "",
                "FrameworkConstants.LICENSE_FILE",
                code.toString());

    }

}