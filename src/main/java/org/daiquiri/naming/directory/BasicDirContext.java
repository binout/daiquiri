package org.daiquiri.naming.directory;

import org.daiquiri.naming.BasicInitialContext;

import javax.naming.Name;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.*;

public class BasicDirContext extends BasicInitialContext implements DirContext {

    @Override
    public Attributes getAttributes(Name name) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.directory.BasicDirContext");
    }

    @Override
    public Attributes getAttributes(String name) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.directory.BasicDirContext");
    }

    @Override
    public Attributes getAttributes(Name name, String[] attrIds) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.directory.BasicDirContext");
    }

    @Override
    public Attributes getAttributes(String name, String[] attrIds) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.directory.BasicDirContext");
    }

    @Override
    public void modifyAttributes(Name name, int mod_op, Attributes attrs) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.directory.BasicDirContext");
    }

    @Override
    public void modifyAttributes(String name, int mod_op, Attributes attrs) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.directory.BasicDirContext");
    }

    @Override
    public void modifyAttributes(Name name, ModificationItem[] mods) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.directory.BasicDirContext");
    }

    @Override
    public void modifyAttributes(String name, ModificationItem[] mods) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.directory.BasicDirContext");
    }

    @Override
    public void bind(Name name, Object obj, Attributes attrs) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.directory.BasicDirContext");
    }

    @Override
    public void bind(String name, Object obj, Attributes attrs) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.directory.BasicDirContext");
    }

    @Override
    public void rebind(Name name, Object obj, Attributes attrs) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.directory.BasicDirContext");
    }

    @Override
    public void rebind(String name, Object obj, Attributes attrs) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.directory.BasicDirContext");
    }

    @Override
    public DirContext createSubcontext(Name name, Attributes attrs) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.directory.BasicDirContext");
    }

    @Override
    public DirContext createSubcontext(String name, Attributes attrs) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.directory.BasicDirContext");
    }

    @Override
    public DirContext getSchema(Name name) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.directory.BasicDirContext");
    }

    @Override
    public DirContext getSchema(String name) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.directory.BasicDirContext");
    }

    @Override
    public DirContext getSchemaClassDefinition(Name name) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.directory.BasicDirContext");
    }

    @Override
    public DirContext getSchemaClassDefinition(String name) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.directory.BasicDirContext");
    }

    @Override
    public NamingEnumeration<SearchResult> search(Name name, Attributes matchingAttributes, String[] attributesToReturn) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.directory.BasicDirContext");
    }

    @Override
    public NamingEnumeration<SearchResult> search(String name, Attributes matchingAttributes, String[] attributesToReturn) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.directory.BasicDirContext");
    }

    @Override
    public NamingEnumeration<SearchResult> search(Name name, Attributes matchingAttributes) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.directory.BasicDirContext");
    }

    @Override
    public NamingEnumeration<SearchResult> search(String name, Attributes matchingAttributes) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.directory.BasicDirContext");
    }

    @Override
    public NamingEnumeration<SearchResult> search(Name name, String filter, SearchControls cons) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.directory.BasicDirContext");
    }

    @Override
    public NamingEnumeration<SearchResult> search(String name, String filter, SearchControls cons) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.directory.BasicDirContext");
    }

    @Override
    public NamingEnumeration<SearchResult> search(Name name, String filterExpr, Object[] filterArgs, SearchControls cons) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.directory.BasicDirContext");
    }

    @Override
    public NamingEnumeration<SearchResult> search(String name, String filterExpr, Object[] filterArgs, SearchControls cons) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.directory.BasicDirContext");
    }
}
