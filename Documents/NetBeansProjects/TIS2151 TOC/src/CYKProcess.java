import java.io.*;
import java.util.*;

public class CYKProcess
{
	// word is the string need to be checked
	public static String word;
	// the symbol the grammar start
	public static String startingSymbol;
	// end is the terminal elements
	public static ArrayList<String> end = new ArrayList<String>();
	// notEnd is the non terminal elements
	public static ArrayList<String> notEnd = new ArrayList<String>();
	// grammar is a dictionary contain the procedure
	public static TreeMap<String,ArrayList<String>> grammar = new TreeMap<>();
	
	// public static void main(String[] args)
	// -------------> start from here <-------------
	public static void wholeProcess()
	{
		String filename = "grammar.txt";
		// get the information from the txt file and assign it to the variable
		declaration(filename);
		// create a table for cyk
        String[][] cykTable = createCYKTable();
		insertCykTable(cykTable);
		printResultCMD(cykTable);
	}
	
    public static void declaration(String filename)
	{
		// load fail contain grammar in CNF
        Scanner input = openFile(filename);
		// create a temperature arraylist
        ArrayList<String> temp = new ArrayList<>();
		// take line 1 as word
		word = input.nextLine();
		startingSymbol = input.next();
        input.nextLine();
        int line = 2;

        while(input.hasNextLine() && line <= 3)
		{
			// adding terminal and non-terminal elements to end and notEnd arrayList
            temp.addAll(Arrays.<String>asList(toArray(input.nextLine())));
            if(line == 2){ 
				end.addAll(temp); 
			}
            if(line == 3){
				notEnd.addAll(temp); 
			}
			temp.clear();
            line++;
        }
		
		// adding the procedure to grammar
        while(input.hasNextLine())
		{
            temp.addAll(Arrays.<String>asList(toArray(input.nextLine())));
			// define the symbol as the key of treemap
            String keySymbol = temp.get(0);
            temp.remove(0);
            grammar.put(keySymbol, new ArrayList<String>());
            grammar.get(keySymbol).addAll(temp);
            temp.clear();
        }
		// close the file
        input.close();
    }
	 
	public static String[][] createCYKTable()
	{
        int length = word.length();
        String[][] cykTable = new String[length + 1][];
        cykTable[0] = new String[length];
		
		// create cyk table 
        for(int i = 1; i < cykTable.length; i++)
		{
            cykTable[i] = new String[length - (i - 1)];
        }
		// and initialize them to empty string
        for(int i = 1; i < cykTable.length; i++)
		{
            for(int j = 0; j < cykTable[i].length; j++)
			{
                cykTable[i][j] = "";
            }
        }
		// Note : row 0 is the word input by the user
        return cykTable;
    }

    public static String[][] insertCykTable(String[][] cykTable)
	{
		// S 1 : insert row 0
		// Note : row 0 is the word input by the user
        for(int i = 0; i < cykTable[0].length; i++)
		{
            cykTable[0][i] = Character.toString(word.charAt(i));
        }
		//S 2 : insert row 1 from dictionary
        for(int i = 0; i < cykTable[1].length; i++)
		{
            String[] validCombinations = checkDictionary(new String[] {cykTable[0][i]});
            cykTable[1][i] = toString(validCombinations);
        }
		// if the word is less than or equal to 1, stop here and return the cyktable
        if(word.length() <= 1) 
		{ 
			return cykTable; 
		}
		//S 3 : insert row 2 from valid combinations according to the dictionary
        for(int i = 0; i < cykTable[2].length; i++)
		{
            String[] upwards = toArray(cykTable[1][i]);
            String[] diagonals = toArray(cykTable[1][i+1]);
            String[] validCombinations = checkDictionary(getAllCombinations(upwards, diagonals));
            cykTable[2][i] = toString(validCombinations);
        }
		// if the word is less than or equal to 2, stop here and return the cyktable
        if(word.length() <= 2)
		{
			return cykTable; 
		}
		//S 4: insert remaining tow from valid combinations according to the dictionary
        TreeSet<String> currentValues = new TreeSet<String>();
		
		// for each row
        for(int i = 3; i < cykTable.length; i++)
		{
			// for each column
            for(int j = 0; j < cykTable[i].length; j++)
			{
				// for each possible combinations
                for(int from = 1; from < i; from++)
				{
                    String[] upwards = cykTable[from][j].split("\\s");
                    String[] diagonals = cykTable[i-from][j+from].split("\\s");
                    String[] combinations = getAllCombinations(upwards, diagonals);
                    String[] validCombinations = checkDictionary(combinations);
					// add the valid combinations to cyktable if that cell is empty
                    if(cykTable[i][j].isEmpty())
					{
                        cykTable[i][j] = toString(validCombinations);
                    }
					else // add valid combination behind the exist string
					{
                        String[] old = toArray(cykTable[i][j]);
                        ArrayList<String> tempValue = new ArrayList<String>(Arrays.asList(old));
                        tempValue.addAll(Arrays.asList(validCombinations));
						// add all the element from tempValue arrayList to currentValues
                        currentValues.addAll(tempValue);
						// insert currentValues to cyktable
                        cykTable[i][j] = toString(currentValues.toArray(new String[currentValues.size()]));
                    }
                }
                currentValues.clear();
            }
        }
        return cykTable;
    }
	
