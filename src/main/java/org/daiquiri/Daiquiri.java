package org.daiquiri;

import org.daiquiri.naming.BasicContext;
import org.daiquiri.naming.BasicContextFactoryBuilder;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.spi.NamingManager;

public class Daiquiri {

    public static class Naming {

        private static BasicContextFactoryBuilder builder;

        public static Context mockInitialContext() throws NamingException {
            if (builder == null) {
                if (NamingManager.hasInitialContextFactoryBuilder()) {
                    throw new IllegalStateException("Cannot mock InitialContext because a JNDI provider is already registered.");
                }
                builder = new BasicContextFactoryBuilder();
                NamingManager.setInitialContextFactoryBuilder(builder);
            }
            BasicContext context = new BasicContext();
            builder.setContext(context);
            return context;
        }
    }
}
