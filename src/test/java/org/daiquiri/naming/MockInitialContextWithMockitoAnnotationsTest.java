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

import org.daiquiri.DaiquiriAnnotations;
import org.daiquiri.annotations.MockContext;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class MockInitialContextWithMockitoAnnotationsTest {

    @Mock
    @MockContext
    private InitialContext mockContext;

    @BeforeMethod
    public void initAnnotations() {
        MockitoAnnotations.initMocks(this);
        DaiquiriAnnotations.init(this);
    }

    @Test
    public void can_use_daiquiri_and_mockito_context() throws NamingException {
        String hello = "Hi Mockito !";
        Mockito.when(mockContext.lookup(Matchers.anyString())).thenReturn(hello);

        Context context = new InitialContext();
        Assert.assertEquals(context.lookup("hello"), hello);
    }
}
