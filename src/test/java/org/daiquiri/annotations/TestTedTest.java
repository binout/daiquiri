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
package org.daiquiri.annotations;

import org.daiquiri.Cocktail;
import org.daiquiri.Daiquiri;
import org.daiquiri.exceptions.DaiquiriException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestTedTest {

    @Tested
    private Cocktail cocktail;

    @Tested(postConstruct = true)
    private Cocktail cocktailWithPostConstruct;

    @Test
    public void initTestedAnnotation() throws DaiquiriException {
        Daiquiri.initAnnotations(this);
        Assert.assertNotNull(cocktail);
        Assert.assertFalse(cocktail.isShaken());
    }

    @Test
    public void initTestedAnnotationWithPostConstruct() throws DaiquiriException {
        Daiquiri.initAnnotations(this);
        Assert.assertNotNull(cocktailWithPostConstruct);
        Assert.assertTrue(cocktailWithPostConstruct.isShaken());
    }
}
