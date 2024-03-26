package base;

import domain.ArticleController;

import java.util.Scanner;

public class BoardApp {
    ArticleController articleController = new ArticleController();
    Scanner scan = new Scanner(System.in);
    public void run(){
        while (true) {
            System.out.print("명령어를 입력해주세요 : ");
            String cmd = scan.nextLine();
            if (cmd.equals("exit")) {
                System.out.println("프로그램이 종료됩니다.");
                break;
            }
            switch (cmd) {
                case "add" -> articleController.add();
                case "list" -> articleController.list();
                case "update" -> articleController.update();
                case "delete" -> articleController.delete();
                case "detail" -> articleController.detail();
                case "search" -> articleController.search();
                default -> System.out.println("올바른 명령어가 아닙니다.");
            }
        }
    }
}
