package c.praxis.gestorbiblioteca.model.dto;

public class Author {
    private int idAuthor;
    private String name;
    private String lastname;
    private int yearOfBirth;

    public Author() {
    }

    public Author(int idAuthor, String name, String lastname, int yearOfBirth) {
        this.idAuthor = idAuthor;
        this.name = name;
        this.lastname = lastname;
        this.yearOfBirth = yearOfBirth;
    }

    public int getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }
}