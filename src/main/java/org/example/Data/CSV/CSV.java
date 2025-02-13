package org.example.Data.CSV;

import java.nio.file.Path;

abstract public class CSV {
    public CSV(Path dirPath) {
        this.dirPath = dirPath;
    }

    protected Path dirPath;
}
