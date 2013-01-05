package org.daiquiri.naming;

import static org.daiquiri.Daiquiri.*;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.naming.InitialContext;
import javax.naming.Name;
import javax.naming.NameNotFoundException;
import javax.naming.NamingException;

public class BasicContextTest {

    private InitialContext context;

    @BeforeClass
    public void initNamingContext() throws NamingException {
        try {
            newInitialContext();
            Assert.fail("should fail because no context is mocked !");
        } catch (NamingException e) {
            // OK
        }
        Naming.mockContext();
        try {
            Naming.clear();
            Assert.fail("should fail because no context is built !");
        }  catch (IllegalStateException e) {
            // OK
        }
    }

    private void newInitialContext() throws NamingException {
        context = new InitialContext();
        context.getEnvironment();
    }

    @BeforeMethod
    public void clearNamingContext() throws NamingException {
       newInitialContext();
       Naming.clear();
    }

    @Test
    public void can_mock_two_times() throws NamingException {
        Naming.mockContext();
    }

    @Test(expectedExceptions = UnsupportedOperationException.class, expectedExceptionsMessageRegExp = "Not supported by org.daiquiri.naming.BasicContext")
    public void can_be_instantiated_by_factory() throws NamingException {
        Name name = Mockito.mock(Name.class);
        context.lookup(name);
    }

    @Test
    public void can_bind_object() throws NamingException {
        String name = "name";
        String value = "value";
        Naming.bind(name, value);

        String found = (String) context.lookup(name);

        Assert.assertEquals(found, value);
    }

    @Test(expectedExceptions = NameNotFoundException.class)
    public void should_throw_exception_if_not_bound() throws NamingException {
        context.lookup("name");
    }
}
