package org.daiquiri.naming;

import org.daiquiri.Daiquiri;
import org.daiquiri.naming.directory.BasicDirContext;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class MockInitialContextTest {

    @Mock
    private InitialContext mockContext;

    @BeforeMethod
    public void initMockito() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void can_use_mock_dir_context() throws NamingException {
        String hello = "Hi Mockito !";
        Mockito.when(mockContext.lookup(Matchers.anyString())).thenReturn(hello);

        Daiquiri.Naming.mockInitialContext(mockContext);

        InitialContext context = new InitialContext();
        Assert.assertEquals(context.lookup("hello"), hello);
    }
}