	public static void printResultCMD (String[][] cykTable)
	{
        System.out.println("Word: " + word);
        System.out.println("\nG = (" + end.toString().replace("[", "{").replace("]", "}") 
                          + ", " + notEnd.toString().replace("[", "{").replace("]", "}")
                          + ", P, " + startingSymbol + ")");
		System.out.println("\nProduction P shown below : ");
        for(String keySymbols: grammar.keySet())
		{
            System.out.println(keySymbols + " --> " + grammar.get(keySymbols).toString().replaceAll("[\\[\\]\\,]", "").replaceAll("\\s", " | "));
        }
        System.out.println("\n\nAfter applying CYK algorithm :\n");
        displayTable(cykTable);
    }

    public static void displayTable(String[][] cykTable)
	{
        int longest = detectLongestStringLength(cykTable) + 2;
        String formatString = "| %-" + longest + "s ";
        String s = "";
        StringBuilder sb = new StringBuilder();
		//Construct Table Structure
		// eg: +
        sb.append("+");
        for(int x = 0; x <= longest + 2; x++)
		{
			// eg: -----+
            if(x == longest + 2)
			{ 
                sb.append("+");
            }
			else
			{
                sb.append("-");
            }
        }
		// eg: +----+
        String low = sb.toString();
        sb.delete(0, 1);
		// eg: ----+
        String lowRight = sb.toString();
		//Print Table
        for(int i = 0; i < cykTable.length; i++)
		{
            for(int j = 0; j <= cykTable[i].length; j++)
			{
                System.out.print((j == 0) ? low : (i <= 1 && j == cykTable[i].length - 1) ? "" : lowRight);
            }
            System.out.println();
            for(int j = 0; j < cykTable[i].length; j++)
			{
                s = (cykTable[i][j].isEmpty()) ? "-" : cykTable[i][j];
                System.out.format(formatString, s.replaceAll("\\s", ","));
                if(j == cykTable[i].length - 1) 
				{
					System.out.print("|");
				}
            }
            System.out.println();
        }
        System.out.println(low+"\n");
		//S 4 : Evaluate success.
        if(cykTable[cykTable.length-1][cykTable[cykTable.length-1].length-1].contains(startingSymbol)){
            System.out.println("The word \"" + word + "\" is an element of the CFG G and can be derived from it.");
        }else{
            System.out.println("The word \"" + word + "\" is not an element of the CFG G and can not be derived from it.");
        }
    }
	
    public static int detectLongestStringLength(String[][] cykTable)
	{
		// x store the longest length of data in the table
        int x = 0;
		// check every data
        for(String[] s : cykTable)
		{
            for(String data : s)
			{
				// replace it when detect more longer data
                if(data.length() > x)
				{ 
					x = data.length();
				}
            }
        }
        return x;
    }
	
    public static String[] checkDictionary(String[] check)
	{
        ArrayList<String> storage = new ArrayList<>();
		// get the key from grammar
        for(String keySymb : grammar.keySet())
		{
			// current  is the word array
            for(String current : check)
			{
				// contains method return true if specific element listed
				// if the element in current listed in certain value of grammar,  add the key to storage 
                if(grammar.get(keySymb).contains(current))
				{
                    storage.add(keySymb);
                }
            }
        }
		// if there are no key in the storage, return empty String array
        if(storage.size() == 0)
		{
			return new String[] {}; 
		}
        return storage.toArray(new String[storage.size()]);
    }

	public static String[] getAllCombinations(String[] from, String[] to)
	{
		// calculate the number of possible combinations
        int length = from.length * to.length;
		// create a temperary string array to store all the combination
        String[] combinations = new String[length];
		// counter act as the index of String array above
        int counter = 0;
        // return empty string array if there are no combination
		if(length == 0)
		{
			return combinations;
		}
		// store all the combination to the combinations string array
        for(int i = 0; i < from.length; i++){
            for(int j = 0; j < to.length; j++){
                combinations[counter] = from[i] + to[j];
                counter++;
            }
        }
        return combinations;
    }

    public static String toString(String[] arrayToString)
	{
        return Arrays.toString(arrayToString).replaceAll("[\\[\\]\\,]", "");
    }

    public static String[] toArray(String input)
	{
        return input.split("\\s");
    }
	 
    public static Scanner openFile(String filename)
	{
        try{
            return new Scanner(new File(filename));
        }catch(FileNotFoundException e){
            System.out.println("Error: Can't find or open the file: " + filename + ".");
            System.exit(1);
            return null;
        }
    }

/*
save the txt file  as the filename shown below for testing purpose
*/	
/*
grammar.txt(txt start from below)
00100111
S
0 1
S A B C
S SS BA BC
A SC
B 0
C 1
*/

/*
grammar1.txt(txt start from below)
01011100
S
0 1
S A B C
S SS BA BC
A SC
B 0
C 1
*/

/*
grammar2.txt(txt start from below)
aaabbbcc
S
a b c
S A B C D E F
S AB
A CD CF
B c EB
C a
D b
E c
F AD
*/
	
}