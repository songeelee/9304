package book.mvc.view;

import java.util.ArrayList;
import java.util.Scanner;

import book.mvc.controller.BookController;
import book.mvc.model.vo.Book;

public class BookMenu {
	private static Scanner sc = new Scanner(System.in);

	public static void displalyMenu() {
		BookController bc = new BookController();
		do {
			System.out.println("*** 도서 관리 프로그램 ***");
			System.out.println("1. 도서 추가");
			System.out.println("2. 도서 정보 수정");
			System.out.println("3. 도서 삭제");
			System.out.println("4. 도서 아이디로 조회");
			System.out.println("5. 도서 제목으로 조회");
			System.out.println("6. 도서 목록 전체 조회");
			System.out.println("9. 끝내기");
			System.out.println("번호 선택 : ");
			int no = sc.nextInt();
			switch (no) {
			case 1:
				bc.insertBook(inputb());
				break;
			case 2:
				bc.updateBook(inputb());
				break;
			case 3:
				bc.deleteBook(inputbId());
				break;
			case 4:
				bc.selectBookId(inputbId());
				break;
			case 5:
				bc.selectBookTitle(inputbTitle());
				break;
			case 6:
				bc.selectAll();
				break;
			case 9:
				System.out.println("도서 관리 프로그램을 종료합니다. ");
				return;
			default:
				System.out.println("잘못 입력.. 다시 입력해주세요!!");
			}

		} while (true);
	}

	private static String inputbTitle() {
		System.out.println("조회할 책 이름: ");
		return sc.next();
	}

	private static int inputbId() {
		System.out.println("조회할 책 아이디: ");
		return sc.nextInt();
	}

	private static Book inputb() {
		Book b = new Book();

		System.out.println("책 제목: ");
		b.setTitle(sc.next());
		System.out.println("책 저자: ");
		b.setAuthor(sc.next());
		System.out.println("출판사: ");
		b.setPublisher(sc.next());
		System.out.println("가격: ");
		b.setPrice(sc.nextInt());

		return b;
	}

	public void printAll(ArrayList<Book> list) {
		System.out.println("***책 리스트***");
		for (int i = 0; i < list.size(); i++) {
			System.out.println((i + 1) + " : " + list.get(i));
		}

	}

	public void printError(String message) {
		System.out.println("\n에러: " + message);

	}

	public void printb(Book b) {
		System.out.println("조회된 상품 정보는 아래와 같습니다");
		System.out.println("\n" + b);

	}
}
