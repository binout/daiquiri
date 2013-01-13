/**
 * Copyright (C) 2013 Benoit Prioux <binout@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.daiquiri.naming;

import static org.daiquiri.Daiquiri.*;

import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import javax.naming.*;
import java.util.Hashtable;

public class BasicInitialContextTest {

    private InitialContext mockContext;

    @BeforeSuite
    public void check_no_factory_is_registered() throws NamingException {
        try {
            Context context = new InitialContext();
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

    @Test(expectedExceptions = UnsupportedOperationException.class, expectedExceptionsMessageRegExp = "Not supported by org.daiquiri.naming.BasicContext")
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

    @Test(expectedExceptions = NameNotFoundException.class)
    public void can_unbind_object() throws NamingException {
        String name = "name";
        String value = "value";
        mockContext.bind(name, value);
        String found = (String) new InitialContext().lookup(name);
        Assert.assertEquals(found, value);

        mockContext.unbind(name);
        new InitialContext().lookup(name);
    }

    @Test
    public void can_rename_object() throws NamingException {
        String name = "name";
        String value = "value";
        mockContext.bind(name, value);
        String found = (String) new InitialContext().lookup(name);
        Assert.assertEquals(found, value);

        String newName = "newname";
        mockContext.rename(name, "newname");
        found = (String) new InitialContext().lookup(newName);
        Assert.assertEquals(found, value);
    }


    @Test
    public void should_be_created_with_environment() throws NamingException {
        Hashtable<Object, Object> environment = new Hashtable<Object, Object>();
        String home = "home";
        String earth = "earth";
        environment.put(home, earth);

        Context context = new InitialContext(environment);

        Assert.assertNotNull(context.getEnvironment());
        Assert.assertEquals(1, context.getEnvironment().size());
        Assert.assertEquals(earth, context.getEnvironment().get(home));
    }
}
