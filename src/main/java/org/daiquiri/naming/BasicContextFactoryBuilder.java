package org.daiquiri.naming;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.spi.InitialContextFactory;
import javax.naming.spi.InitialContextFactoryBuilder;
import java.util.Hashtable;

public class BasicContextFactoryBuilder implements InitialContextFactoryBuilder {

    private static BasicContext context;

    public static BasicContext getCurrentContext() {
        if (context == null) {
           throw new IllegalStateException("No current context, you should call new InitialContext()...");
        }
        return context;
    }

    @Override
    public InitialContextFactory createInitialContextFactory(Hashtable<?, ?> environment) throws NamingException {
        return new InitialContextFactory() {
            @Override
            public Context getInitialContext(Hashtable<?, ?> environment) throws NamingException {
                context = new BasicContext(environment);
                return context;
            }
        };
    }
}
