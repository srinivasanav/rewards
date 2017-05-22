package com.rewards.test;


import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.rewards.DressBase;

public class DressTest {
  @Test
  public void testSuccessHot() throws Exception {
	  DressBase object = new DressBase();
    String output = object.getDressed("HOT 8, 6, 4, 2, 1, 7");
    assertEquals("Removing PJs, shorts, shirt, sunglasses, sandals, leaving house", output);
  }
 
  @Test
  public void testSuccessCold() throws Exception {
	  DressBase object = new DressBase();
    String output = object.getDressed("COLD 8, 6, 3, 4, 2, 5, 1, 7");
    assertEquals("Removing PJs, pants, socks, shirt, hat, jacket, boots, leaving house", output);
  } 
  
  @Test
  public void testFailureHot() throws Exception {
	  DressBase object = new DressBase();
    String output = object.getDressed("HOT 8, 6, 6");
    assertEquals("Removing PJs, shorts, fail", output);
  }  
  
  @Test
  public void testFailureCold() throws Exception {
	  DressBase object = new DressBase();
    String output = object.getDressed("COLD 8, 6, 3, 4, 2, 5, 7");
    assertEquals("Removing PJs, pants, socks, shirt, hat, jacket, fail", output);
  }    
}