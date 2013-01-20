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
package org.daiquiri;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Cocktail {

    private boolean shaken;
    private boolean empty;

    public Cocktail() {
        shaken = false;
        empty = false;
    }

    public boolean isShaken() {
        return shaken;
    }

    public boolean isEmpty() {
        return empty;
    }

    @PostConstruct
    public void init() {
        shaken = true;
    }

    @PreDestroy
    public void destroy() {
        empty = true;
    }
}