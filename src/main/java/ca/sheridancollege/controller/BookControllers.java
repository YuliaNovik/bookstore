package ca.sheridancollege.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.beans.Book;
import ca.sheridancollege.database.DatabaseAccess;


@Controller
public class BookControllers {

	@Autowired 
	private DatabaseAccess da;

	@GetMapping("/")
	public String goAddBook(Model model) {
		model.addAttribute("book", new Book());
		return "add.html";
	}
	@GetMapping("/addB")
	public String doAddBook(Model model, @ModelAttribute Book book) {
		da.addBook(book);
		return "redirect:/";
	}
	@GetMapping("/view")
	public String goViewBook(Model model) {
		model.addAttribute("books", da.getBook());
		return "view.html";
	}

	@GetMapping("/edit/{id}")
	public String editBook(@PathVariable int id, Model model) {
		Book book = da.getBookById(id);
		model.addAttribute("book", book);
		return "modify.html";
	}
	@GetMapping("/modify")
	public String modifyBook(Model model, @ModelAttribute Book book) {
		da.editBook(book);
		return "redirect:/view";
	}
	@GetMapping("/sT")
	public String searchBookByTitle(@RequestParam String title, Model model) {
		ArrayList<Book> book = da.searchBookByTitle(title);
		model.addAttribute("book", book);
		return "search.html";
	}
	@GetMapping("/sA")
	public String searchBookByAuthor(@RequestParam String author, Model model) {
		ArrayList<Book> book = da.searchBookByAuthor(author);
		model.addAttribute("book", book);
		return "search.html";
	}
	@GetMapping("/sI")
	public String searchBookById(@RequestParam int id, Model model) {
		ArrayList<Book> book = da.searchBookById(id);
		model.addAttribute("book", book);
		return "search.html";
	}
	@GetMapping("/sC")
	public String searchBookByCourse(@RequestParam String courses, Model model) {
		ArrayList<Book> book = da.searchBookByCourses(courses);
		model.addAttribute("book", book);
		return "search.html";
	}
	@GetMapping("/sQ")
	public String searchBookByQ(@RequestParam double invQuant, Model model) {
		ArrayList<Book> book = da.searchBookByQ(invQuant);
		model.addAttribute("book", book);
		return "search.html";
	}
	@GetMapping("/dummy")
	public String goBook(Model model) {
		model.addAttribute("dummies", da.getBook());
		return "dummy.html";
	}
	@GetMapping("/delete/{id}")
	public String deleteBook(@PathVariable int id, Model model) {
		da.deleteBook(id);
		return "redirect:/view";
	} 
	@GetMapping("/purchase/{id}")
	public String purchaseBook(@PathVariable int id, Model model) {
		Book book = da.getBookById(id);
		da.purchaseBook(book);
		return "redirect:/view";
	}
	@GetMapping("/purchase1/{id}")
	public String purchaseInASearch(@PathVariable int id, Model model) {
		Book book = da.getBookById(id);
		da.purchaseBook(book);
		return "redirect:/search";
	}
	@GetMapping("/search")
	public String goViewSearch(Model model) {
		model.addAttribute("book", da.getBook());
		return "search.html";
	}
}
