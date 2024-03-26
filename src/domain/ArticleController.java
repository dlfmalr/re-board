package domain;

import base.CommonUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class ArticleController {
    CommonUtil commonUtil = new CommonUtil();
    ArticleRepository articleRepository = new ArticleRepository();
    ArticleView articleView = new ArticleView();
    Scanner scan = commonUtil.getScanner();
    int WRONG_VALUE = -1;

    public void add() {
        System.out.print("제목을 입력해주세요 : ");
        String title = scan.nextLine();
        System.out.print("내용을 입력해주세요 : ");
        String body = scan.nextLine();
        articleRepository.saveArticle(title, body);
        System.out.println("게시물이 저장되었습니다.");
    }
    public void list() {
        ArrayList<Article> articlelist = articleRepository.findAll();
        articleView.printArticlelist(articlelist);
    }
    private int getparamId(String pram, int defaultValue) {
        try {
            return Integer.parseInt(pram);
        }catch (NumberFormatException e) {
            System.out.println("숫자를 입력해주세요.");
            return defaultValue;
        }
    }
    public void update() {
        System.out.print("수정할 게시물 번호를 입력해주세요 : ");

        int inputId = getparamId(scan.nextLine(), WRONG_VALUE);
        if(inputId == WRONG_VALUE) {
            return;
        }
        Article article = articleRepository.findId(inputId);
        if (article == null) {
            System.out.println("없는 게시물 번호 입니다.");
            return;
        }

        System.out.print("새로운 번호를 입력해주세요 : ");
        String newtitle = scan.nextLine();
        System.out.print("새로운 내용을 입력해주세요 : ");
        String newbody = scan.nextLine();
        articleRepository.updateArticle(article, newtitle, newbody);
        System.out.println("게시물이 수정되었습니다.");
    }
    public void delete() {
        System.out.print("삭제할 번호를 입력해주세요 : ");

        int inputId = getparamId(scan.nextLine(), WRONG_VALUE);
        if (inputId == WRONG_VALUE) {
            return;
        }
        Article article = articleRepository.findId(inputId);
        if (article == null) {
            System.out.println("없는 게시물 번호입니다.");
            return;
        }

        articleRepository.deleteArticle(article);
        System.out.printf("%d번 게시물이 삭제되었습니다.\n", inputId);
    }
    public void detail() {
        System.out.print("상세보기할 게시물 번호를 입력해주세요 : ");

        int inputId = getparamId(scan.nextLine(), WRONG_VALUE);
        if (inputId == WRONG_VALUE) {
            return;
        }
        Article article = articleRepository.findId(inputId);
        if (article == null) {
            System.out.println("없는 게시물 번호입니다.");
            return;
        }

        article.increaseHit();
        articleView.printArticledetail(article);
    }
    public void search() {
        System.out.print("검색 키워드를 입력해주세요 : ");
        String keyword = scan.nextLine();
        ArrayList<Article> searchlist = articleRepository.findkeyword(keyword);
        articleView.printArticlelist(searchlist);
    }
}
