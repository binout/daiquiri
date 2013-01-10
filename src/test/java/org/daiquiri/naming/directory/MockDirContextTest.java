package org.daiquiri.naming.directory;

import org.daiquiri.Daiquiri;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class MockDirContextTest {

    @Mock
    private DirContext mockContext;

    @BeforeMethod
    public void initMockito() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void can_use_mock_dir_context() throws NamingException {
        String hello = "Hi Mockito !";
        Mockito.when(mockContext.lookup(Matchers.anyString())).thenReturn(hello);

        Daiquiri.Naming.mockDirContext(mockContext);

        DirContext context = new InitialDirContext();
        Assert.assertEquals(context.lookup("hello"), hello);
    }
}
