class Database {
    public void connect() {
        System.out.println("Database connecting...");
    }
}

class SystemBoot {
    public void startUp() {
        new Database().connect();
    }
}

class UserRequest {
    public void handle() {
        new Database().connect();
    }
}
