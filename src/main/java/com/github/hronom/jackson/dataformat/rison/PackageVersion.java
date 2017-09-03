package com.github.hronom.jackson.dataformat.rison;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.Versioned;
import com.fasterxml.jackson.core.util.VersionUtil;

public final class PackageVersion implements Versioned {
    public final static Version VERSION = VersionUtil
        .parseVersion("2.9.0", "com.github.hronom", "jackson-dataformat-rison");

    public Version version() {
        return VERSION;
    }
}