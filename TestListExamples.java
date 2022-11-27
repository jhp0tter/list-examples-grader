import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.*;

class greaterThan3 implements StringChecker{
    public boolean checkString(String s) {
      return s.length()>3;
    }
}

class lesserThan5 implements StringChecker{
  public boolean checkString(String s) {
    return s.length()<5;
  } 
}

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

  @Test 
  public void test2(){
    List testlist2= new ArrayList<>(); 
    testlist2.add("music");
    testlist2.add("for");
    testlist2.add("a");
    testlist2.add("sushi");
    testlist2.add("restaurant");

    StringChecker st = new lesserThan5();

    List expected= new ArrayList<>();
    expected.add("for");
    expected.add("a");
    
    
    List actual= ListExamples.filter(testlist2, st);
    assertEquals(expected, actual);
  }
}
