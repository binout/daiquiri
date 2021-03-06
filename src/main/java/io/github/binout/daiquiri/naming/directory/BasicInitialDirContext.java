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

import io.github.binout.daiquiri.naming.BasicContext;

import javax.naming.*;
import javax.naming.directory.*;
import java.util.Hashtable;

public class BasicInitialDirContext extends InitialDirContext {

    private BasicContext context;

    public BasicInitialDirContext() throws  NamingException {
        context = new BasicContext();
    }

    public BasicInitialDirContext(Hashtable<String, Object> environment) throws  NamingException {
        context = new BasicContext(environment);
    }

    @Override
    public Object lookup(Name name) throws NamingException {
        return context.lookup(name);
    }

    @Override
    public Object lookup(String name) throws NamingException {
        return context.lookup(name);
    }

    @Override
    public void bind(Name name, Object obj) throws NamingException {
        context.bind(name, obj);
    }

    @Override
    public void bind(String name, Object obj) throws NamingException {
        context.bind(name, obj);
    }

    @Override
    public void rebind(Name name, Object obj) throws NamingException {
        context.rebind(name, obj);
    }

    @Override
    public void rebind(String name, Object obj) throws NamingException {
        context.rebind(name, obj);
    }

    @Override
    public void unbind(Name name) throws NamingException {
        context.unbind(name);
    }

    @Override
    public void unbind(String name) throws NamingException {
        context.unbind(name);
    }

    @Override
    public void rename(Name oldName, Name newName) throws NamingException {
        context.rename(oldName, newName);
    }

    @Override
    public void rename(String oldName, String newName) throws NamingException {
        context.rename(oldName, newName);
    }

    @Override
    public NamingEnumeration<NameClassPair> list(Name name) throws NamingException {
        return context.list(name);
    }

    @Override
    public NamingEnumeration<NameClassPair> list(String name) throws NamingException {
        return context.list(name);
    }

    @Override
    public NamingEnumeration<Binding> listBindings(Name name) throws NamingException {
        return context.listBindings(name);
    }

    @Override
    public NamingEnumeration<Binding> listBindings(String name) throws NamingException {
        return context.listBindings(name);
    }

    @Override
    public void destroySubcontext(Name name) throws NamingException {
        context.destroySubcontext(name);
    }

    @Override
    public void destroySubcontext(String name) throws NamingException {
        context.destroySubcontext(name);
    }

    @Override
    public Context createSubcontext(Name name) throws NamingException {
        return context.createSubcontext(name);
    }

    @Override
    public Context createSubcontext(String name) throws NamingException {
        return context.createSubcontext(name);
    }

    @Override
    public Object lookupLink(Name name) throws NamingException {
        return context.lookupLink(name);
    }

    @Override
    public Object lookupLink(String name) throws NamingException {
        return context.lookupLink(name);
    }

    @Override
    public NameParser getNameParser(Name name) throws NamingException {
        return context.getNameParser(name);
    }

    @Override
    public NameParser getNameParser(String name) throws NamingException {
        return context.getNameParser(name);
    }

    @Override
    public Name composeName(Name name, Name prefix) throws NamingException {
        return context.composeName(name, prefix);
    }

    @Override
    public String composeName(String name, String prefix) throws NamingException {
        return context.composeName(name, prefix);
    }

    @Override
    public Object addToEnvironment(String propName, Object propVal) throws NamingException {
        return context.addToEnvironment(propName, propVal);
    }

    @Override
    public Object removeFromEnvironment(String propName) throws NamingException {
        return context.removeFromEnvironment(propName);
    }

    @Override
    public Hashtable<?, ?> getEnvironment() throws NamingException {
        return context.getEnvironment();
    }

    @Override
    public void close() throws NamingException {
        context.close();
    }

    @Override
    public String getNameInNamespace() throws NamingException {
        return context.getNameInNamespace();
    }

    @Override
    public Attributes getAttributes(Name name) throws NamingException {
        throw new UnsupportedOperationException("Not supported by io.github.binout.daiquiri.naming.directory.BasicInitialDirContext");
    }

    @Override
    public Attributes getAttributes(String name) throws NamingException {
        throw new UnsupportedOperationException("Not supported by io.github.binout.daiquiri.naming.directory.BasicInitialDirContext");
    }

    @Override
    public Attributes getAttributes(Name name, String[] attrIds) throws NamingException {
        throw new UnsupportedOperationException("Not supported by io.github.binout.daiquiri.naming.directory.BasicInitialDirContext");
    }

    @Override
    public Attributes getAttributes(String name, String[] attrIds) throws NamingException {
        throw new UnsupportedOperationException("Not supported by io.github.binout.daiquiri.naming.directory.BasicInitialDirContext");
    }

    @Override
    public void modifyAttributes(Name name, int mod_op, Attributes attrs) throws NamingException {
        throw new UnsupportedOperationException("Not supported by io.github.binout.daiquiri.naming.directory.BasicInitialDirContext");
    }

