package form;

import controller.tai_khoan_control;
import java.awt.Color;
import model.tai_khoan;
import dao.tai_khoan_dao;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.UIManager.*;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import model.tai_khoan_model;

public class fm_Main extends javax.swing.JFrame {

    private fm_QL_sach Ql_S;
    private fm_doc_gia QL_dg;
    private fm_muon_tra QL_mt;
    private fm_thong_ke tk;
    private List<tai_khoan_model> dstk;
    static fm_Main fmmain;
    static final Color cl = Color.GREEN;

    public static fm_Main getFmmain() {
        if (fmmain == null) {
            fmmain = new fm_Main();
        }
        return fmmain;
    }

    public fm_Main() {

        initComponents();
        ImageIcon icon = new ImageIcon("/form/start.png");
        this.setIconImage(icon.getImage());
        initF();
        setLocationRelativeTo(null);
    }

    private void initF() {
        //mhc.setBounds(0,0, 900, 560);
        fm_dang_nhap.setBounds(hien_thi.getVisibleRect());
        fm_quan_ly.setBounds(hien_thi.getVisibleRect());
        fm_thu_thu.setBounds(hien_thi.getVisibleRect());
        Ql_S = new fm_QL_sach();
        Ql_S.setBounds(hien_thi.getVisibleRect());
        QL_dg = new fm_doc_gia();
        QL_dg.setBounds(hien_thi.getVisibleRect());
        QL_mt = new fm_muon_tra();
        QL_mt.setBounds(hien_thi.getVisibleRect());
        tk = new fm_thong_ke();
        tk.setBounds(hien_thi.getVisibleRect());
        tai_khoan_control.getTKcon().load_cb_chucvu(cbChucVu);

    }

    //@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        fm_dang_nhap = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jp_dang_nhap = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txt_tai_khoan = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        bt_dang_nhap = new javax.swing.JButton();
        txt_mat_khau = new javax.swing.JPasswordField();
        QL_tai_khoan = new javax.swing.JDialog();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtTenDN = new javax.swing.JTextField();
        txtTK = new javax.swing.JTextField();
        txtMK = new javax.swing.JTextField();
        cbChucVu = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTaiKhoan = new javax.swing.JTable();
        btThemTK = new javax.swing.JButton();
        btLuuTK = new javax.swing.JButton();
        btXoaTK = new javax.swing.JButton();
        tt_tai_khoan = new javax.swing.JDialog();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txt_ten_dn = new javax.swing.JTextField();
        txt_tk_tt = new javax.swing.JTextField();
        txt_mk_cu = new javax.swing.JPasswordField();
        txt_mk_moi = new javax.swing.JPasswordField();
        bt_doi_mk = new javax.swing.JButton();
        jLabel38 = new javax.swing.JLabel();
        txt_xac_nhan = new javax.swing.JPasswordField();
        fm_thu_thu = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        fm_quan_ly = new javax.swing.JPanel();
        bt_ql_tai_khoan = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jCalendar2 = new com.toedter.calendar.JCalendar();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        bt_man_hinh_chinh = new javax.swing.JButton();
        bt_QL_sach = new javax.swing.JButton();
        bt_QL_doc_gia = new javax.swing.JButton();
        bt_muon_tra = new javax.swing.JButton();
        bt_thong_ke = new javax.swing.JButton();
        hien_thi = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        ten_DN = new javax.swing.JTextField();
        bt_tt_tk = new javax.swing.JButton();
        bt_dang_xuat = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        chuc_vu = new javax.swing.JTextField();

        jMenu1.setText("jMenu1");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/002-ebook_resized.jpg"))); // NOI18N
        jLabel4.setText("Phần mềm quản lý thư viện");

        jp_dang_nhap.setBorder(javax.swing.BorderFactory.createTitledBorder("Đăng nhập"));

        jLabel10.setText("Tài khoản");

        jLabel11.setText("Mật khẩu");

