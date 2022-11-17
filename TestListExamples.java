import static org.junit.Assert.*;
import org.junit.*;

public class TestListExamples {
    // Write your grading tests here!

  @Test 
  public void test1(){
    List testlist1= new ArrayList<>(); 
    testlist1.add("music");
    testlist1.add("for");
    testlist1.add("a");
    testlist1.add("sushi");
    testlist1.add("restaurant");

    StringChecker st = new greaterThan5();

    List expected= new ArrayList<>();
    expected.add("music");
    expected.add("sushi");
    expected.add("restaurant");
    
    List actual= ListExamples.filter(testlist1, st);
    assertEquals(expected, actual);
  }
