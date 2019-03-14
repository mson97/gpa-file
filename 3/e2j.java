public class e2j {

    public static void main(String args[]) {
    	Scan scanner = new Scan();
        SymbolTable table = new SymbolTable();
    	new Parser(scanner, table);
    }
}
