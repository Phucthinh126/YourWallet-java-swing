package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import view.MainFrame;

public class ExpenceController {
    private MainFrame mainFrame;
    private List<String[]> expenses; // amount, description, date
    private double balance;

    public ExpenceController(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.expenses = new ArrayList<>();
        this.balance = 0.0;
    }

    /*
     * them giao dich mới
     * mount: số tiền
     * descriptio: nội dung cập nhật
     * date: ngay cập nhật
     * Xử lý ngoại lệ khi nhập số tiên
     * xử lý ngoại lệ khi cập nhật số dư còn lại
     */
    public void addExpenses(double amount, String description, LocalDate date) {

        double newBalance = balance - amount;
        if (amount <= 0) {
            throw new IllegalArgumentException("Số tiền không được phép nhỏ hơn hoặc bằng 0!");
        }
        if (newBalance < 0) {
            throw new IllegalArgumentException("Số dư không đủ để thực hiện giao dịch!");
        } else {
            expenses.add(new String[] { String.valueOf(amount), description, date.toString() });
        }
        balance = newBalance; // cap nhat lai balance
        loadExpenses(); // cap nhat du lieu vao bang

    }

    /*
     * tai du lieu vao ban va du cap nhat so du hien tai
     */

    public void loadExpenses() {
        DefaultTableModel modelTable = mainFrame.getModeTable();
        modelTable.setRowCount(0);
        int countStt = 1;
        for (String[] expense : expenses) {
            modelTable.addRow(new Object[] {
                    countStt++,
                    Double.parseDouble(expense[0]),
                    expense[1],
                    expense[2].toString()
            });
        }

    }

    /*
     * cập nhật số tiền nạp thêm vào ví
     */
    public void updateDeposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Số tiền không được nhỏ hơn 0!");
        } else {
            balance += amount;
        }

    }
}
