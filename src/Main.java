public class Main {
    public static void main(String[] args) throws WrongLoginException, WrongPasswordException{
        boolean data = PossibleErrors.possibleErrors(new String[]{"java_skypro.go"},
                new String[]{"D_1hWiKjjP_9"},
                new String[]{"D_1hWiKjjP_9"});
        if (data) {
            System.out.println("Логин и пароль корректные");
        } else {
            System.out.println("Ой! Что-то пошло не так :(");
        }
    }
}