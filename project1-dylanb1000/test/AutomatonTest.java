import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.jupiter.api.Test;

class AutomatonTest {

	@Test
	void testConstructor() {
		Automaton eca = new Automaton(22, new Generation(false, true, false));
		assertEquals(22, eca.getRuleNum());
		assertArrayEquals(new boolean[] {false, true, false}, 
				eca.getGeneration(0).getStates());
		assertEquals(0, eca.getTotalSteps());
		assertEquals("010", eca.toString());
	}

	@Test
	void testEvolve() {
		
		Automaton eca = new Automaton(22, new Generation("000000010000000", '1'));
		eca.evolve(1);
		assertEquals(1, eca.getTotalSteps());
		String evolution = 
				"000000010000000" + System.lineSeparator() + 
				"000000111000000";
		assertEquals(evolution, eca.toString());
		
		eca.evolve(2);
		assertEquals(3, eca.getTotalSteps());
		eca.falseSymbol = '_';
		eca.trueSymbol = '%';
		evolution = 
				"_______%_______" + System.lineSeparator() + 
				"______%%%______" + System.lineSeparator() + 
				"_____%___%_____" + System.lineSeparator() + 
				"____%%%_%%%____";
		assertEquals(evolution, eca.toString());
		
		Generation gen = eca.getGeneration(7);
		assertEquals("OOO.OOO.OOO.OOO", gen.getStates('.', 'O'));
		assertEquals(7, eca.getTotalSteps());
		eca.falseSymbol = '.';
		eca.trueSymbol = 'O';
		evolution = 
				".......O......." + System.lineSeparator() + 
				"......OOO......" + System.lineSeparator() + 
				".....O...O....." + System.lineSeparator() + 
				"....OOO.OOO...." + System.lineSeparator() + 
				"...O.......O..." + System.lineSeparator() + 
				"..OOO.....OOO.." + System.lineSeparator() + 
				".O...O...O...O." + System.lineSeparator() + 
				"OOO.OOO.OOO.OOO";
		assertEquals(evolution, eca.toString());
		
		eca = new Automaton(60, new Generation("000100010001000", '1'));
		eca.evolve(5);
		assertEquals(5, eca.getTotalSteps());
		eca.falseSymbol = '0';
		eca.trueSymbol = '1';
		evolution="000100010001000"+ System.lineSeparator() + 
				"000110011001100"+ System.lineSeparator() + 
				"000101010101010"+ System.lineSeparator() + 
				"000111111111111"+ System.lineSeparator() + 
				"100100000000000"+ System.lineSeparator() + 
				"110110000000000";
		assertEquals(evolution, eca.toString());
		
		
	}
	@Test
	void testFileConstructor() throws IOException{
		String filename = "Generations/Test.txt";
		String filename2="Generations/rule22-63cells-input.txt";
		
		Automaton test=new Automaton(filename);
		Automaton testCompare=new Automaton(22,new Generation("000000010000000",'1'));
		assertEquals(test.toString(), testCompare.toString());
		
		test=new Automaton(filename2);
		testCompare=new Automaton(22,new Generation("...............................#...............................",'#'));
		assertEquals(test.toString(), testCompare.toString());
	}
	@Test 
	void testSaveFile() throws IOException {
		String filename = "FinishedGenerations/Test.txt";
		Automaton eca = new Automaton(22, new Generation("000000010000000", '1'));
		eca.evolve(7);
		eca.falseSymbol = '.';
		eca.trueSymbol = 'O';
		String evolution = 
				".......O......." + System.lineSeparator() + 
				"......OOO......" + System.lineSeparator() + 
				".....O...O....." + System.lineSeparator() + 
				"....OOO.OOO...." + System.lineSeparator() + 
				"...O.......O..." + System.lineSeparator() + 
				"..OOO.....OOO.." + System.lineSeparator() + 
				".O...O...O...O." + System.lineSeparator() + 
				"OOO.OOO.OOO.OOO";
		
		assertEquals(evolution,eca.toString());
		eca.saveEvolution(filename);
		String[] expectedLines= {evolution};
		assertTrue(checkFile(expectedLines, filename));
		
		
		String filename2 = "FinishedGenerations/rule22-63cells-31steps.txt";
		eca = new Automaton(22,new Generation("...............................#...............................",'#'));
		eca.evolve(31);
		eca.falseSymbol = '.';
		eca.trueSymbol = '#';
		evolution = 
		"...............................#..............................."+ System.lineSeparator() + 
		"..............................###.............................."+ System.lineSeparator() + 
		".............................#...#............................."+ System.lineSeparator() + 
		"............................###.###............................"+ System.lineSeparator() + 
		"...........................#.......#..........................."+ System.lineSeparator() + 
		"..........................###.....###.........................."+ System.lineSeparator() + 
		".........................#...#...#...#........................."+ System.lineSeparator() + 
		"........................###.###.###.###........................"+ System.lineSeparator() + 
		".......................#...............#......................."+ System.lineSeparator() + 
		"......................###.............###......................"+ System.lineSeparator() + 
		".....................#...#...........#...#....................."+ System.lineSeparator() + 
		"....................###.###.........###.###...................."+ System.lineSeparator() + 
		"...................#.......#.......#.......#..................."+ System.lineSeparator() + 
		"..................###.....###.....###.....###.................."+ System.lineSeparator() + 
		".................#...#...#...#...#...#...#...#................."+ System.lineSeparator() + 
		"................###.###.###.###.###.###.###.###................"+ System.lineSeparator() + 
		"...............#...............................#..............."+ System.lineSeparator() + 
		"..............###.............................###.............."+ System.lineSeparator() + 
		".............#...#...........................#...#............."+ System.lineSeparator() + 
		"............###.###.........................###.###............"+ System.lineSeparator() + 
		"...........#.......#.......................#.......#..........."+ System.lineSeparator() + 
		"..........###.....###.....................###.....###.........."+ System.lineSeparator() + 
		".........#...#...#...#...................#...#...#...#........."+ System.lineSeparator() + 
		"........###.###.###.###.................###.###.###.###........"+ System.lineSeparator() + 
		".......#...............#...............#...............#......."+ System.lineSeparator() + 
		"......###.............###.............###.............###......"+ System.lineSeparator() + 
		".....#...#...........#...#...........#...#...........#...#....."+ System.lineSeparator() + 
		"....###.###.........###.###.........###.###.........###.###...."+ System.lineSeparator() + 
		"...#.......#.......#.......#.......#.......#.......#.......#..."+ System.lineSeparator() + 
		"..###.....###.....###.....###.....###.....###.....###.....###.."+ System.lineSeparator() + 
		".#...#...#...#...#...#...#...#...#...#...#...#...#...#...#...#."+ System.lineSeparator() + 
		"###.###.###.###.###.###.###.###.###.###.###.###.###.###.###.###";
		
		assertEquals(evolution,eca.toString());
		eca.saveEvolution(filename2);
		String[] expectedLines2= {evolution};
		assertTrue(checkFile(expectedLines2, filename2));
	}
	// Define a helper method that checks the lines of a text file.
		private static boolean checkFile(String[] expectedLines, String filename) 
				throws IOException {
			
			BufferedReader reader = new BufferedReader(new FileReader(filename));
			String content="";
			String actual="";
			while((content=reader.readLine())!=null) {
			actual = actual + content;
			actual= actual + System.lineSeparator();
			}
			// Return false if any of the lines don't match.
			for (String expected : expectedLines) {
				expected=expected+System.lineSeparator();
				if (actual == null || !expected.equals(actual)) {
					reader.close();
					return false;
				}
			}
			
			reader.close();
			return true;
		}

}
