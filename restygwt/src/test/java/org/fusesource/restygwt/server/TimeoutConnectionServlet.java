/**
 * Copyright (C) 2009-2012 the original author or authors.
 * See the notice.md file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.fusesource.restygwt.server;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * Super simple servlet that simply does nothing to check if
 * timeout management is okay.
 *
 * @author <a href="mailto:mail@raphaelbauer.com">rEyez</<a>
 *
 */
public class TimeoutConnectionServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    private static final Logger log = Logger.getLogger(TimeoutConnectionServlet.class.getName());
    
    //5 seconds timeout:
    long TIMEOUT = 100000;

    String DUMMY_RESPONSE = "{\"name\":\"myName\"}";


    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws IOException {


            //here comes the timeout:
            log.fine("before true" + System.currentTimeMillis());

            //NON BLOCKING WAIT:
            long beforeLoop = System.currentTimeMillis();

            while (true) {
                long now = System.currentTimeMillis();

                if ((now - beforeLoop) > 10000) {
                    break;
                }
            }


            log.fine("afer true" + System.currentTimeMillis());

            response.getWriter().print(DUMMY_RESPONSE);

    }

}