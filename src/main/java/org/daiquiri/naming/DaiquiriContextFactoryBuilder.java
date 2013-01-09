package org.daiquiri.naming;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.spi.InitialContextFactory;
import javax.naming.spi.InitialContextFactoryBuilder;
import java.util.Hashtable;

public class DaiquiriContextFactoryBuilder implements InitialContextFactoryBuilder {

    private DaiquiriContext context;

    public void setContext(DaiquiriContext context) {
        this.context = context;
    }

    @Override
    public InitialContextFactory createInitialContextFactory(Hashtable<?, ?> environment) throws NamingException {
        return new InitialContextFactory() {
            @Override
            public Context getInitialContext(Hashtable<?, ?> environment) throws NamingException {
                context.setEnvironment(environment);
                return context;
            }
        };
    }
}
