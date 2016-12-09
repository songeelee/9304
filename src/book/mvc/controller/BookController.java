package book.mvc.controller;

import java.util.ArrayList;

import book.mvc.model.dao.BookDao;
import book.mvc.model.vo.Book;
import book.mvc.view.BookMenu;

public class BookController {
	private BookMenu bm = new BookMenu();

	public BookController() {
	}

	public void selectAll() {
		ArrayList<Book> list = new BookDao().selectAll();

		if (list != null)
			bm.printAll(list);
		else
			bm.printError("전체 책 조회 실패!");
	}

	public void insertBook(Book b) {
		int result = new BookDao().insertBook(b);
		if (result > 0)
			System.out.println("새 책 등록 성공! ");
		else
			bm.printError("새 책 등록 실패!");

	}

	public void updateBook(Book b) {
		int result = new BookDao().updateBook(b);

		if (result > 0)
			System.out.println("책 수정 성공! ");
		else
			bm.printError("책 수정 실패!");

	}

	public void deleteBook(int bId) {
		int result = new BookDao().deleteBook(bId);

		if (result > 0)
			System.out.println("\n 책 삭제 성공! ");
		else
			bm.printError("책 삭제 실패");

	}

	public void selectBookId(int bId) {
		Book b = new BookDao().selectbyId(bId);

		if (b != null)
			bm.printb(b);
		else
			bm.printError(bId + "책 조회 실패!");

	}

	public void selectBookTitle(String bTitle) {
		Book b = new BookDao().selectbyTitle(bTitle);

		if (b != null)
			bm.printb(b);
		else
			bm.printError(bTitle + "책 조회 실패!");

	}

}
