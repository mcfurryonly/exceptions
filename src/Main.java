public class Main {
    public static void main(String[] args) {
        try {
            check("login22_login","pass", "pass");
        } catch (WrongPasswordException | WrongLoginException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Логин выполнен!");
    }
    private static void check(String login, String password, String confirmPassword) throws WrongPasswordException, WrongLoginException {
        if (!login.matches("[a-zA-Z0-9_]+")) {
            throw new WrongLoginException("В логине содержатся недопустимые символы");
        }
        if (login.length() > 20) {
            throw new WrongLoginException("Логин не удовлетворяет требованиям");
        }
        if  (!password.matches("[a-zA-Z0-9_]+")) {
            throw new WrongLoginException("В пароле содержатся недопустимые символы");
        }
        if (password.length() >= 20 || !password.equals(confirmPassword)) {
            throw new WrongPasswordException();
        }
    }
}