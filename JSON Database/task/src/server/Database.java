package server;

public class Database {

    private String[] cells;
    private static Database instance;

    private Database() {
        cells = new String[100];
        for (String cell : cells) {
            cell = "";
        }
    }

    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    public String handleInput(String[] commands) {
        if (commands[0].equalsIgnoreCase("exit")) {
            System.exit(0);
        }
        if (indexOutOfBounds(Integer.parseInt(commands[1]))) {
            return "ERROR";
        }
        switch (commands[0]) {
            case "get":
                try {
                    return get(Integer.parseInt(commands[1]));
                } catch (Exception e) {
                    return "ERROR";
                }
            case "set":
                return set(Integer.parseInt(commands[1]), buildString(commands));
            case "delete":
                return delete(Integer.parseInt(commands[1]));
            default:
                return "ERROR";
        }
    }

    private String get(int index) throws Exception {
        if (cells[index - 1].equals("") || cells[index - 1] == null) {
            throw new Exception("ERROR");
        }
        return cells[index - 1];
    }

    private String set(int index, String value) {
        cells[index -1] = value;
        return "OK";
    }

    private String delete(int index) {
        cells[index - 1] = "";
        return "OK";
    }

    private boolean indexOutOfBounds(int index) {
        return index < 1 || index > 100;
    }

    private String buildString(String[] commands) {
        StringBuilder result = new StringBuilder();
        for (int i = 2; i < commands.length; i++) {
            result.append(commands[i]);
            result.append(" ");
        }
        result.deleteCharAt(result.length() - 1);
        return result.toString();
    }
}
