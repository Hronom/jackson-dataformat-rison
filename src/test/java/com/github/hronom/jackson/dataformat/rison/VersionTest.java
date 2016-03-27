package com.github.hronom.jackson.dataformat.rison;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.core.Versioned;

import org.testng.annotations.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class VersionTest {
    @Test
    public void testMapperVersions() throws IOException {
        RisonFactory factory = new RisonFactory();
        assertVersion(factory);
        assertVersion(factory.createGenerator(new ByteArrayOutputStream()));
        assertVersion(factory.createParser(new byte[0]));
    }

    private void assertVersion(Versioned versioned) {
        Version version = versioned.version();
        assertFalse(version.isUnknownVersion(), "Should find version information (got " + version + ")");
        assertEquals(version.getMajorVersion(), 2);
        assertEquals(version.getMinorVersion(), 7);
        assertEquals(version.getGroupId(), "com.github.hronom");
        assertEquals(version.getArtifactId(), "jackson-dataformat-rison");
    }
}
