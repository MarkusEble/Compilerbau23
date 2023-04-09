package compiler;

import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * provide input string as stream
 */
public class InputReader implements Cloneable {
	private String input;
	private int pos = 0;

	public InputReader(String input) {
		this.input = input;
	}

	public char currentChar() {
		if (this.pos != this.input.length()) {
			return this.input.charAt(this.pos);
		}
		return 0;
	}

	public char lookAheadChar() {
	    return currentChar();
	}

	public void advance() {
		if (this.pos != this.input.length()) {
			this.pos++;
		}
		// skip \r in \r\n
		if (this.pos + 1 < this.input.length()
				&& this.input.charAt(this.pos) == '\r'
				&& this.input.charAt(this.pos + 1) == '\n') {
		    this.pos++;
		}
	}

    public void expect(char c) throws Exception {
        if (this.currentChar() != c) {
            throw new Exception(String.format("unexpected character: '%c' expected: '%c'", this.currentChar(), c));
        }
        this.advance();
    }

    public void traceState(OutputStreamWriter outStream) throws Exception {
		for (int i = 0; i != this.input.length(); i++) {
			if (i < this.pos) {
				// blank already processed characters
			    outStream.write(' ');
			} else {
				// print remaining characters
				outStream.write(this.input.charAt(i));
			}
		}
	}

	public void traceBlank(OutputStreamWriter outStream) throws Exception {
		for (int i = 0; i != this.input.length(); i++) {
 	        outStream.write(' ');
		}
	}

	public void traceHead(OutputStreamWriter outStream) throws Exception {
		outStream.write("IN");
		for (int i = 2; i < this.input.length(); i++) {
 	        outStream.write(' ');
		}
	}

	public Object clone() throws CloneNotSupportedException {
		final InputReader theClone = (InputReader)super.clone();
		theClone.input = this.input;
		theClone.pos = this.pos;
		return theClone;
	}

	public static String fileToString(String fileName) throws Exception {
		Path filePath = Paths.get(fileName);
		return Files.readAllBytes(filePath).toString();
	}

}

