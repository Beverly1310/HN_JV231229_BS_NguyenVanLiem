package ra.bussiness;

import java.util.Objects;
import java.util.Scanner;

public class Book {
    private int bookId;
    private String bookName;
    private String author;
    private String descriptions;
    private double importPrice;
    private double exportPrice;
    private float interest;
    private boolean bookStatus;

    public Book(int bookId, String bookName, String author, String descriptions, double importPrice, double exportPrice, boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.descriptions = descriptions;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.bookStatus = bookStatus;
    }
    public Book(){
        this.bookStatus=true;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(String descriptions) {
        this.descriptions = descriptions;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }
    public void inputData() {
        Scanner scanner = new Scanner(System.in);
        // Nhập tên sách
        do {
            System.out.println("Mời nhập tên sách:");
            this.bookName = scanner.nextLine();
            if (Objects.equals(this.bookName, "")) {
                System.out.println("Không được để trống");
            }
            else {
                break;
            }
        }
        while (true);
        // Nhập tên tác giả
        do {
            System.out.println("Mời nhập tên tác giả: ");
            this.author = scanner.nextLine();
            if (Objects.equals(this.author, "")) {
                System.out.println("Tên tác giả không được để trống");
            }
            else {
                break;
            }
        }
        while (true);
        // Nhập mô tả về sách
        do {
            System.out.println("Mời nhập mô tả về sách: ");
            this.descriptions = scanner.nextLine();
            boolean lengthCheck=false;
            boolean spaceCheck=false;
            if (Objects.equals(this.descriptions, "")) {
                System.out.println("Mô tả không được để trống");
            }
            else {
                spaceCheck=true;
            }
            if (this.descriptions.length()<10) {
                System.out.println("Ít nhất 10 ký tự!");
            }
            else {
                lengthCheck=true;
            }
            if (lengthCheck && spaceCheck) {
                break;
            }
        }
        while (true);
        // Nhập giá nhập vào
        do {
            System.out.println("Mời nhập giá nhập vào: ");
            this.importPrice=Double.parseDouble(scanner.nextLine());
            if (this.importPrice<0) {
                System.out.println("Giá nhập vào phải lớn hơn 0");
            }
            else {
                break;
            }
        }
        while (true);
        //Nhập giá xuất ra
        do {
            System.out.println("Mời nhập giá xuất ra:");
            this.exportPrice=Double.parseDouble(scanner.nextLine());
            if (this.exportPrice<1.2*this.importPrice) {
                System.out.println("Giá xuất ra phải lớn hơn 1.2 lần giá nhập vào");
            }
            else {
                break;
            }
        }
        while (true);
        //Nhập trạng thái
        System.out.println("Mời nhập trạng thái sách(true/false):");
          this.bookStatus=Boolean.parseBoolean(scanner.nextLine());
        // tính lợi nhuận
        this.interest = (float) (this.exportPrice-this.importPrice);
    }
}
