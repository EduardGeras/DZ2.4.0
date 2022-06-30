public class PossibleErrors {
    private static final String SYMBOLS = "qQwWeErRTtyYuUiIoOpPaAsSDfFgGhHjJkKlLzZcCvVbBnNmM_0123456789";


    private PossibleErrors() {

    }
    public static boolean possibleErrors(String login, String password, String confirmPassword){
        try {
            check(login, password, confirmPassword);
            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e);
            return false;
        }
    }
    private static void check(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        if (login == null || password == null || confirmPassword == null) {
            throw new WrongLoginException("Данные должны быть заполнены");
        }

        if (login.length() > 20) {
            throw new WrongLoginException("Длина логина должна быть меньше или равна 20");
        }

        if (password.length() > 19) {
            throw new WrongPasswordException("Длина пароля должна быть меньше или равна 19");
        }

        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли должны совпадать!");
        }

        for (int i = 0; i < login.length(); i++) {
            if (!SYMBOLS.contains(String.valueOf(login.charAt(i)))) {
                throw new WrongLoginException("Логин содержит неверный символ " + login.charAt(i));
            }
        }
        for (int i = 0; i < password.length(); i++) {
            if (!SYMBOLS.contains(String.valueOf(password.charAt(i)))) {
                throw new WrongPasswordException("Пароль содержит неверный символ " + password.charAt(i));
            }
        }
    }
}
