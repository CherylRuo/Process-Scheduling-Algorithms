/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Adrian
 */
public class Hw2Test
{
    
    public Hw2Test()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of runFCFS method, of class Hw2.
     */
    @Test
    public void testRunFCFS()
    {               
        /* Test 1 */
        
        Hw2.clearData();
        
        Process p1 = new Process("P1", 0.0f, 3.0f, 1);
        Process p2 = new Process("P2", 1.0f, 2.0f, 1);
        Process p3 = new Process("P3", 2.0f, 1.0f, 1);
        
        Hw2.processQueue.add(p1);
        Hw2.processQueue.add(p2);
        Hw2.processQueue.add(p3);
        
        Hw2.runFCFS(6);
        
        float avgTurnaroundTime = Hw2.getAvgTurnaroundTime();
        float avgWaitingTime = Hw2.getAvgWaitingTime();
        float avgResponseTime = Hw2.getAvgResponseTime();
        int throughput = Hw2.throughput;
        
        assertEquals(3.67f, avgTurnaroundTime, 0.01);
        assertEquals(1.67f, avgWaitingTime, 0.01);
        assertEquals(1.67f, avgResponseTime, 0.01);
        assertEquals(3, throughput, 0.01);
    }
    
    /**
     * Test of runSJF method, of class Hw2.
     */
    @Test
    public void testRunSJF()
    {     
        /* Test1 */
        
        Hw2.clearData();
        
        Process p1 = new Process("P1", 0f, 3f, 1);
        Process p2 = new Process("P2", 1f, 4f, 1);
        Process p3 = new Process("P3", 2f, 2f, 1);
        Process p4 = new Process("P4", 4f, 1f, 1);
        Process p5 = new Process("P5", 6f, 2f, 1);
        Process p6 = new Process("P6", 8f, 1f, 1);
        
        Hw2.processQueue.add(p1);
        Hw2.processQueue.add(p2);
        Hw2.processQueue.add(p3);
        Hw2.processQueue.add(p4);
        Hw2.processQueue.add(p5);
        Hw2.processQueue.add(p6);
        
        Hw2.runSJF(13);
        
        float avgTurnaroundTime = Hw2.getAvgTurnaroundTime();
        float avgWaitingTime = Hw2.getAvgWaitingTime();
        float avgResponseTime = Hw2.getAvgResponseTime();
        int throughput = Hw2.throughput;
        
        assertEquals(3.83f, avgTurnaroundTime, 0.01);
        assertEquals(1.67f, avgWaitingTime, 0.01);
        assertEquals(1.67f, avgResponseTime, 0.01);
        assertEquals(6, throughput, 0.01);
    }
    
    @Test
    public void runSRT()
    {
        /* Test1 */
        
        Hw2.clearData();
        
        Process p1 = new Process("P1", 0.0f, 6.0f, 1);
        Process p2 = new Process("P2", 1.0f, 3.0f, 1);
        Process p3 = new Process("P3", 2.0f, 4.0f, 1);
        Process p4 = new Process("P4", 2.0f, 2.0f, 1);
        
        Hw2.processQueue.add(p1);
        Hw2.processQueue.add(p2);
        Hw2.processQueue.add(p3);
        Hw2.processQueue.add(p4);
        
        Hw2.runSRT(15);
        
        float avgTurnaroundTime = Hw2.getAvgTurnaroundTime();
        float avgWaitingTime = Hw2.getAvgWaitingTime();
        float avgResponseTime = Hw2.getAvgResponseTime();
        int throughput = Hw2.throughput;
        
        assertEquals(7.5f, avgTurnaroundTime, 0.01);
        assertEquals(3.75f, avgWaitingTime, 0.01);
        assertEquals(1.0f, avgResponseTime, 0.01);
        assertEquals(4, throughput, 0.01);
    }
    @Test
    public void testRunRR()
    {
        /* Test4 */ 
        Hw2.clearData();
        
        Process p1 = new Process("P1", 0f, 3f, 1);
        Process p2 = new Process("P2", 2f, 4f, 1);
        Process p3 = new Process("P3", 4f, 2f, 1);
        Process p4 = new Process("P4", 7f, 2f, 1);
        Process p5 = new Process("P5", 9f, 2f, 1);
        Hw2.processQueue.add(p1);
        Hw2.processQueue.add(p2);
        Hw2.processQueue.add(p3);
        Hw2.processQueue.add(p4);
        Hw2.processQueue.add(p5);
        
        Hw2.runRR(13);
        
        float avgTurnaroundTime = Hw2.getAvgTurnaroundTime();
        float avgWaitingTime = Hw2.getAvgWaitingTime();
        float avgResponseTime = Hw2.getAvgResponseTime();
        int throughput = Hw2.throughput;
        
        assertEquals(4.40f, avgTurnaroundTime, 0.01);
        assertEquals(2.40f, avgWaitingTime, 0.01);
        assertEquals(1.60f, avgResponseTime, 0.01);
        assertEquals(5, throughput, 0.01);                       
    }
    
    /**
     * Test of generateProcesses method, of class Hw2.
     */
    @Test
    public void testGenerateProcesses()
    {
        Hw2.generateProcesses();
        Process currentp;
        for (int i = 0; i < Hw2.processQueue.size(); i++)
        {
            currentp = Hw2.processQueue.poll();
            if (currentp.arrivalTime < 0 || currentp.arrivalTime > 99)
                fail();
            if (currentp.expectedTotalRuntime < 0.1 || currentp.expectedTotalRuntime > 10)
                fail();
            if (currentp.priority < 1 || currentp.priority > 4)
                fail();
        }
    }

    /**
     * Test of printProcessQueue method, of class Hw2.
     */
    @Test
    public void testPrintProcessQueue()
    {
        
    }

    /**
     * Test of getAvgTurnaroundTime method, of class Hw2.
     */
    @Test
    public void testGetAvgTurnaroundTime()
    {
        
    }

    /**
     * Test of getAvgWaitingTime method, of class Hw2.
     */
    @Test
    public void testGetAvgWaitingTime()
    {
        
    }

    /**
     * Test of getAvgResponseTime method, of class Hw2.
     */
    @Test
    public void testGetAvgResponseTime()
    {
        
    }
}
