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
package io.github.binout.daiquiri.naming;

import io.github.binout.daiquiri.DaiquiriAnnotations;
import io.github.binout.daiquiri.annotations.MockContext;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class MockInitialContextWithAnnotationsTest {

    @MockContext
    private InitialContext mockContext;

    @Resource(name = "hello")
    private String message = "Hi Daiquiri";

    @BeforeMethod
    public void initAnnotations() {
        DaiquiriAnnotations.init(this);
    }

    @Test
    public void can_use_mock_context_and_resource() throws NamingException {
        Context context = new InitialContext();
        Assert.assertEquals(context.lookup("hello"), message);
    }
}
