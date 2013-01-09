package org.daiquiri.naming;

import static org.daiquiri.Daiquiri.*;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.naming.*;

public class BasicInitialContextTest {

    private Context mockContext;

    @BeforeClass
    public void check_no_factory_is_registered() throws NamingException {
        try {
            InitialContext context = new InitialContext();
            context.getEnvironment();
            Assert.fail("should fail because no context is mocked !");
        } catch (NamingException e) {
            // OK
        }
    }

    @BeforeMethod
    public void init_mock_naming_context() throws NamingException {
        mockContext = Naming.mockInitialContext();
        Assert.assertNotNull(mockContext);
    }

    @Test(expectedExceptions = UnsupportedOperationException.class, expectedExceptionsMessageRegExp = "Not supported by org.daiquiri.naming.BasicInitialContext")
    public void can_be_instantiated_by_factory() throws NamingException {
        Name name = Mockito.mock(Name.class);
        mockContext.lookup(name);
    }

    @Test
    public void can_bind_object() throws NamingException {
        String name = "name";
        String value = "value";
        mockContext.bind(name, value);

        String found = (String) new InitialContext().lookup(name);

        Assert.assertEquals(found, value);
    }

    @Test(expectedExceptions = NameNotFoundException.class)
    public void should_throw_exception_if_not_bound() throws NamingException {
        new InitialContext().lookup("name");
    }
}
