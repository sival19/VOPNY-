/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vop;

import org.junit.*;

import java.io.File;
import java.net.URISyntaxException;
import static org.junit.Assert.*;

/**
 *
 * @author fsan
 */
public class FacadeWithCallbackTest {

    FacadeWithCallback facade;
    CallBackInterface soutCallBack;
    Dice dice;

    public FacadeWithCallbackTest() {
    }

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {

    }

    @Before
    public void setUp() throws URISyntaxException {
        soutCallBack = new CallBackInterface() {
            @Override
            public void updateMessage(String message) {
                System.out.println(message);
            }

            @Override
            public void updateImages(File i1, File i2) {
                System.out.println("Pics: " + i1.getName() + " " + i2.getName());

            }
        };
        facade = new FacadeWithCallback(soutCallBack);
        facade.start();
        dice = facade.getDice();




//        TODO
//        Instantiate your CallBackInterface
//        Instantiate and start your Facade Thread
    }

    @After
    public void tearDown() {
        facade.interrupt();
//        TODO
//        Interrupt your facade Thread
    }

    /**
     * Test of run method, of class FacadeWithCallback.
     */

    @Test
    public void testRun() {
        try {
            facade.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        assertTrue(dice.equalsMax());
//        TODO
//        Test the run() method
//        Assert if the dice.getDie1() and dice.getDie2() are equal to integer 6
    }

}
