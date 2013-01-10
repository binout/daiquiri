package org.daiquiri.naming.directory;

import org.daiquiri.Daiquiri;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.naming.NamingException;
import javax.naming.directory.DirContext;

public class BasicDirContextTest {

    private DirContext mockContext;

    @Test
    public void init_mock_dir_context() throws NamingException {
        mockContext = Daiquiri.Naming.mockDirContext();
        Assert.assertNotNull(mockContext);
        Assert.assertTrue(mockContext instanceof BasicDirContext);
    }
}