        bt_dang_nhap.setText("Đăng nhập");
        bt_dang_nhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_dang_nhapActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jp_dang_nhapLayout = new javax.swing.GroupLayout(jp_dang_nhap);
        jp_dang_nhap.setLayout(jp_dang_nhapLayout);
        jp_dang_nhapLayout.setHorizontalGroup(
            jp_dang_nhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jp_dang_nhapLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jp_dang_nhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jp_dang_nhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_tai_khoan, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                    .addComponent(txt_mat_khau))
                .addGap(41, 41, 41))
            .addGroup(jp_dang_nhapLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bt_dang_nhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jp_dang_nhapLayout.setVerticalGroup(
            jp_dang_nhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jp_dang_nhapLayout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addGroup(jp_dang_nhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_tai_khoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jp_dang_nhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(txt_mat_khau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(bt_dang_nhap)
                .addContainerGap())
        );

        javax.swing.GroupLayout fm_dang_nhapLayout = new javax.swing.GroupLayout(fm_dang_nhap);
        fm_dang_nhap.setLayout(fm_dang_nhapLayout);
        fm_dang_nhapLayout.setHorizontalGroup(
            fm_dang_nhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fm_dang_nhapLayout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 956, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(fm_dang_nhapLayout.createSequentialGroup()
                .addGap(313, 313, 313)
                .addComponent(jp_dang_nhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        fm_dang_nhapLayout.setVerticalGroup(
            fm_dang_nhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fm_dang_nhapLayout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jp_dang_nhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(180, 180, 180))
        );

        QL_tai_khoan.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        QL_tai_khoan.setTitle("Quản lý tài khoản");
        QL_tai_khoan.setAlwaysOnTop(true);
        QL_tai_khoan.setAutoRequestFocus(false);
        QL_tai_khoan.setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);

        jLabel16.setText("Tên đăng nhập");

        jLabel17.setText("Tài khoản");

        jLabel18.setText("Mật khẩu");

        jLabel19.setText("Chức vụ");

        cbChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách tài khoản", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 2, 10))); // NOI18N

        tblTaiKhoan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Tên đăng nhập", "Tài khoản ", "Chức vụ"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTaiKhoanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTaiKhoan);

        btThemTK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/form/add.png"))); // NOI18N
        btThemTK.setText("Thêm");
        btThemTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemTKActionPerformed(evt);
            }
        });

        btLuuTK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/form/save.png"))); // NOI18N
        btLuuTK.setText("Lưu");
        btLuuTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLuuTKActionPerformed(evt);
            }
        });

        btXoaTK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/form/delete.png"))); // NOI18N
        btXoaTK.setText("Xóa");
        btXoaTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaTKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout QL_tai_khoanLayout = new javax.swing.GroupLayout(QL_tai_khoan.getContentPane());
        QL_tai_khoan.getContentPane().setLayout(QL_tai_khoanLayout);
        QL_tai_khoanLayout.setHorizontalGroup(
            QL_tai_khoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QL_tai_khoanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(QL_tai_khoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(QL_tai_khoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbChucVu, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtMK, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                    .addComponent(txtTK)
                    .addComponent(txtTenDN, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                .addGroup(QL_tai_khoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btThemTK, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btLuuTK, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btXoaTK, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(57, 57, 57))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 516, Short.MAX_VALUE)
        );

        QL_tai_khoanLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cbChucVu, txtMK, txtTK, txtTenDN});

        QL_tai_khoanLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btLuuTK, btThemTK, btXoaTK});

        QL_tai_khoanLayout.setVerticalGroup(
            QL_tai_khoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QL_tai_khoanLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(QL_tai_khoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtTenDN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btThemTK))
                .addGap(18, 18, 18)
                .addGroup(QL_tai_khoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(txtTK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btLuuTK))
                .addGap(18, 18, 18)
                .addGroup(QL_tai_khoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtMK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btXoaTK))
                .addGap(18, 18, 18)
                .addGroup(QL_tai_khoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(cbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                .addGap(15, 15, 15))
        );

        tt_tai_khoan.setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        tt_tai_khoan.setTitle("Thông tin đăng nhập");
        tt_tai_khoan.setAlwaysOnTop(true);
        tt_tai_khoan.setModalityType(java.awt.Dialog.ModalityType.APPLICATION_MODAL);
        tt_tai_khoan.setResizable(false);
        tt_tai_khoan.setSize(new java.awt.Dimension(400, 400));

        jLabel12.setText("Tên đăng nhập");

        jLabel13.setText("Tài khoản");

        jLabel14.setText("Mật khẩu");

        jLabel15.setText("Mật khẩu mới");

        txt_ten_dn.setEditable(false);

        txt_tk_tt.setEditable(false);

        bt_doi_mk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/form/refresh.png"))); // NOI18N
        bt_doi_mk.setText("Đổi mật khẩu");
        bt_doi_mk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_doi_mkActionPerformed(evt);
            }
        });

        jLabel38.setText("Xác nhận MK");

        javax.swing.GroupLayout tt_tai_khoanLayout = new javax.swing.GroupLayout(tt_tai_khoan.getContentPane());
        tt_tai_khoan.getContentPane().setLayout(tt_tai_khoanLayout);
        tt_tai_khoanLayout.setHorizontalGroup(
            tt_tai_khoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tt_tai_khoanLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(tt_tai_khoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(tt_tai_khoanLayout.createSequentialGroup()
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tt_tai_khoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bt_doi_mk)
                    .addComponent(txt_tk_tt)
                    .addComponent(txt_ten_dn)
                    .addComponent(txt_mk_cu)
                    .addComponent(txt_mk_moi, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                    .addComponent(txt_xac_nhan))
                .addGap(103, 103, 103))
        );

        tt_tai_khoanLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {txt_mk_cu, txt_mk_moi, txt_ten_dn, txt_tk_tt, txt_xac_nhan});

        tt_tai_khoanLayout.setVerticalGroup(
            tt_tai_khoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tt_tai_khoanLayout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(tt_tai_khoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_ten_dn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(tt_tai_khoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_tk_tt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(tt_tai_khoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_mk_cu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(tt_tai_khoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_mk_moi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(tt_tai_khoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel38)
                    .addComponent(txt_xac_nhan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addComponent(bt_doi_mk)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        tt_tai_khoanLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txt_mk_cu, txt_mk_moi, txt_ten_dn, txt_tk_tt, txt_xac_nhan});

        jLabel25.setText("Nhóm thiết kế:");

        jLabel26.setText("Lê Đức Minh");

        jLabel27.setText("Hort Vita");

        jLabel28.setText("Nguyễn Thăng Long");

        jLabel29.setText("Nguyễn Thị  Thu");

        jLabel30.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/002-ebook_resized.jpg"))); // NOI18N
        jLabel30.setText("Phần mềm quản lý thư viện");

        jCalendar1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jCalendar1PropertyChange(evt);
            }
        });

        javax.swing.GroupLayout fm_thu_thuLayout = new javax.swing.GroupLayout(fm_thu_thu);
        fm_thu_thu.setLayout(fm_thu_thuLayout);
        fm_thu_thuLayout.setHorizontalGroup(
            fm_thu_thuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fm_thu_thuLayout.createSequentialGroup()
                .addGroup(fm_thu_thuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fm_thu_thuLayout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addGroup(fm_thu_thuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28)
                            .addComponent(jLabel29)))
                    .addGroup(fm_thu_thuLayout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(fm_thu_thuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 913, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(fm_thu_thuLayout.createSequentialGroup()
                        .addGap(157, 157, 157)
                        .addComponent(jCalendar1, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
        );
        fm_thu_thuLayout.setVerticalGroup(
            fm_thu_thuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fm_thu_thuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(jCalendar1, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel28)
                .addGap(12, 12, 12)
                .addComponent(jLabel29)
                .addGap(36, 36, 36))
        );

        bt_ql_tai_khoan.setText("Quản lý tài khoản(Dành cho quản lý)");
        bt_ql_tai_khoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_ql_tai_khoanActionPerformed(evt);
            }
        });

        jLabel20.setText("Nhóm thiết kế:");

        jLabel21.setText("Lê Đức Minh");

        jLabel22.setText("Hort Vita");

        jLabel23.setText("Nguyễn Thăng Long");

        jLabel24.setText("Nguyễn Thị  Thu");

        jLabel31.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel31.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/002-ebook_resized.jpg"))); // NOI18N
        jLabel31.setText("Phần mềm quản lý thư viện");

        jCalendar2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jCalendar2PropertyChange(evt);
            }
        });

        javax.swing.GroupLayout fm_quan_lyLayout = new javax.swing.GroupLayout(fm_quan_ly);
        fm_quan_ly.setLayout(fm_quan_lyLayout);
        fm_quan_lyLayout.setHorizontalGroup(
            fm_quan_lyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(fm_quan_lyLayout.createSequentialGroup()
                .addGroup(fm_quan_lyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(fm_quan_lyLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 913, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(fm_quan_lyLayout.createSequentialGroup()
                        .addGap(164, 164, 164)
                        .addComponent(jCalendar2, javax.swing.GroupLayout.PREFERRED_SIZE, 619, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(fm_quan_lyLayout.createSequentialGroup()
                        .addGap(302, 302, 302)
                        .addComponent(bt_ql_tai_khoan, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(fm_quan_lyLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(fm_quan_lyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(fm_quan_lyLayout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(fm_quan_lyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel22)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel23)
                                    .addComponent(jLabel24)))
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(166, Short.MAX_VALUE))
        );
        fm_quan_lyLayout.setVerticalGroup(
            fm_quan_lyLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fm_quan_lyLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCalendar2, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bt_ql_tai_khoan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel20)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel21)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel23)
                .addGap(12, 12, 12)
                .addComponent(jLabel24)
                .addGap(53, 53, 53))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Phần mềm quản lý thư viện");
        setBackground(new java.awt.Color(153, 153, 153));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(51, 255, 51));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 0, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/005-book_resized.jpg"))); // NOI18N
        jLabel1.setText("<html>\n<head>\n<style>\nbody {\n  background-color: none;\n  text-align: center;\n  color: black;\n  font-family: Arial, Helvetica, sans-serif;\n}\n</style>\n</head>\n<body>\n<p>PHẦN MỀM QUẢN LÝ THƯ VIỆN</p>\n</body>\n</html>");

        bt_man_hinh_chinh.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bt_man_hinh_chinh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/form/start.png"))); // NOI18N
        bt_man_hinh_chinh.setText("<html>\n<body>\n<p align= \"center\">&nbsp;Màn hình<br>chính<p>\n</body>\n</html>");
        bt_man_hinh_chinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_man_hinh_chinhActionPerformed(evt);
            }
        });

        bt_QL_sach.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bt_QL_sach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/monhoc.png"))); // NOI18N
        bt_QL_sach.setText("<html>\n<body>\n<p align= \"center\">&nbsp;Quản lý<br>sách<p>\n</body>\n</html>");
        bt_QL_sach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_QL_sachActionPerformed(evt);
            }
        });

        bt_QL_doc_gia.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bt_QL_doc_gia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/pupils.png"))); // NOI18N
        bt_QL_doc_gia.setText("<html>\n<body>\n<p align = \"center\">&nbsp;Quản lý<br>&nbsp;độc giả<p>\n</body>\n</html>");
        bt_QL_doc_gia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_QL_doc_giaActionPerformed(evt);
            }
        });

        bt_muon_tra.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bt_muon_tra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/diem.png"))); // NOI18N
        bt_muon_tra.setText("<html>\n<body>\n<p>&nbsp;Quản lý<br>mượn - trả<p>\n</body>\n</html>");
        bt_muon_tra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_muon_traActionPerformed(evt);
            }
        });

        bt_thong_ke.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        bt_thong_ke.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/xeploai.png"))); // NOI18N
        bt_thong_ke.setText("<html>\n<body>\n<p>Thống kê<br>&nbsp;& báo cáo<p>\n</body>\n</html>");
        bt_thong_ke.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_thong_keActionPerformed(evt);
            }
        });

        hien_thi.setBackground(new java.awt.Color(255, 255, 255));
        hien_thi.setOpaque(false);

        javax.swing.GroupLayout hien_thiLayout = new javax.swing.GroupLayout(hien_thi);
        hien_thi.setLayout(hien_thiLayout);
        hien_thiLayout.setHorizontalGroup(
            hien_thiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        hien_thiLayout.setVerticalGroup(
            hien_thiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 513, Short.MAX_VALUE)
        );

        jLabel2.setText("Tên đăng nhập");

        ten_DN.setEditable(false);

        bt_tt_tk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/doimatkhaucontext.png"))); // NOI18N
        bt_tt_tk.setText("TT tài khoản");
        bt_tt_tk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_tt_tkActionPerformed(evt);
            }
        });

        bt_dang_xuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dangxuatcontext.png"))); // NOI18N
        bt_dang_xuat.setText("Đăng xuất");
        bt_dang_xuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_dang_xuatActionPerformed(evt);
            }
        });

        jLabel3.setText("Chức vụ");

        chuc_vu.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(bt_muon_tra, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                            .addComponent(bt_QL_doc_gia, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt_QL_sach, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt_man_hinh_chinh, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(bt_thong_ke))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hien_thi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 469, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(ten_DN, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(12, 12, 12)
                        .addComponent(chuc_vu, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bt_tt_tk, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(bt_dang_xuat, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(37, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {bt_QL_doc_gia, bt_QL_sach, bt_man_hinh_chinh, bt_muon_tra, bt_thong_ke});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(ten_DN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(chuc_vu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(bt_tt_tk))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(bt_dang_xuat)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(bt_man_hinh_chinh, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bt_QL_sach, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bt_QL_doc_gia, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bt_muon_tra, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(bt_thong_ke, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(hien_thi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {bt_QL_doc_gia, bt_QL_sach, bt_man_hinh_chinh, bt_muon_tra, bt_thong_ke});

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_man_hinh_chinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_man_hinh_chinhActionPerformed
        //hiển thị form
        this.Ql_S.setVisible(false);
        this.QL_dg.setVisible(false);
        this.QL_mt.setVisible(false);
        this.tk.setVisible(false);
        this.fm_quan_ly.setVisible(false);
        this.fm_thu_thu.setVisible(false);
        this.fm_dang_nhap.setVisible(false);
        if (tai_khoan.getQuyen() == 1) {
            this.hien_thi.add(this.fm_quan_ly);
            this.fm_quan_ly.setVisible(true);
        } else if (tai_khoan.getQuyen() == 2) {
            this.hien_thi.add(this.fm_thu_thu);
            this.fm_thu_thu.setVisible(true);
        } else {
            this.hien_thi.add(this.fm_dang_nhap);
            this.fm_dang_nhap.setVisible(true);
        }
        //đổi màu nút
        this.bt_man_hinh_chinh.setBackground(cl);
        this.bt_thong_ke.setBackground(Color.white);
        this.bt_muon_tra.setBackground(Color.white);
        this.bt_QL_doc_gia.setBackground(Color.white);
        this.bt_QL_sach.setBackground(Color.white);
// TODO add your handling code here:
    }//GEN-LAST:event_bt_man_hinh_chinhActionPerformed

    private void bt_QL_sachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_QL_sachActionPerformed

        if (tai_khoan.getQuyen() == 1 || tai_khoan.getQuyen() == 2) {
            Ql_S.load_all();
            //hiển thị form 
            this.fm_quan_ly.setVisible(false);
            this.fm_thu_thu.setVisible(false);
            this.fm_dang_nhap.setVisible(false);
            this.QL_dg.setVisible(false);
            this.QL_mt.setVisible(false);
            this.tk.setVisible(false);
            this.hien_thi.add(this.Ql_S);
            this.Ql_S.setVisible(true);
            //đổi màu nút
            this.bt_man_hinh_chinh.setBackground(Color.white);
            this.bt_thong_ke.setBackground(Color.white);
            this.bt_muon_tra.setBackground(Color.white);
            this.bt_QL_doc_gia.setBackground(Color.white);
            this.bt_QL_sach.setBackground(cl);

        } else {
            JOptionPane.showMessageDialog(rootPane, "Bạn phải đăng nhập");
        }
    }//GEN-LAST:event_bt_QL_sachActionPerformed

    private void bt_QL_doc_giaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_QL_doc_giaActionPerformed

        // TODO add your handling code here:
        if (tai_khoan.getQuyen() == 1 || tai_khoan.getQuyen() == 2) {
            QL_dg.load_all();
            //hiển thị form 
            this.fm_quan_ly.setVisible(false);
            this.fm_thu_thu.setVisible(false);
            this.fm_dang_nhap.setVisible(false);
            this.Ql_S.setVisible(false);
            this.QL_mt.setVisible(false);
            this.tk.setVisible(false);
            this.hien_thi.add(this.QL_dg);
            this.QL_dg.setVisible(true);
            //đổi màu nút
            this.bt_man_hinh_chinh.setBackground(Color.white);
            this.bt_thong_ke.setBackground(Color.white);
            this.bt_muon_tra.setBackground(Color.white);
            this.bt_QL_doc_gia.setBackground(cl);
            this.bt_QL_sach.setBackground(Color.white);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Bạn phải đăng nhập");
        }
    }//GEN-LAST:event_bt_QL_doc_giaActionPerformed

    private void bt_muon_traActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_muon_traActionPerformed
        // TODO add your handling code here:
        if (tai_khoan.getQuyen() == 1 || tai_khoan.getQuyen() == 2) {
            //hiển thị form
            this.fm_quan_ly.setVisible(false);
            this.fm_thu_thu.setVisible(false);
            this.fm_dang_nhap.setVisible(false);
            this.Ql_S.setVisible(false);
            this.tk.setVisible(false);
            this.QL_dg.setVisible(false);
            this.hien_thi.add(this.QL_mt);
            this.QL_mt.setVisible(true);
            //đổi màu nút
            this.bt_man_hinh_chinh.setBackground(Color.white);
            this.bt_thong_ke.setBackground(Color.white);
            this.bt_muon_tra.setBackground(cl);
            this.bt_QL_doc_gia.setBackground(Color.white);
            this.bt_QL_sach.setBackground(Color.white);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Bạn phải đăng nhập");
        }
    }//GEN-LAST:event_bt_muon_traActionPerformed

    private void bt_thong_keActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_thong_keActionPerformed
        if (tai_khoan.getQuyen() == 1 || tai_khoan.getQuyen() == 2) {
            //hiển thị form
            this.fm_quan_ly.setVisible(false);
            this.fm_thu_thu.setVisible(false);
            this.fm_dang_nhap.setVisible(false);
            this.Ql_S.setVisible(false);
            this.QL_mt.setVisible(false);
            this.QL_dg.setVisible(false);
            this.hien_thi.add(this.tk);
            this.tk.setVisible(true);
            //đổi màu nút
            this.bt_man_hinh_chinh.setBackground(Color.white);
            this.bt_thong_ke.setBackground(cl);
            this.bt_muon_tra.setBackground(Color.white);
            this.bt_QL_doc_gia.setBackground(Color.white);
            this.bt_QL_sach.setBackground(Color.white);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Bạn phải đăng nhập");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_thong_keActionPerformed

    private void bt_tt_tkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_tt_tkActionPerformed
        if (tai_khoan.getId() > 0) {
            tt_tai_khoan.setSize(400, 400);
            tt_tai_khoan.setLocationRelativeTo(null);
            txt_ten_dn.setText(tai_khoan.getTendangnhap());
            txt_tk_tt.setText(tai_khoan.getTaikhoan());
            tt_tai_khoan.setVisible(true);

        } else {
            JOptionPane.showMessageDialog(rootPane, "Bạn phải đăng nhập");
        }
    }//GEN-LAST:event_bt_tt_tkActionPerformed

    private void bt_ql_tai_khoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_ql_tai_khoanActionPerformed
        QL_tai_khoan.setSize(500, 550);
        QL_tai_khoan.setLocationRelativeTo(fm_dang_nhap);
        dstk = tai_khoan_dao.gettk_dao().taikhoanList();
        tai_khoan_control.getTKcon().load_list_tbl(tblTaiKhoan, dstk);
        QL_tai_khoan.setVisible(true);
        // TODO add your handling code here:

    }//GEN-LAST:event_bt_ql_tai_khoanActionPerformed

    private void bt_dang_nhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_dang_nhapActionPerformed
        String taikhoan = txt_tai_khoan.getText();
        String matkhau = txt_mat_khau.getText();
        //System.out.println(matkhau);
        tai_khoan_dao.gettk_dao().dangnhap(taikhoan, matkhau);
        if (tai_khoan.getId() > 0) {
            //JOptionPane.showMessageDialog(rootPane, "Đăng nhập thành công "+tai_khoan.getChucvu() );
            ten_DN.setText(tai_khoan.getTendangnhap());
            chuc_vu.setText(tai_khoan.getChucvu());
            fm_dang_nhap.setVisible(false);
            if (tai_khoan.getQuyen() == 1) {
                this.hien_thi.add(this.fm_quan_ly);
                this.fm_quan_ly.setVisible(true);
            } else if (tai_khoan.getQuyen() == 2) {
                this.hien_thi.add(this.fm_thu_thu);
                this.fm_thu_thu.setVisible(true);
            } else {
                this.hien_thi.add(this.fm_dang_nhap);
                this.fm_dang_nhap.setVisible(true);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Đăng nhập không thành công");
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_dang_nhapActionPerformed

    private void bt_dang_xuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_dang_xuatActionPerformed
        int kt = JOptionPane.showConfirmDialog(rootPane, "Xác nhận đăng xuất tài khoản", "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.YES_NO_OPTION);
        if (kt == JOptionPane.YES_OPTION) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    //khoi tao lai
                    QL_mt = new fm_muon_tra();
                    QL_mt.setBounds(hien_thi.getVisibleRect());
                    Ql_S = new fm_QL_sach();
                    Ql_S.setBounds(hien_thi.getVisibleRect());
                    QL_dg = new fm_doc_gia();
                    QL_dg.setBounds(hien_thi.getVisibleRect());
                    tk = new fm_thong_ke();
                    tk.setBounds(hien_thi.getVisibleRect());
                }

            };
            t.start();
            tai_khoan.setId(0);
            tai_khoan.setChucvu("");
            tai_khoan.setQuyen(0);
            tai_khoan.setTendangnhap("");
            tai_khoan.setMatkhau("");
            ten_DN.setText(tai_khoan.getTendangnhap());
            chuc_vu.setText(tai_khoan.getChucvu());
            this.Ql_S.setVisible(false);
            this.QL_dg.setVisible(false);
            this.QL_mt.setVisible(false);
            this.tk.setVisible(false);
            this.fm_quan_ly.setVisible(false);
            this.fm_thu_thu.setVisible(false);
            this.fm_dang_nhap.setVisible(false);
            this.hien_thi.add(this.fm_dang_nhap);
            this.fm_dang_nhap.setVisible(true);
            txt_tai_khoan.setText("");
            txt_mat_khau.setText("");
            //đổi màu nút
            this.bt_man_hinh_chinh.setBackground(cl);
            this.bt_thong_ke.setBackground(Color.white);
            this.bt_muon_tra.setBackground(Color.white);
            this.bt_QL_doc_gia.setBackground(Color.white);
            this.bt_QL_sach.setBackground(Color.white);

        } else {

        }

// TODO add your handling code here:
    }//GEN-LAST:event_bt_dang_xuatActionPerformed

    private void bt_doi_mkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_doi_mkActionPerformed
        String tk = txt_tai_khoan.getText();
        String mkcu = txt_mk_cu.getText();
        String mkmoi = txt_mk_moi.getText();
        String xacnhan = txt_xac_nhan.getText();
        tai_khoan_model dn = tai_khoan_dao.gettk_dao().doiMK(tk, mkcu);
        if (dn == null) {

        } else {
            if (mkmoi.compareTo(xacnhan) == 0) {
                if (tai_khoan_dao.gettk_dao().sua(dn.getId(), mkmoi)) {
                    JOptionPane.showMessageDialog(tt_tai_khoan, "Đổi mật khẩu thành công");
                    txt_mk_cu.setText("");
                    txt_mk_moi.setText("");
                    txt_xac_nhan.setText("");
                } else {
                    JOptionPane.showMessageDialog(tt_tai_khoan, "Đổi mật khẩu không thành công");
                }
            } else {
                JOptionPane.showMessageDialog(tt_tai_khoan, "Đổi mật khẩu không thành công");
            }

        }
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_doi_mkActionPerformed

    private void btThemTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemTKActionPerformed
        if (txtTenDN.getText() == null || txtTenDN.getText().compareTo("") == 0
                || txtTK.getText() == null || txtTK.getText().compareTo("") == 0
                || txtMK.getText() == null || txtMK.getText().compareTo("") == 0 || cbChucVu.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(QL_tai_khoan, "Bạn chưa nhập đủ thông tin");
        } else {
            String tenDN = txtTenDN.getText();
            String tk = txtTK.getText();
            String mk = txtMK.getText();
            int quyen = 0;
            String chucvu = (String) cbChucVu.getSelectedItem();
            if (chucvu.compareTo("admin") == 0) {
                quyen = 1;
            } else {
                quyen = 2;
            }
            int kt = tai_khoan_control.getTKcon().themTK(tenDN, tk, mk, chucvu, quyen);
            if (kt == 1) {
                JOptionPane.showMessageDialog(QL_tai_khoan, "Thêm thành công");
                dstk = tai_khoan_dao.gettk_dao().taikhoanList();
                tai_khoan_control.getTKcon().load_list_tbl(tblTaiKhoan, dstk);
            } else {
                JOptionPane.showMessageDialog(QL_tai_khoan, "Thêm không thành công");
            }
        }
// TODO add your handling code here:
    }//GEN-LAST:event_btThemTKActionPerformed

    private void tblTaiKhoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTaiKhoanMouseClicked
        int index = tblTaiKhoan.getSelectedRow();
        txtTenDN.setText(dstk.get(index).getTendangnhap());
        txtTK.setText(dstk.get(index).getTaikhoan());
        txtMK.setText(dstk.get(index).getMatkhau());
        cbChucVu.setSelectedItem(dstk.get(index).getChucvu());
        // TODO add your handling code here:
    }//GEN-LAST:event_tblTaiKhoanMouseClicked

    private void btLuuTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLuuTKActionPerformed
        if (txtTenDN.getText() == null || txtTenDN.getText().compareTo("") == 0
                || txtTK.getText() == null || txtTK.getText().compareTo("") == 0
                || txtMK.getText() == null || txtMK.getText().compareTo("") == 0 || cbChucVu.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(QL_tai_khoan, "Bạn chưa nhập đử thông tin");
        } else {
            String tenDN = txtTenDN.getText();
            String tk = txtTK.getText();
            String mk = txtMK.getText();
            int quyen = 0;
            String chucvu = (String) cbChucVu.getSelectedItem();
            if (chucvu.compareTo("admin") == 0) {
                quyen = 1;
            } else {
                quyen = 2;
            }
            int kt = tai_khoan_control.getTKcon().luuTK(tenDN, tk, mk, chucvu, quyen);
            if (kt == 1) {
                JOptionPane.showMessageDialog(QL_tai_khoan, "Thêm thành công");
                dstk = tai_khoan_dao.gettk_dao().taikhoanList();
                tai_khoan_control.getTKcon().load_list_tbl(tblTaiKhoan, dstk);
            } else if (kt == 6) {
                JOptionPane.showMessageDialog(QL_tai_khoan, "Lưu thành công");
                dstk = tai_khoan_dao.gettk_dao().taikhoanList();
                tai_khoan_control.getTKcon().load_list_tbl(tblTaiKhoan, dstk);
            } else {
                JOptionPane.showMessageDialog(QL_tai_khoan, "Lưu không thành công");
            }
        }
