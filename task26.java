class Library {
    private int availableBooks;

    public Library(int availableBooks) {
        this.availableBooks = availableBooks;
    }

    public synchronized void borrowBook() throws InterruptedException {
        while (availableBooks == 0) {
            System.out.println(Thread.currentThread().getName() + " is waiting for a book.");
            wait();
        }
        availableBooks--;
        System.out.println(Thread.currentThread().getName() + " borrowed a book. Books left: " + availableBooks);
    }

    public synchronized void returnBook() {
        availableBooks++;
        System.out.println(Thread.currentThread().getName() + " returned a book. Books available: " + availableBooks);
        notify();
    }
}

class Student implements Runnable {
    private Library library;

    public Student(Library library) {
        this.library = library;
    }

    @Override
    public void run() {
        try {
            library.borrowBook();
            Thread.sleep(1000);
            library.returnBook();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Library library = new Library(2);

        Thread student1 = new Thread(new Student(library), "Student-1");
        Thread student2 = new Thread(new Student(library), "Student-2");
        Thread student3 = new Thread(new Student(library), "Student-3");
        Thread student4 = new Thread(new Student(library), "Student-4");

        student1.start();
        student2.start();
        student3.start();
        student4.start();
    }
}
