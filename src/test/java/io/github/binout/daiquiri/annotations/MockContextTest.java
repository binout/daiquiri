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
package io.github.binout.daiquiri.annotations;

import io.github.binout.daiquiri.DaiquiriAnnotations;
import io.github.binout.daiquiri.exceptions.DaiquiriException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.naming.InitialContext;

public class MockContextTest {

    @MockContext
    InitialContext context;

    @MockContext
    @Mock
    InitialContext contextWithMockito;

    @Test
    public void initMockContextAnnotation() throws DaiquiriException {
        DaiquiriAnnotations.init(this);
        Assert.assertNotNull(context);
    }

    @Test
    public void initMockContextAnnotation_UsingMockito() throws DaiquiriException {
        MockitoAnnotations.initMocks(this);
        DaiquiriAnnotations.init(this);
        Assert.assertNotNull(contextWithMockito);
        Assert.assertTrue(contextWithMockito.toString().contains("Mockito"));
    }
}
