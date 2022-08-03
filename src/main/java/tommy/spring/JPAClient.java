package tommy.spring;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import tommy.spring.domain.Board;

public class JPAClient {
	public static void main(String[] args) {
		//EntityManager 생성
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("ch04");
		EntityManager manager = factory.createEntityManager();
		//트랜잭션 생성
		EntityTransaction tx = manager.getTransaction();
		try {
//			tx.begin();
//			Board board = new Board();
//			board.setTitle("JPA 테스트");
//			board.setWriter("사오정");
//			board.setContent("글 등록 테스트");
//			board.setRegDate(new Date());
//			board.setCnt(0L);
//			//글 등록
//			manager.persist(board);
//			tx.commit();
//			// 글 상세 조회
//			Board searchBoard = manager.find(Board.class, 1L);
//			System.out.println("---> " + searchBoard.toString());
			tx.begin();
			// 삭제할 게시글 조회
			Board deleteBoard = manager.find(Board.class, 1L);
			deleteBoard.setSeq(1L);
			manager.remove(deleteBoard);// 실제 삭제
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			manager.close();
			factory.close();
		}
	}
}
