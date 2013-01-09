package org.daiquiri.naming;

import javax.naming.Context;
import java.util.Hashtable;

public interface DaiquiriContext extends Context{

    void setEnvironment(Hashtable environment);
}
