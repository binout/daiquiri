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
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.naming.NamingException;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;

public class BasicInitialDirContextTest {

    private InitialDirContext mockContext;

    @Test
    public void init_mock_dir_context() throws NamingException {
        mockContext = Daiquiri.Naming.mockInitialDirContext();
        Assert.assertNotNull(mockContext);
        Assert.assertTrue(mockContext instanceof BasicInitialDirContext);
    }
}
