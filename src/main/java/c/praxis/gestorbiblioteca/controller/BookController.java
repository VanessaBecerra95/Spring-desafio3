package c.praxis.gestorbiblioteca.controller;

import c.praxis.gestorbiblioteca.GestorBibliotecaApplication;
import c.praxis.gestorbiblioteca.model.dto.Book;
import c.praxis.gestorbiblioteca.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/books")
public class BookController {

    private static final Logger logger = LoggerFactory.getLogger(GestorBibliotecaApplication.class);

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String findAll(Model model) {
        logger.warn("Ejecutando findAll");
        model.addAttribute("books", bookService.findAll());
        return "bookList";
    }

    @GetMapping("/new")
    public ModelAndView create(){
        return new ModelAndView("bookNew");
    }

    @PostMapping("/new")
    public String save(@ModelAttribute Book book){
        boolean result = bookService.create(book);

        if (result){
            logger.info("Libro creado correctamente");
        } else {
            logger.error("Error al crear libro");
        }
        return "redirect:/books";
    }

    @GetMapping("/search")
    public String search(@RequestParam String query, Model model) {
        logger.info("Buscando libros con query: " + query);
        model.addAttribute("books", bookService.search(query));
        return "bookList";
    }
}