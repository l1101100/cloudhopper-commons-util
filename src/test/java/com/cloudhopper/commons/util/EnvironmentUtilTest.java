/**
 * Copyright (C) 2011 Twitter, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this
 * file except in compliance with the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed
 * under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package com.cloudhopper.commons.util;

import org.apache.log4j.Logger;
import org.junit.*;

/**
 * Tests FileUtil class.
 * 
 * @author joelauer
 */
public class EnvironmentUtilTest {
    private static final Logger logger = Logger.getLogger(EnvironmentUtilTest.class);

    @Test
    public void splitHostFQDN() throws Exception {
        String[] result = EnvironmentUtil.splitHostFQDN("joelauer-02");
        Assert.assertEquals("joelauer-02", result[0]);
        Assert.assertEquals(null, result[1]);

        result = EnvironmentUtil.splitHostFQDN("joelauer-02.");
        Assert.assertEquals("joelauer-02", result[0]);
        Assert.assertEquals(null, result[1]);

        result = EnvironmentUtil.splitHostFQDN("joelauer-02.c");
        Assert.assertEquals("joelauer-02", result[0]);
        Assert.assertEquals("c", result[1]);

        result = EnvironmentUtil.splitHostFQDN(null);
        Assert.assertEquals(null, result[0]);
        Assert.assertEquals(null, result[1]);

        result = EnvironmentUtil.splitHostFQDN("");
        Assert.assertEquals(null, result[0]);
        Assert.assertEquals(null, result[1]);

        result = EnvironmentUtil.splitHostFQDN(".");
        Assert.assertEquals("", result[0]);
        Assert.assertEquals(null, result[1]);
    }
    
}
