package domain;

import java.util.ArrayList;

public class ArticleView {
    public void printArticlelist(ArrayList<Article> targetlist) {
        System.out.println("================");
        for (int i = 0; i < targetlist.size(); i++) {
            Article article = targetlist.get(i);
            System.out.println("번호 : " + article.getId());
            System.out.printf("제목 : %s\n", article.getTitle());
            System.out.println("================");
        }
    }
    public void printArticledetail(Article article) {
        System.out.println("=====================");
        System.out.println("번호 : " + article.getId());
        System.out.println("제목 : " + article.getTitle());
        System.out.println("내용 : " + article.getBody());
        System.out.println("생성날짜 : " + article.getRegDate());
        System.out.println("조회수 : " + article.getHit());
        System.out.println("=====================");
    }
}
