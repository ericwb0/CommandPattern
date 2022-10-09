import java.util.ArrayList;

/**
 * Document class
 * @author Eric Burkholder and <OTHER NAME HERE>
 */
public class Document {
    private String fileName;
    private ArrayList<String> lines;
    /**
     * The number of spaces between lines and edge "|" char. This variable can be tuned to
     * change the margin of the document when viewed. Set to 5 per requirement.
     */
    private final int STR_PADDING = 5;

    /**
     * Constructor. Creates an arraylist from the file's lines with FileManipulator.
     * @param fileName the name of the target file
     */
    public Document(String fileName) {
        this.fileName = fileName;
        lines = FileManipulator.readFile(fileName);
    }

    /**
     * Creates a String representation of the document complete with margins, top, and bottom edges
     * @return a String representation of the document to view
     */
    public String view() {
        // Variables to improve readability
        // Store longest length of a line because getLongestLength would need to be called twice
        int longestLength = getLongestLength();

        // Using String.format(%<-length>s, str) pads str with spaces on the right to get to length
        String rightPadFormat = "%" + (-1*(longestLength + STR_PADDING)) + "s";

        // Left margin is just | with " " for the padding
        String leftMargin = "|" + " ".repeat(STR_PADDING);
        int totalWidth = longestLength + 2*(STR_PADDING+1); // Total width, excluding endline

        // Top/bottom edge is just "_" repeated totalWidth times, with endline at the end
        String edge = "_".repeat(totalWidth) + "\n";

        /* 
         * The number of chars in the sequence will be the width * num lines.
         * totalWidth+1 to include \n char, lines.size is the num of lines from the document.
         * Add 3 to the lines for the 2 edges and the top spacing.
         * We do this to pre-set the capacity to avoid a bunch of capacity increase operations.
         */
        StringBuilder viewStr = new StringBuilder((totalWidth+1)*(lines.size()+3));

        // Add top edge with an extra empty line at the top
        viewStr.append(edge).append("\n");

        // This operation adds "|     " + "<line>     " + "|\n" to the string
        for(String line : lines)
            viewStr.append(leftMargin).append(String.format(rightPadFormat, line)).append("|\n");
        viewStr.append(edge);
        return viewStr.toString();
    }

    public String append(String line) {

        return "";
    }

    public String write(String line) {
        
        return "";
    }

    public String save() {
        
        return "";
    }

    /**
     * Helper method. Finds the longest line's length
     * @return the length of the longest line in the file
     */
    private int getLongestLength() {
        int length = 0;
        for(String line : lines)
            if(line.length() > length) length = line.length();
        return length;
    }
}
