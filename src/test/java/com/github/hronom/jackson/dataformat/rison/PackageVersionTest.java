package com.github.hronom.jackson.dataformat.rison;

import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.testng.Assert.*;

public class PackageVersionTest {
    @Test
    public void testUsedJacksonCoreEqualityWithPackageVersion() throws IOException {
        assertEquals(
            PackageVersion.VERSION.getMajorVersion(),
            com.fasterxml.jackson.core.json.PackageVersion.VERSION.getMajorVersion()
        );
        assertEquals(
            PackageVersion.VERSION.getMinorVersion(),
            com.fasterxml.jackson.core.json.PackageVersion.VERSION.getMinorVersion()
        );
        assertEquals(
            PackageVersion.VERSION.getPatchLevel(),
            com.fasterxml.jackson.core.json.PackageVersion.VERSION.getPatchLevel()
        );
    }
}