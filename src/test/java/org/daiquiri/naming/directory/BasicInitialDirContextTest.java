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
package org.daiquiri.naming.directory;

import org.daiquiri.Daiquiri;
import org.daiquiri.naming.AbstractBasicContextTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import java.util.Hashtable;

public class BasicInitialDirContextTest extends AbstractBasicContextTest<InitialDirContext>{

    @Override
    protected InitialDirContext mockContext() throws NamingException {
        return Daiquiri.Naming.mockInitialDirContext();
    }

    @Override
    protected InitialDirContext newContext() throws NamingException {
        return new InitialDirContext();
    }

    @Override
    protected InitialDirContext newContext(Hashtable<Object, Object> environment) throws NamingException {
        return new InitialDirContext(environment);
    }

    @Test
    public void init_mock_dir_context() throws NamingException {
        InitialDirContext mockContext = Daiquiri.Naming.mockInitialDirContext();
        Assert.assertNotNull(mockContext);
        Assert.assertTrue(mockContext instanceof BasicInitialDirContext);
    }
}
