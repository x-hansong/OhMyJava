/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.    
 */
package calculator;

import junit.framework.TestCase;

import org.apache.tuscany.sca.host.embedded.SCADomain;

/**
 * This shows how to test the Calculator service component.
 */
public class CalculatorTestCase extends TestCase {

    private SCADomain scaDomain;
    private CalculatorService calculatorService;

    @Override
    protected void setUp() throws Exception {
        System.out.println(System.getProperty("user.dir"));
        scaDomain = SCADomain.newInstance("Calculator.composite");
        calculatorService = scaDomain.getService(CalculatorService.class, "CalculatorComponent");
    }

    @Override
    protected void tearDown() throws Exception {
        scaDomain.close();
    }

    public void testCalculator() throws Exception {
        // Calculate
        System.out.println( "Adding 3 + 2 = " + calculatorService.add(3, 2));
        assertEquals(calculatorService.add(3, 2), 5.0);
        System.out.println( "Subtracting 3 - 2 = " + calculatorService.subtract(3, 2));
        assertEquals(calculatorService.subtract(3, 2), 1.0);
        System.out.println( "Multiplying 3 * 2 = " + calculatorService.multiply(3, 2));
        assertEquals(calculatorService.multiply(3, 2), 6.0);
        System.out.println( "Dividing 3 / 2 = " + calculatorService.divide(3, 2));
        assertEquals(calculatorService.divide(3, 2), 1.5);

    }
}
