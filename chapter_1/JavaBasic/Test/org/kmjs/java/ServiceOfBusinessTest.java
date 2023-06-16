package org.kmjs.java;

import org.junit.Test;

import static org.junit.Assert.*;

public class ServiceOfBusinessTest {
    String code = "Hello World";
    ServiceOfBusiness service = new ServiceOfBusiness(code, false);
    @Test
    public void testPrintMethods() {
        assertEquals(code, service.printServerCode());
        assertFalse(service.printFlag());
    }


}