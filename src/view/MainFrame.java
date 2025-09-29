package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;

import controller.ExpenceController;

public class MainFrame extends JFrame {
    private JPanel panelWallet, panelTitle, panelMonthExpense,
            panelBalance, panelTransactionInput, panelButtonTRansaction,
            panelDeposit, panelButtonDeposit, panelMonthlyTotal;

    private JLabel labelTitle, labelAmount, labelDescription,
            labelDate, labelTitleMonth, labelMonthlyTotal, labelDeposit;

    private JScrollPane scrollPane;
    private JButton btnAddTransaction, btnResetForm, btnDeposit, btnViewSpentAmount, btnExitApp; // btnDeposit: Nạp
                                                                                                 // tiền/ tong chi tieu
    private JTable tableMonthExpense;
    private DefaultTableModel model;
    private String[] headers = new String[] { "STT ", "Số tiền (VNĐ)", "Nội dung", "Ngày" };
    private JTextField textAmount, textDescription, textDate, textDeposit;
    private JLabel textBalance;
    private ExpenceController expenceController;

    public MainFrame() {
        super();

        // khoi tao expenceController
         expenceController  = new ExpenceController(this);

        // panelWallet - hien thi vi cua ban
        panelWallet = new JPanel();
        panelWallet.setLayout(new BorderLayout());
        // panelWallet.setBorder(BorderFactory.createTitledBorder("Ví Của Bạn"));
        panelWallet.setLayout(new BoxLayout(panelWallet, BoxLayout.Y_AXIS));

        panelTitle = new JPanel();
        panelTitle.setLayout(new FlowLayout(FlowLayout.CENTER));
        panelTitle.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        ImageIcon icon = createImageIcon("D:\\07. PROJECT\\YourWallet\\image\\Logo.gif");

        Image img = icon.getImage(); // getImage from ImageIcon
        Image newImg = img.getScaledInstance(70, 70, Image.SCALE_SMOOTH); // resize
        icon = new ImageIcon(newImg); // create new imageIcon

        labelTitle = new JLabel("Your Wallet", icon, JLabel.CENTER);
        labelTitle.setVerticalTextPosition(JLabel.CENTER);
        labelTitle.setHorizontalAlignment(JLabel.CENTER);

        panelTitle.add(labelTitle);

        panelWallet.add(panelTitle);

        panelBalance = new JPanel(); // panelBalance - so du hien tai
        panelBalance.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelBalance.setPreferredSize(new Dimension(0, 30));
        panelBalance.setBorder(BorderFactory.createTitledBorder("Số Dư Hiện Tại"));
        textBalance = new JLabel("0.0"); // hien thi so du
        textBalance.setPreferredSize(new Dimension(200, 25));
        panelBalance.add(textBalance);

        panelWallet.add(panelBalance);

        panelTransactionInput = new JPanel(); // panelTransaction - them giao dich moi
        panelTransactionInput.setBorder(BorderFactory.createTitledBorder("Thêm Giao Dịch Mới"));
        panelTransactionInput.setLayout(new GridLayout(3, 2, 10, 10));
        panelTransactionInput.setPreferredSize(new Dimension(0, 90));

        labelAmount = new JLabel("Số Tiền"); // labelAmount - hien thi so tien
        labelAmount.setPreferredSize(new Dimension(90, 25));
        labelDescription = new JLabel("Nội Dung"); // labelDescription - hien thi noi dung
        labelDescription.setPreferredSize(new Dimension(90, 25));
        labelDate = new JLabel("Ngày (dd/mm/yyyy)"); // lableDate - hien thi ngay
        labelDate.setPreferredSize(new Dimension(90, 25));

        textAmount = new JTextField(); // textAmount - o nhap so tien
        textAmount.setPreferredSize(new Dimension(100, 25));
        textDescription = new JTextField(); // textDescription - o nhap noi dung/ ghi chu
        textDescription.setPreferredSize(new Dimension(100, 25));
        textDate = new JTextField(); // textDate - nhap ngay
        textDate.setPreferredSize(new Dimension(100, 25));

        panelTransactionInput.add(labelAmount); // add label and textField to panelTransactionInput
        panelTransactionInput.add(textAmount);
        panelTransactionInput.add(labelDescription);
        panelTransactionInput.add(textDescription);
        panelTransactionInput.add(labelDate);
        panelTransactionInput.add(textDate);

        panelWallet.add(panelTransactionInput);

        panelButtonTRansaction = new JPanel(); // panelButtonTransaction - chua cac nut xu ly panelTransactionInput
        panelButtonTRansaction.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        panelButtonTRansaction.setPreferredSize(new Dimension(0, 30));
        panelButtonTRansaction.setBorder(BorderFactory.createTitledBorder(""));

        btnAddTransaction = new JButton("Thêm Giao Dịch"); // buttonAddTransaction - xu ly them giao dich
        btnAddTransaction.setPreferredSize(new Dimension(150, 30));
        btnResetForm = new JButton("Reset"); // buttonResetFrom - xu ly dat lai cac textField
        btnResetForm.setPreferredSize(new Dimension(90, 30));

        panelButtonTRansaction.add(btnAddTransaction); // addButton to panelButtonTransaction
        panelButtonTRansaction.add(btnResetForm);

        panelWallet.add(panelButtonTRansaction);

        panelDeposit = new JPanel(); // panelDeposit - nap tien vao tai khoan
        panelDeposit.setBorder(BorderFactory.createTitledBorder("Nạp Tiền"));
        panelDeposit.setPreferredSize(new Dimension(0, 50));
        labelDeposit = new JLabel("Nhập Số Tiền"); // labelDeposit - hien thi Nhap So Tien
        labelDeposit.setPreferredSize(new Dimension(100, 30));
        textDeposit = new JTextField(); // textDeposit - nhap so tien can nap
        textDeposit.setPreferredSize(new Dimension(150, 25));
        btnDeposit = new JButton("Cập nhật"); // button cap nhat vao so du
        btnDeposit.setPreferredSize(new Dimension(100, 30));

        panelDeposit.add(labelDeposit); // add labelDeposit to panelDeposit
        panelDeposit.add(textDeposit); // add textDeposit to panelDeposit
        panelDeposit.add(btnDeposit);

        panelWallet.add(panelDeposit);

        panelButtonDeposit = new JPanel(); // panelButtonDeposit - chua cac button xu ly penelDeposit
        panelButtonDeposit.setBorder(BorderFactory.createTitledBorder("Thao Tác"));
        panelButtonDeposit.setPreferredSize(new Dimension(0, 50));
        btnViewSpentAmount = new JButton("Xem Tổng Đã Chi Tiêu"); // button xem tong da chi trong thang
        btnViewSpentAmount.setPreferredSize(new Dimension(200, 30));
        btnExitApp = new JButton("Exit"); // button thoat app
        btnExitApp.setPreferredSize(new Dimension(100, 30));

        panelButtonDeposit.add(btnViewSpentAmount);
        panelButtonDeposit.add(btnExitApp);

        panelWallet.add(panelButtonDeposit);

        panelMonthExpense = new JPanel();
        panelMonthExpense.setLayout(new BorderLayout());
        panelMonthExpense.setBorder(BorderFactory.createTitledBorder("Bảng Chi Tiêu"));

        // title
        labelTitleMonth = new JLabel("CHI TIÊU THÁNG ");
        labelTitleMonth.setHorizontalAlignment(SwingConstants.CENTER);
        labelTitleMonth.setFont(new Font("Tohoma", Font.PLAIN, 18));
        labelTitleMonth.setPreferredSize(new Dimension(200, 35));

        // create table
        model = new DefaultTableModel(null, headers);
        tableMonthExpense = new JTable(model);
        scrollPane = new JScrollPane(tableMonthExpense);

        // month total
        panelMonthlyTotal = new JPanel();
        panelMonthlyTotal.setLayout(new FlowLayout(FlowLayout.LEFT));
        panelMonthlyTotal.setBorder(BorderFactory.createTitledBorder("Tổng Chi Tiêu Tháng Này"));
        labelMonthlyTotal = new JLabel("0.0");
        labelMonthlyTotal.setPreferredSize(new Dimension(20, 25));
        panelMonthlyTotal.add(labelMonthlyTotal);

        panelMonthExpense.add(labelTitleMonth, BorderLayout.NORTH);
        panelMonthExpense.add(scrollPane, BorderLayout.CENTER);
        panelMonthExpense.add(panelMonthlyTotal, BorderLayout.SOUTH);

        add(panelWallet);
        add(panelMonthExpense);

        setLayout(new GridLayout(1, 2, 5, 5));
        setTitle("Your Wallet");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
        pack();

        // them acction cho button
        btnAddTransaction.addActionListener(new buttonAction());
        btnResetForm.addActionListener(new buttonAction());

    }

