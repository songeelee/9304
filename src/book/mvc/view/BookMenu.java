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
			System.out.println("*** ���� ���� ���α׷� ***");
			System.out.println("1. ���� �߰�");
			System.out.println("2. ���� ���� ����");
			System.out.println("3. ���� ����");
			System.out.println("4. ���� ���̵�� ��ȸ");
			System.out.println("5. ���� �������� ��ȸ");
			System.out.println("6. ���� ��� ��ü ��ȸ");
			System.out.println("9. ������");
			System.out.println("��ȣ ���� : ");
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
				System.out.println("���� ���� ���α׷��� �����մϴ�. ");
				return;
			default:
				System.out.println("�߸� �Է�.. �ٽ� �Է����ּ���!!");
			}

		} while (true);
	}

	private static String inputbTitle() {
		System.out.println("��ȸ�� å �̸�: ");
		return sc.next();
	}

	private static int inputbId() {
		System.out.println("��ȸ�� å ���̵�: ");
		return sc.nextInt();
	}

	private static Book inputb() {
		Book b = new Book();

		System.out.println("å ����: ");
		b.setTitle(sc.next());
		System.out.println("å ����: ");
		b.setAuthor(sc.next());
		System.out.println("���ǻ�: ");
		b.setPublisher(sc.next());
		System.out.println("����: ");
		b.setPrice(sc.nextInt());

		return b;
	}

	public void printAll(ArrayList<Book> list) {
		System.out.println("***å ����Ʈ***");
		for (int i = 0; i < list.size(); i++) {
			System.out.println((i + 1) + " : " + list.get(i));
		}

	}

	public void printError(String message) {
		System.out.println("\n����: " + message);

	}

	public void printb(Book b) {
		System.out.println("��ȸ�� ��ǰ ������ �Ʒ��� �����ϴ�");
		System.out.println("\n" + b);

	}
}
