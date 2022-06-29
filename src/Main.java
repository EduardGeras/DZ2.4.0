public class Main {
    public static void main(String[] args){
        boolean data = PossibleErrors.possibleErrors("java_skypro_go", "D_1hWiKjjP_9", "D_1hWiKjjP_9");
        if (data) {
            System.out.println("Логин и пароль корректные");
        } else {
            System.out.println("Ой! Что-то пошло не так :(");
        }
    }
}