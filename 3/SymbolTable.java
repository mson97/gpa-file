import java.util.HashMap;
import java.util.Stack;

public class SymbolTable {

    Stack<HashMap<String, String>> table; // symbol table is stack (each scope) of hashmaps containing key-value pairs of string-string (each variable)
    int curr_scope;

    public SymbolTable() {
        table = new Stack<HashMap<String, String>>();
        curr_scope = 0;
    }

    public void exit_scope() {
        table.pop();
        curr_scope--;
    }

    public void enter_scope() {
        table.push(new HashMap<String, String>());
        curr_scope++;
    }

    public void declare(String id) {
        if (table.elementAt(curr_scope).containsKey(id)) {
            print_error("Redclaration of variable.");
        } else {
            table.elementAt(curr_scope).put(id, null);
        }
    }

    public void assign(String id, String value) {
        if (table.elementAt(curr_scope).containsKey(id)) {
            table.elementAt(curr_scope).put(id, value);
        } else {
            print_error("Nondeclared variable.");
            System.exit(1);
        }
    }

    public boolean locate(String id, int scope) {
        if (table.elementAt(scope).containsKey(id)) {
            return true;
        } else {
            print_error("Variable not found in scope.");
            return false;
        }
    }

    private void print_error(String msg) {
        System.err.println("Symbol table error: " + msg );
    }

}
