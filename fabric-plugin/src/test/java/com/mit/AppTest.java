package com.mit;


import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import com.mit.grpc.DataSafety;
import com.mit.grpc.LoginServer;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     * @throws InterruptedException 
     * @throws IOException 
     */
    @Test
    public void shouldAnswerWithTrue() throws IOException, InterruptedException
    {
        assertTrue( true );

        // DataSafety dataSafety = new DataSafety();
        // dataSafety.run();
        LoginServer.main(null);
    }
}
