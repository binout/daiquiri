package org.daiquiri.naming.directory;

import org.daiquiri.Daiquiri;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.naming.NamingException;
import javax.naming.directory.DirContext;

public class BasicInitialDirContextTest {

    private DirContext mockContext;

    @Test
    public void init_mock_dir_context() throws NamingException {
        mockContext = Daiquiri.Naming.mockInitialDirContext();
        Assert.assertNotNull(mockContext);
        Assert.assertTrue(mockContext instanceof BasicInitialDirContext);
    }
}
