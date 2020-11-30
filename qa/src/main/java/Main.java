import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Main {

  public static int i = 0;

  @BeforeTest
  public void setupTest(){
    i = 1;
  }

  @Test
  public void doSimpleTest(){
    Assert.assertEquals(i, 1);
  }

  @Test
  public void testIsEven(){
    Assert.assertEquals(isEven(7), false);
    Assert.assertEquals(isEven(8), true);
  }

  public static boolean isEven(int j){
    return j % 2 == 0;
  }

  @Test
  public void testExtractGetParamValueFound() {
    Assert.assertEquals(extractGetParam("http://localhost:1234?abc=123", "abc"),
            "123");
  }

  @Test
  public void testExtractGetParamMissingKey() {
    Assert.assertEquals(extractGetParam("http://localhost:1234?abcd=123", "abc"),
            null);
  }

  @Test
  public void testExtractGetParamMultipleParams(){
    Assert.assertEquals(extractGetParam("http://localhost:1234?abcd=123&b=4", "abc"),
            "123");

  }

  public static String extractGetParam(String url, String key) {
    String[] parts = url.split(":");
    System.out.println(parts[2]);
    String[] portParts = parts[2].split("\\?");
    System.out.println(portParts[1]);
    String[] keyValueParts = portParts[1].split("=");
    if(keyValueParts[0].equals(key)) {
      return keyValueParts[1];
    }
    return null;
  }

}
