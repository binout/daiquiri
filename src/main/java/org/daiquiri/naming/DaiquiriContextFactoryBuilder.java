package org.daiquiri.naming;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.spi.InitialContextFactory;
import javax.naming.spi.InitialContextFactoryBuilder;
import java.util.Hashtable;
import java.util.Map;

public class DaiquiriContextFactoryBuilder implements InitialContextFactoryBuilder {

    private Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    @Override
    public InitialContextFactory createInitialContextFactory(Hashtable<?, ?> environment) throws NamingException {
        return new InitialContextFactory() {
            @Override
            public Context getInitialContext(Hashtable<?, ?> environment) throws NamingException {
                for (Map.Entry<?,?> propEntries : environment.entrySet())  {
                    context.addToEnvironment((String)propEntries.getKey(), propEntries.getValue());
                }
                return context;
            }
        };
    }
}
