
/**
 * Write a description of class Map here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Map
{
    // instance variables - replace the example below with your own
    
    

    

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public static void main()
    {
       StringBuffer mappingRooms = new StringBuffer
        ("                                              [   A    ]                                                   \n" +   
         "         [   B    ]                               |                                [   C   ]              \n" +   
         "             |                                    |                                     |                  \n" +     
         "             |                                [   D    ]                                |                   \n" +   
         "             |                                    |                                     |                   \n" +   
         "          [   E    ]--------------------[   F    ] ------------------- [   G    ]                \n" +   
         "             |                                    |                                     |                    \n" +
         "             |                                    |                                     |                     \n" +   
         "             |                                    |                                     |                     \n" +
         "         [   H    ] ------------------- [   I    ] ------------------- [   J    ]                 \n\n\n\n");




        System.out.println(mappingRooms);
        
        System.out.println(mappingRooms.indexOf("A"));
        System.out.println(mappingRooms.indexOf("B"));
        System.out.println(mappingRooms.indexOf("C"));
        System.out.println(mappingRooms.indexOf("D"));
        System.out.println(mappingRooms.indexOf("E"));
        System.out.println(mappingRooms.indexOf("F"));
        System.out.println(mappingRooms.indexOf("G"));
        System.out.println(mappingRooms.indexOf("H"));
        System.out.println(mappingRooms.indexOf("I"));
        System.out.println(mappingRooms.indexOf("J"));
        
       
       StringBuffer map = new StringBuffer
        ("                                              [       ]                                                   \n" +   
         "          [       ]                               |                               [       ]              \n" +   
         "             |                                    |                                   |                  \n" +     
         "             |                                [       ]                               |                   \n" +   
         "             |                                    |                                   |                   \n" +   
         "          [       ]--------------------[       ] ------------------- [       ]                \n" +   
         "             |                                    |                                   |                    \n" +
         "             |                                    |                                   |                     \n" +   
         "             |                                    |                                   |                     \n" +
         "          [       ] ------------------- [       ] ------------------- [       ]                 \n\n\n\n");

         
        map.setCharAt(211, 'X');
        System.out.println(map);
        map.setCharAt(211, ' ');
         
        map.setCharAt(577, 'X');
        System.out.println(map);
        map.setCharAt(211, ' ');
        
    }
}
