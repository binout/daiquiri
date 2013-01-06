package org.daiquiri.naming;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.spi.InitialContextFactory;
import javax.naming.spi.InitialContextFactoryBuilder;
import java.util.Hashtable;

public class BasicContextFactoryBuilder implements InitialContextFactoryBuilder {

    private BasicContext context;

    public void setContext(BasicContext context) {
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
