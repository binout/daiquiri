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

import org.daiquiri.naming.BasicInitialContext;

import javax.naming.Name;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.*;

public class BasicInitialDirContext extends BasicInitialContext implements DirContext {

    @Override
    public Attributes getAttributes(Name name) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.directory.BasicInitialDirContext");
    }

    @Override
    public Attributes getAttributes(String name) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.directory.BasicInitialDirContext");
    }

    @Override
    public Attributes getAttributes(Name name, String[] attrIds) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.directory.BasicInitialDirContext");
    }

    @Override
    public Attributes getAttributes(String name, String[] attrIds) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.directory.BasicInitialDirContext");
    }

    @Override
    public void modifyAttributes(Name name, int mod_op, Attributes attrs) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.directory.BasicInitialDirContext");
    }

    @Override
    public void modifyAttributes(String name, int mod_op, Attributes attrs) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.directory.BasicInitialDirContext");
    }

    @Override
    public void modifyAttributes(Name name, ModificationItem[] mods) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.directory.BasicInitialDirContext");
    }

    @Override
    public void modifyAttributes(String name, ModificationItem[] mods) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.directory.BasicInitialDirContext");
    }

    @Override
    public void bind(Name name, Object obj, Attributes attrs) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.directory.BasicInitialDirContext");
    }

    @Override
    public void bind(String name, Object obj, Attributes attrs) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.directory.BasicInitialDirContext");
    }

    @Override
    public void rebind(Name name, Object obj, Attributes attrs) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.directory.BasicInitialDirContext");
    }

    @Override
    public void rebind(String name, Object obj, Attributes attrs) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.directory.BasicInitialDirContext");
    }

    @Override
    public DirContext createSubcontext(Name name, Attributes attrs) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.directory.BasicInitialDirContext");
    }

    @Override
    public DirContext createSubcontext(String name, Attributes attrs) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.directory.BasicInitialDirContext");
    }

    @Override
    public DirContext getSchema(Name name) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.directory.BasicInitialDirContext");
    }

    @Override
    public DirContext getSchema(String name) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.directory.BasicInitialDirContext");
    }

    @Override
    public DirContext getSchemaClassDefinition(Name name) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.directory.BasicInitialDirContext");
    }

    @Override
    public DirContext getSchemaClassDefinition(String name) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.directory.BasicInitialDirContext");
    }

    @Override
    public NamingEnumeration<SearchResult> search(Name name, Attributes matchingAttributes, String[] attributesToReturn) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.directory.BasicInitialDirContext");
    }

    @Override
    public NamingEnumeration<SearchResult> search(String name, Attributes matchingAttributes, String[] attributesToReturn) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.directory.BasicInitialDirContext");
    }

    @Override
    public NamingEnumeration<SearchResult> search(Name name, Attributes matchingAttributes) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.directory.BasicInitialDirContext");
    }

    @Override
    public NamingEnumeration<SearchResult> search(String name, Attributes matchingAttributes) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.directory.BasicInitialDirContext");
    }

    @Override
    public NamingEnumeration<SearchResult> search(Name name, String filter, SearchControls cons) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.directory.BasicInitialDirContext");
    }

    @Override
    public NamingEnumeration<SearchResult> search(String name, String filter, SearchControls cons) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.directory.BasicInitialDirContext");
    }

    @Override
    public NamingEnumeration<SearchResult> search(Name name, String filterExpr, Object[] filterArgs, SearchControls cons) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.directory.BasicInitialDirContext");
    }

    @Override
    public NamingEnumeration<SearchResult> search(String name, String filterExpr, Object[] filterArgs, SearchControls cons) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.directory.BasicInitialDirContext");
    }
}
