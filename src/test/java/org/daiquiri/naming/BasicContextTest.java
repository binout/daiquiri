package org.daiquiri.naming;

import static org.daiquiri.Daiquiri.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.naming.InitialContext;
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
}
