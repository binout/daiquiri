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

import io.github.binout.daiquiri.exceptions.DaiquiriException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AnnotationUtilsTest {

    @Test
    public void can_instantiate() throws DaiquiriException {
        String s = AnnotationUtils.newInstance(String.class);
        Assert.assertNotNull(s);
        Assert.assertEquals("", s);
    }

    @Test
    public void can_instantiate_with_param() throws DaiquiriException {
        String s = AnnotationUtils.newInstance(String.class, "toto");
        Assert.assertNotNull(s);
        Assert.assertEquals("toto", s);
    }
}