// TODO add your handling code here:
    }//GEN-LAST:event_btLuuTKActionPerformed

    private void btXoaTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaTKActionPerformed
        String tenDN = txtTenDN.getText();
        tai_khoan_model tk = tai_khoan_dao.gettk_dao().kt_ten_dn(tenDN);
        if (tai_khoan_control.getTKcon().xoaTK(tk.getId())) {
            JOptionPane.showMessageDialog(QL_tai_khoan, "Xóa thành công");
            dstk = tai_khoan_dao.gettk_dao().taikhoanList();
            tai_khoan_control.getTKcon().load_list_tbl(tblTaiKhoan, dstk);
        } else {
            JOptionPane.showMessageDialog(QL_tai_khoan, "Xóa không thành công");
        }
// TODO add your handling code here:
    }//GEN-LAST:event_btXoaTKActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        int kt = JOptionPane.showConfirmDialog(rootPane, "Bạn chắc chắn muốn thoát", "Thông báo", JOptionPane.YES_NO_OPTION, JOptionPane.YES_NO_OPTION);
        if (kt == JOptionPane.YES_OPTION) {
            System.exit(0);
        } else {
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowClosing

    private void jCalendar2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jCalendar2PropertyChange
        //System.err.println(jCalendar2.getDate());
        // TODO add your handling code here:
    }//GEN-LAST:event_jCalendar2PropertyChange

    private void jCalendar1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jCalendar1PropertyChange
        //System.err.println(jCalendar1.getDate());
        // TODO add your handling code here:
    }//GEN-LAST:event_jCalendar1PropertyChange

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(fm_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fm_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fm_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fm_Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                        /**
                         * CDE/Motif Windows Windows Classic Metal Nimbus Dark
                         * Metal Dark Nimbus FlatLaf Light FlatLaf Dark
                         */
                        if ("Nimbus".equals(info.getName())) {
                            UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                fm_Main.getFmmain().setVisible(true);

                fm_Main.getFmmain().hien_thi.add(fm_Main.getFmmain().fm_dang_nhap);
                fm_Main.getFmmain().fm_dang_nhap.setVisible(true);
                fm_Main.getFmmain().bt_man_hinh_chinh.setBackground(cl);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog QL_tai_khoan;
    private javax.swing.JButton btLuuTK;
    private javax.swing.JButton btThemTK;
    private javax.swing.JButton btXoaTK;
    private javax.swing.JButton bt_QL_doc_gia;
    private javax.swing.JButton bt_QL_sach;
    private javax.swing.JButton bt_dang_nhap;
    private javax.swing.JButton bt_dang_xuat;
    private javax.swing.JButton bt_doi_mk;
    private javax.swing.JButton bt_man_hinh_chinh;
    private javax.swing.JButton bt_muon_tra;
    private javax.swing.JButton bt_ql_tai_khoan;
    private javax.swing.JButton bt_thong_ke;
    private javax.swing.JButton bt_tt_tk;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbChucVu;
    private javax.swing.JTextField chuc_vu;
    private javax.swing.JPanel fm_dang_nhap;
    private javax.swing.JPanel fm_quan_ly;
    private javax.swing.JPanel fm_thu_thu;
    private javax.swing.JPanel hien_thi;
    private com.toedter.calendar.JCalendar jCalendar1;
    private com.toedter.calendar.JCalendar jCalendar2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jp_dang_nhap;
    private javax.swing.JTable tblTaiKhoan;
    private javax.swing.JTextField ten_DN;
    private javax.swing.JDialog tt_tai_khoan;
    private javax.swing.JTextField txtMK;
    private javax.swing.JTextField txtTK;
    private javax.swing.JTextField txtTenDN;
    private javax.swing.JPasswordField txt_mat_khau;
    private javax.swing.JPasswordField txt_mk_cu;
    private javax.swing.JPasswordField txt_mk_moi;
    private javax.swing.JTextField txt_tai_khoan;
    private javax.swing.JTextField txt_ten_dn;
    private javax.swing.JTextField txt_tk_tt;
    private javax.swing.JPasswordField txt_xac_nhan;
    // End of variables declaration//GEN-END:variables
}
