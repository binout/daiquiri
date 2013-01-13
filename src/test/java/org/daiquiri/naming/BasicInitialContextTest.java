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

import org.daiquiri.Daiquiri;
import org.testng.annotations.Test;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;

@Test
public class BasicInitialContextTest extends AbstractBasicContextTest<InitialContext> {

    @Override
    protected InitialContext mockContext() throws NamingException {
        return Daiquiri.Naming.mockInitialContext();
    }

    @Override
    protected InitialContext newContext() throws NamingException {
        return new InitialContext();
    }

    @Override
    protected InitialContext newContext(Hashtable<Object, Object> environment) throws NamingException {
        return new InitialContext(environment);
    }
}