    // get DefautModeTable
    public DefaultTableModel getModeTable() {
        return model;
    }

    private class buttonAction implements ActionListener {
        // xử lý sự kiện button

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton buttonUser = (JButton) e.getSource(); // lấy đối tượng gây ra sự kiện
            String inputDate = textDate.getText(); // lay chuoi nguoi dung nhap
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            if (buttonUser == btnAddTransaction) {
                // xử lý ngoại lệ
                try {
                    Double amount = Double.parseDouble(textAmount.getText());
                    String description = textDescription.getText();
                    LocalDate date = LocalDate.parse(inputDate, formatter); // chuyển chuỗi vào LocalDate
                    LocalDate currenDate = LocalDate.now(); // lấy ngày/tháng/năm hiện tại
                    // cap nhat thong tin giao dich vao bang
                    expenceController.addExpenses(amount, description, currenDate);
                   
                    // so sánh ngày nhập và ngày hiện tại
                    if (!date.equals(currenDate)) {
                        JOptionPane.showMessageDialog(MainFrame.this, "Sai ngày rồi!, hôm nay là: " + currenDate,
                                "Thông báo!", JOptionPane.INFORMATION_MESSAGE);

                    } else {
                        JOptionPane.showMessageDialog(MainFrame.this, "Ngày hợp lệ, thêm thành công", "Thông báo!",
                                JOptionPane.INFORMATION_MESSAGE);
                    }

                } catch (NumberFormatException ex) { // kiem tra dinh dang so tien va ngay
                    JOptionPane.showMessageDialog(buttonUser, "Số tiền hoặc ngày không hợp lệ! Vui lòng kiểm tra ");
                } catch (IllegalStateException ex) {

                } catch (DateTimeException ex) {
                    JOptionPane.showMessageDialog(buttonUser, "Sai định dạng!, Hãy nhập theo định dạng dd/mm/yy");
                }
            } else if (buttonUser == btnResetForm) {
                textAmount.setText(" ");
                textDescription.setText(" ");
                textDate.setText(" ");
            } else if (buttonUser == btnDeposit) {
                try {
                    expenceController.updateDeposit(Double.parseDouble(textAmount.getText()));
                    
                } catch (Exception ex) {
                }
            }
        }

    }

    // tao mot doi tuong Image
    private ImageIcon createImageIcon(String path) { // path"duong dan"
        java.net.URL imgURL = getClass().getResource(path); // tim anh trong resoure cua project
        if (imgURL != null) {
            return new ImageIcon(imgURL); // dung imgURL de tao ImageIcon
        } else {
            // If not found as resource, try loading from file system
            return new ImageIcon(path);
        }
    }

    public static void main(String[] args) {
        new MainFrame();
    }
}
