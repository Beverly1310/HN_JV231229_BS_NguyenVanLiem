package ra.run;

import ra.bussiness.Book;

import java.util.Objects;
import java.util.Scanner;

public class BookManagement {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("****************JAVAVAVA-HACKATATHON-05-BASIC-MENU***************" +
                    "\n1. Nhập số lượng sách thêm mới và nhập thông tin cho từng cuốn sách " +
                    "\n2. Hiển thị thông tin tất cả sách trong thư viện " +
                    "\n3. Sắp xếp sách theo lợi nhuận tăng dần " +
                    "\n4. Xóa sách theo mã sách " +
                    "\n5. Tìm kiếm tương đối sách theo tên sách hoặc mô tả " +
                    "\n6. Thay đổi thông tin sách theo mã sách " +
                    "\n7. Thoát " +
                    "\nChọn hành động muốn làm:");
             choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    createBook();
                    break;
                case 2:
                    displayBook();
                    break;
                case 3:
                    sortBook();
                    break;
                case 4:
                    deleteBook();
                    break;
                case 5:
                    searchBook();
                    break;
                case 6:
                    changeInforBook();
                    break;
                default:
                    System.out.println("Mời nhập lại");
                    break;
            }
        }
        while (choice!=7);
    }
    //
    static Book[] book = new Book[100];
    // Thêm và nhập thông tin sách
    static  int length=0;
    public static void createBook() {
        System.out.println("Nhập số sách cần thêm");
        int count=Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < count; i++) {
            book[length]=new Book();
            book[length].setBookId(length);
            book[length].inputData();
            length++;
        }
    }
    //Hiển thị sách
    public static void displayBook(){
        for (int i = 0; i < length; i++) {
            System.out.println("Mã sách: " + book[i].getBookId()+
                    "\nTên sách: " + book[i].getBookName()+
                    "\nTên tác giả: " + book[i].getAuthor()+
                    "\nMô tả: " + book[i].getDescriptions()+
                    "\nGiá nhập vào: " + book[i].getImportPrice()+
                    "\nGiá xuất ra: "+ book[i].getExportPrice()+
                    "\nLợi nhuận: " + book[i].getInterest()+
                    "\nTình trạng: " + (book[i].isBookStatus() ? "Còn hàng" : "Hết hàng"+
                    "--------------------------------------------------"));
        }
    }
    // Sắp xếp sách theo lợi nhuận tăng dần
    public static void sortBook() {
        for (int i = 0; i < length; i++) {
            for (int j = i+1; j < length; j++) {
                if (book[i].getInterest()>book[j].getInterest()) {
                    Book tg = book[i];
                    book[i]=book[j];
                    book[j]=tg;
                }
            }
        }
        displayBook();
    }
    // Xóa sách theo mã sách
    public static void deleteBook() {
        System.out.println("Nhập Id sách cần xóa: ");
        int deleteId=Integer.parseInt(scanner.nextLine());
        int index = -1;
        for (int i = 0; i < length; i++) {
            if (book[i].getBookId()==deleteId) {
                index=i;
                break;
            }
        }
        if (index!=-1) {
            for (int i = index; i < length; i++) {
                book[i]=book[i+1];
            }
            book[length-1]=null;
            length--;
        }
        else {
            System.out.println("Không có sách cần xóa");
        }
    }
    //Tìm kiếm tương đối sách theo tên sách hoặc mô tả
        public static void searchBook(){
            System.out.println("Nhập vào tên sách hoặc mô tả về sách: ");
            String findBook = scanner.nextLine();
            for (int i = 0; i < length; i++) {
                if (book[i].getBookName().contains(findBook) || book[i].getDescriptions().contains(findBook)) {
                    System.out.println("Mã sách: " + book[i].getBookId()+
                            "\nTên sách: " + book[i].getBookName()+
                            "\nTên tác giả: " + book[i].getAuthor()+
                            "\nMô tả: " + book[i].getDescriptions()+
                            "\nGiá nhập vào: " + book[i].getImportPrice()+
                            "\nGiá xuất ra: "+ book[i].getExportPrice()+
                            "\nLợi nhuận: " + book[i].getInterest()+
                            "\nTình trạng: " + (book[i].isBookStatus() ? "Còn hàng" : "Hết hàng"));
                }
            }
        }
    //  Thay đổi thông tin sách theo mã sách
    public static void changeInforBook() {
        System.out.println("Nhập vào mã sách: ");
        int change = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < length; i++) {
            if (book[i].getBookId()==change) {
                do {
                    System.out.println("Mời nhập tên sách:");
                   book[i].setBookName(scanner.nextLine());
                    if (Objects.equals(book[i].getBookName(), "")) {
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
                  book[i].setAuthor(scanner.nextLine());
                    if (Objects.equals(book[i].getAuthor(), "")) {
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
                   book[i].setDescriptions(scanner.nextLine());
                    boolean lengthCheck=false;
                    boolean spaceCheck=false;
                    if (Objects.equals(book[i].getDescriptions(), "")) {
                        System.out.println("Mô tả không được để trống");
                    }
                    else {
                        spaceCheck=true;
                    }
                    if (book[i].getDescriptions().length()<10) {
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
                    book[i].setImportPrice(Double.parseDouble(scanner.nextLine()));
                    if (book[i].getImportPrice()<0) {
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
                    book[i].setExportPrice(Double.parseDouble(scanner.nextLine()));
                    if (book[i].getExportPrice()<1.2*book[i].getImportPrice()) {
                        System.out.println("Giá xuất ra phải lớn hơn 1.2 lần giá nhập vào");
                    }
                    else {
                        break;
                    }
                }
                while (true);
                //Nhập trạng thái
                System.out.println("Mời nhập trạng thái sách(true/false):");
                book[i].setBookStatus(Boolean.parseBoolean(scanner.nextLine()));
                // tính lợi nhuận
               book[i].setInterest((float) (book[i].getExportPrice()-book[i].getExportPrice()));
            }
        }
    }
}
