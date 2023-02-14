package service;

import java.util.List;

import booksearch.BookDAO;
import library.BookVO;

public class BookService {

	public List<BookVO> select(String string) {
		BookDAO bookdao = new BookDAO();
		List<BookVO> list = bookdao.select(string);
		return list;
	}

}
