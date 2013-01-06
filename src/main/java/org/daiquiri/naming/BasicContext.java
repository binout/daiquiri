package org.daiquiri.naming;

import javax.naming.*;
import java.util.Hashtable;

public class BasicContext implements Context {

    private Hashtable<String, Object> environment;
    private Hashtable<String, Object> namedObjects;

    public BasicContext() {
        this(new Hashtable<String, Object>()) ;
    }

    public BasicContext(Hashtable environment) {
        setEnvironment(environment);
        this.namedObjects = new Hashtable<String, Object>();
    }

    public void setEnvironment(Hashtable environment) {
        this.environment = environment;
    }

    @Override
    public Object lookup(Name name) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.BasicContext");
    }

    @Override
    public Object lookup(String name) throws NamingException {
        if (!namedObjects.containsKey(name)) {
             throw new NameNotFoundException("No entry for :" + name);
        }
        return namedObjects.get(name);
    }

    @Override
    public void bind(Name name, Object obj) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.BasicContext");
    }

    @Override
    public void bind(String name, Object obj) throws NamingException {
        namedObjects.put(name, obj);
    }

    @Override
    public void rebind(Name name, Object obj) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.BasicContext");
    }

    @Override
    public void rebind(String name, Object obj) throws NamingException {
        namedObjects.put(name, obj);
    }

    @Override
    public void unbind(Name name) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.BasicContext");
    }

    @Override
    public void unbind(String name) throws NamingException {
        namedObjects.remove(name);
    }

    @Override
    public void rename(Name oldName, Name newName) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.BasicContext");
    }

    @Override
    public void rename(String oldName, String newName) throws NamingException {
        Object found = lookup(oldName);
        unbind(oldName);
        bind(newName, found);
    }

    @Override
    public NamingEnumeration<NameClassPair> list(Name name) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.BasicContext");
    }

    @Override
    public NamingEnumeration<NameClassPair> list(String name) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.BasicContext");
    }

    @Override
    public NamingEnumeration<Binding> listBindings(Name name) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.BasicContext");
    }

    @Override
    public NamingEnumeration<Binding> listBindings(String name) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.BasicContext");
    }

    @Override
    public void destroySubcontext(Name name) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.BasicContext");
    }

    @Override
    public void destroySubcontext(String name) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.BasicContext");
    }

    @Override
    public Context createSubcontext(Name name) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.BasicContext");
    }

    @Override
    public Context createSubcontext(String name) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.BasicContext");
    }

    @Override
    public Object lookupLink(Name name) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.BasicContext");
    }

    @Override
    public Object lookupLink(String name) throws NamingException {
        return lookup(name);
    }

    @Override
    public NameParser getNameParser(Name name) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.BasicContext");
    }

    @Override
    public NameParser getNameParser(String name) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.BasicContext");
    }

    @Override
    public Name composeName(Name name, Name prefix) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.BasicContext");
    }

    @Override
    public String composeName(String name, String prefix) throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.BasicContext");
    }

    @Override
    public Object addToEnvironment(String propName, Object propVal) throws NamingException {
        return environment.put(propName, propVal);
    }

    @Override
    public Object removeFromEnvironment(String propName) throws NamingException {
        return environment.remove(propName);
    }

    @Override
    public Hashtable<?, ?> getEnvironment() throws NamingException {
        return environment;
    }

    @Override
    public void close() throws NamingException {
        namedObjects.clear();
    }

    @Override
    public String getNameInNamespace() throws NamingException {
        throw new UnsupportedOperationException("Not supported by org.daiquiri.naming.BasicContext");
    }

}
