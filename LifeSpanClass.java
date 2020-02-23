import java.util.*;
import java.util.stream.Collectors;

public class LifeSpanClass {
  //function to return / write years having low population than preceding year
  public static void main(String[] args){
    int[] birthYears = {1902, 1941, 2004, 1957,1989, 1909, 1918, 1913, 1979, 1961, 1977, 1909};
    int[] deathYears = {1991, 1978, 2008, 2005, 2010, 2002, 2003, 1991};
    List<Integer> ListOfLowPopYears = new ArrayList<Integer>(); //defines variable to store list of low population years
    
    //'for' loop to pick death year and verify successive year not having any births
    for(int i=0;i<deathYears.length; i++)
    {
      boolean isLowPPLyear=true;
      for(int j=0;j<birthYears.length;j++)
      {
        if (deathYears[i]+1 == birthYears[j]) 
        /* This condition checks specific year has births or not. If there are births, ignore writing this death year to final list of output*/
        {
          isLowPPLyear = false;
          continue; // break this loop, if this year has births as well.
        }
      }
      if (isLowPPLyear)
      ListOfLowPopYears.add(deathYears[i]+1);
    }
    List<Integer> finalList = ListOfLowPopYears.stream() 
                                      .distinct()
                                      .sorted()
                                      .collect(Collectors.toList());
    System.out.println("List of low population years are: "+finalList);
    }
  }