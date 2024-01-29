package com.mit;


import static org.junit.Assert.assertTrue;

import java.io.IOException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.mit.grpc.DataSafety;
import com.mit.grpc.LoginClient;
import com.mit.grpc.LoginServer;
import com.mit.grpc.MyProperties;
import com.mit.grpc.MyProperties;

/**
 * Unit test for simple App.
 */
// @RunWith(ThreadedRunner.class)
public class AppTest 
{
    /**
     * Rigorous Test :-)
     * @throws InterruptedException 
     * @throws IOException 
     */
    @Test
    // @Parameters
    public void LoginServerTest() throws IOException, InterruptedException
    {
        // assertTrue( true );
        // LoginServer.main(null);
        // MyProperties myProperties = new MyProperties();
        // System.out.println(myProperties);
        DataSafety dataSafety = new DataSafety();
        dataSafety.run();
        

    }

    // @Test
    // public void LoginClientTest(){
    //     LoginClient.main(null);
    }
 
