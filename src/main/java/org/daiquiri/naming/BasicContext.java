package org.daiquiri.naming;

import javax.naming.*;
import java.util.Hashtable;

public class BasicContext implements Context {


    public BasicContext(Hashtable environment) {
    }

    @Override
    public Object lookup(Name name) throws NamingException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Object lookup(String name) throws NamingException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void bind(Name name, Object obj) throws NamingException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void bind(String name, Object obj) throws NamingException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void rebind(Name name, Object obj) throws NamingException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void rebind(String name, Object obj) throws NamingException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void unbind(Name name) throws NamingException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void unbind(String name) throws NamingException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void rename(Name oldName, Name newName) throws NamingException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void rename(String oldName, String newName) throws NamingException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public NamingEnumeration<NameClassPair> list(Name name) throws NamingException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public NamingEnumeration<NameClassPair> list(String name) throws NamingException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public NamingEnumeration<Binding> listBindings(Name name) throws NamingException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public NamingEnumeration<Binding> listBindings(String name) throws NamingException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void destroySubcontext(Name name) throws NamingException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void destroySubcontext(String name) throws NamingException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Context createSubcontext(Name name) throws NamingException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Context createSubcontext(String name) throws NamingException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Object lookupLink(Name name) throws NamingException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Object lookupLink(String name) throws NamingException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public NameParser getNameParser(Name name) throws NamingException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public NameParser getNameParser(String name) throws NamingException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Name composeName(Name name, Name prefix) throws NamingException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String composeName(String name, String prefix) throws NamingException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Object addToEnvironment(String propName, Object propVal) throws NamingException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Object removeFromEnvironment(String propName) throws NamingException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public Hashtable<?, ?> getEnvironment() throws NamingException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void close() throws NamingException {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public String getNameInNamespace() throws NamingException {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
