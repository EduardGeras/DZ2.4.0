public class PossibleErrors {
    private static final String[] symbols = {"q", "Q", "w", "W", "e", "E", "r", "R", "T", "t", "y", "Y", "u", "U", "i", "I",
            "o", "O", "p", "P", "a", "A", "s" , "S", "d", "D", "f", "F", "g", "G", "h", "H", "j", "J", "k", "K", "l", "L",
            "z", "Z", "c", "C", "v", "V", "b", "B", "n", "N", "m", "M", "_", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};


    public static boolean possibleErrors(String[] login, String[] password, String[] confirmPassword) throws WrongLoginException, WrongPasswordException{
        try {
            check(String.valueOf(login), String.valueOf(password), String.valueOf(confirmPassword));
            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e);
            return false;
        }
    }
    private static void check(String login, String password, String confirmPassword) throws WrongLoginException, WrongPasswordException {
        for (int i = 0; i < symbols.length; i++) {
            if (login != null && login.contains(symbols[i]) && login.length() > 20) {
                throw new WrongLoginException("Длина логина должна быть меньше или равна 20");
            }
        }
        for (int i = 0; i < symbols.length; i++) {
            if (password != null && password.contains(symbols[i]) && password.length() > 19) {
                throw new WrongPasswordException("Длина пароля должна быть меньше или равна 19");
            }
        }
        for (int i = 0; i < symbols.length; i++) {
            if (login != null && password != null && password.equals(symbols[i]) != confirmPassword.equals(symbols[i])) {
                throw new WrongPasswordException("Пароли должны совпадать!");
            }
        }
        for (int i = 0; i < login.length(); i++)
            if (!login.contains(symbols[i])) {
                throw new WrongLoginException("Логин содержит неверный символ");
            }
    }
}
