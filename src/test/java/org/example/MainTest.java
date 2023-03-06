package org.example;

import junit.framework.Test;
import junit.framework.TestSuite;

import static junit.framework.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class MainTest
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public MainTest(String testName )
    {
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( MainTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testMain()
    {
        assertTrue( true );
    }
}
