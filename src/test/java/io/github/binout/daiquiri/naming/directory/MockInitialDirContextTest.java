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
package io.github.binout.daiquiri.naming.directory;

import io.github.binout.daiquiri.Daiquiri;
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

public class MockInitialDirContextTest {

    @Mock
    private InitialDirContext mockContext;

    @BeforeMethod
    public void initMockito() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void can_use_mock_dir_context() throws NamingException {
        String hello = "Hi Mockito !";
        Mockito.when(mockContext.lookup(Matchers.anyString())).thenReturn(hello);

        Daiquiri.Naming.mockInitialDirContext(mockContext);

        DirContext context = new InitialDirContext();
        Assert.assertEquals(context.lookup("hello"), hello);
    }
}