    @Override
    public void modifyAttributes(String name, int mod_op, Attributes attrs) throws NamingException {
        throw new UnsupportedOperationException("Not supported by io.github.binout.daiquiri.naming.directory.BasicInitialDirContext");
    }

    @Override
    public void modifyAttributes(Name name, ModificationItem[] mods) throws NamingException {
        throw new UnsupportedOperationException("Not supported by io.github.binout.daiquiri.naming.directory.BasicInitialDirContext");
    }

    @Override
    public void modifyAttributes(String name, ModificationItem[] mods) throws NamingException {
        throw new UnsupportedOperationException("Not supported by io.github.binout.daiquiri.naming.directory.BasicInitialDirContext");
    }

    @Override
    public void bind(Name name, Object obj, Attributes attrs) throws NamingException {
        throw new UnsupportedOperationException("Not supported by io.github.binout.daiquiri.naming.directory.BasicInitialDirContext");
    }

    @Override
    public void bind(String name, Object obj, Attributes attrs) throws NamingException {
        throw new UnsupportedOperationException("Not supported by io.github.binout.daiquiri.naming.directory.BasicInitialDirContext");
    }

    @Override
    public void rebind(Name name, Object obj, Attributes attrs) throws NamingException {
        throw new UnsupportedOperationException("Not supported by io.github.binout.daiquiri.naming.directory.BasicInitialDirContext");
    }

    @Override
    public void rebind(String name, Object obj, Attributes attrs) throws NamingException {
        throw new UnsupportedOperationException("Not supported by io.github.binout.daiquiri.naming.directory.BasicInitialDirContext");
    }

    @Override
    public DirContext createSubcontext(Name name, Attributes attrs) throws NamingException {
        throw new UnsupportedOperationException("Not supported by io.github.binout.daiquiri.naming.directory.BasicInitialDirContext");
    }

    @Override
    public DirContext createSubcontext(String name, Attributes attrs) throws NamingException {
        throw new UnsupportedOperationException("Not supported by io.github.binout.daiquiri.naming.directory.BasicInitialDirContext");
    }

    @Override
    public DirContext getSchema(Name name) throws NamingException {
        throw new UnsupportedOperationException("Not supported by io.github.binout.daiquiri.naming.directory.BasicInitialDirContext");
    }

    @Override
    public DirContext getSchema(String name) throws NamingException {
        throw new UnsupportedOperationException("Not supported by io.github.binout.daiquiri.naming.directory.BasicInitialDirContext");
    }

    @Override
    public DirContext getSchemaClassDefinition(Name name) throws NamingException {
        throw new UnsupportedOperationException("Not supported by io.github.binout.daiquiri.naming.directory.BasicInitialDirContext");
    }

    @Override
    public DirContext getSchemaClassDefinition(String name) throws NamingException {
        throw new UnsupportedOperationException("Not supported by io.github.binout.daiquiri.naming.directory.BasicInitialDirContext");
    }

    @Override
    public NamingEnumeration<SearchResult> search(Name name, Attributes matchingAttributes, String[] attributesToReturn) throws NamingException {
        throw new UnsupportedOperationException("Not supported by io.github.binout.daiquiri.naming.directory.BasicInitialDirContext");
    }

    @Override
    public NamingEnumeration<SearchResult> search(String name, Attributes matchingAttributes, String[] attributesToReturn) throws NamingException {
        throw new UnsupportedOperationException("Not supported by io.github.binout.daiquiri.naming.directory.BasicInitialDirContext");
    }

    @Override
    public NamingEnumeration<SearchResult> search(Name name, Attributes matchingAttributes) throws NamingException {
        throw new UnsupportedOperationException("Not supported by io.github.binout.daiquiri.naming.directory.BasicInitialDirContext");
    }

    @Override
    public NamingEnumeration<SearchResult> search(String name, Attributes matchingAttributes) throws NamingException {
        throw new UnsupportedOperationException("Not supported by io.github.binout.daiquiri.naming.directory.BasicInitialDirContext");
    }

    @Override
    public NamingEnumeration<SearchResult> search(Name name, String filter, SearchControls cons) throws NamingException {
        throw new UnsupportedOperationException("Not supported by io.github.binout.daiquiri.naming.directory.BasicInitialDirContext");
    }

    @Override
    public NamingEnumeration<SearchResult> search(String name, String filter, SearchControls cons) throws NamingException {
        throw new UnsupportedOperationException("Not supported by io.github.binout.daiquiri.naming.directory.BasicInitialDirContext");
    }

    @Override
    public NamingEnumeration<SearchResult> search(Name name, String filterExpr, Object[] filterArgs, SearchControls cons) throws NamingException {
        throw new UnsupportedOperationException("Not supported by io.github.binout.daiquiri.naming.directory.BasicInitialDirContext");
    }

    @Override
    public NamingEnumeration<SearchResult> search(String name, String filterExpr, Object[] filterArgs, SearchControls cons) throws NamingException {
        throw new UnsupportedOperationException("Not supported by io.github.binout.daiquiri.naming.directory.BasicInitialDirContext");
    }
}
