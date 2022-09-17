package controller;

public class MainController {
    public static void main(String[] args) {
        HomeController h = new HomeController();
        do {
           h.showmenu();
           h.handleChoice();
        }while (true);
    }
}
