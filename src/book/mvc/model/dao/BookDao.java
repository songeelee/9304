package book.mvc.model.dao;

import java.sql.*;
import java.util.ArrayList;
import static common.JDBCTemp.*;
import book.mvc.model.vo.Book;

public class BookDao {

	private String title;

	public ArrayList<Book> selectAll() {
		ArrayList<Book> list = null;
		Connection conn = getConnection();
		Statement stmt = null;
		ResultSet rset = null;

		try {
			String query = "select * from book";

			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

			if (rset != null)
				list = new ArrayList<Book>();

			while (rset.next()) {
				Book b = new Book();

				b.setBookId(rset.getInt("book_id"));
				b.setTitle(rset.getString("title"));
				b.setAuthor(rset.getString("author"));
				b.setPublisher(rset.getString("publisher"));
				b.setPrice(rset.getInt("price"));

				list.add(b);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				close(rset);
				close(stmt);
				close(conn);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	public int insertBook(Book b) {
		int result = 0;
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String query = "insert into book values (?,?,?,?,?)";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, b.getBookId());
			pstmt.setString(2, b.getTitle());
			pstmt.setString(3, b.getAuthor());
			pstmt.setString(4, b.getPublisher());
			pstmt.setInt(5, b.getPrice());

			result = pstmt.executeUpdate();

			if (result > 0)
				commit(conn);
			else
				rollback(conn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}

		return result;
	}

	public int updateBook(Book b) {
		int result = 0;
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String query = "update book set author=? and publisher =? where book_id=? ";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, b.getAuthor());
			pstmt.setString(2, b.getPublisher());
			pstmt.setInt(3, b.getBookId());

			result = pstmt.executeUpdate();

			if (result > 0)
				commit(conn);
			else
				rollback(conn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}

		return result;
	}

	public int deleteBook(int bId) {
		int result = 0;
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String query = "delete from book where book_id=?";

		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, bId);

			result = pstmt.executeUpdate();

			if (result > 0)
				commit(conn);
			else
				rollback(conn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}

		return result;
	}

	public Book selectbyId(int bId) {
		Book b = null;
		Connection conn = getConnection();
		Statement stmt = null;
		ResultSet rset = null;

		String query = "select * from book where book_id = '" + bId + "'";

		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

			if (rset.next()) {
				b = new Book();
				b.setBookId(rset.getInt("book_id"));
				b.setTitle(rset.getString("title"));
				b.setAuthor(rset.getString("author"));
				b.setPublisher(rset.getString("publisher"));
				b.setPrice(rset.getInt("price"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
			close(conn);
		}

		return b;
	}

	public Book selectbyTitle(String bTitle) {
		Book b = null;
		Connection conn = getConnection();
		Statement stmt = null;
		ResultSet rset = null;

		String query = "select * from book where title = '" + bTitle + "'";

		try {
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);

			if (rset.next()) {
				b = new Book();
				b.setBookId(rset.getInt("book_id"));
				b.setTitle(rset.getString("title"));
				b.setAuthor(rset.getString("author"));
				b.setPublisher(rset.getString("publisher"));
				b.setPrice(rset.getInt("price"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
			close(conn);
		}

		return b;
	}

}
