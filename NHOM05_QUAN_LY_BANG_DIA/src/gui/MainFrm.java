package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entity.NhanVien;
import entity.TaiKhoan;
import gui.MainFrm;
import utils.MaterialDesign;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.SystemColor;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;

public class MainFrm extends JFrame implements ActionListener, MouseListener{

	private JPanel contentPane;
	public static JTextField textField, txtTen;
	private JPanel panelMenu;
	public static JButton btnTrangChu, btnDangNhap, btnDangXuat;
	public static JButton btnQuanLyChoThue;
	public static JButton btnQuanLBangDia;
	public static JButton btnQuanLyKhachHang;
	public static JButton btnBaoCaoDVDvaTieuDe;
	public static JButton btnDatTruocTieuDeDVD, btnThanhToan;
	private JPanel panelHeader;
	private JPanel panelContent;
	private static JTabbedPane tabbedPane;
	
	private NhanVien nhanVien;
	private DangNhap dn;
	private TaiKhoan taiKhoan;
    
	private TrangChuTabbed trangChu = new TrangChuTabbed();
    private QuanLyChoThueTabbed quanLyChoThue = new QuanLyChoThueTabbed();
	public static DangNhap loginFrame = new DangNhap();
	private QuanLyBangDiaTabbed quanLyBangDia = new QuanLyBangDiaTabbed();
	private QuanLyKhachHangTabbed quanLiKhachHang = new QuanLyKhachHangTabbed();
	private QuanLyNhanVienTabbed quanLyNhanVien = new QuanLyNhanVienTabbed();
	private ThongKeTabbed thongKe=new ThongKeTabbed();
	private CaiDatTabbed caiDat=new CaiDatTabbed();
	
	private JLabel lblTenUngDung;
	private JLabel lblNewLabel = new JLabel("");

//	private  QuanLiKhachHangFrame quanLiKhachHangFrame = new QuanLiKhachHangFrame();
	/**
	 * Launch the application.y
	 */
	public MainFrm() {
        // hiển thị form
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                prepareUI();                
                Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
//                int width = (int) (screenSize.getWidth() * 0.9);
//                int height = (int) (screenSize.getHeight() * 0.9);
//                setSize(width, height);
//                setExtendedState(JFrame.MAXIMIZED_BOTH);
                setDefaultCloseOperation(EXIT_ON_CLOSE);
                setLocationRelativeTo(null);
                setTitle("Hệ thống quản lý cửa hàng thuê băng đĩa / Trang chủ");
                setVisible(true);
            }
        });
    }
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MainFrm frame = new MainFrm();
//					frame.setVisible(true);
//					frame.setLocationRelativeTo(null);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public void prepareUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1379, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelMenu = new JPanel();
		panelMenu.setBackground(new Color(145, 102, 72));
		panelMenu.setBorder(null);
		panelMenu.setBounds(0, 97, 256, 609);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		setResizable(false);

		btnTrangChu = new JButton("Trang chủ");
		btnTrangChu.doClick();
		btnTrangChu.setIcon(MaterialDesign.ICON_TC);
		btnTrangChu.setForeground(Color.WHITE);
		btnTrangChu.setHorizontalAlignment(SwingConstants.LEFT);
		btnTrangChu.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnTrangChu.setBackground(new java.awt.Color(145, 102, 72));
		btnTrangChu.setBounds(0, 0, 256, 99);
		panelMenu.add(btnTrangChu);

		btnQuanLyChoThue = new JButton("Quản lý cho thuê");
		btnQuanLyChoThue.setIcon(MaterialDesign.ICON_CHOTHUE);
		btnQuanLyChoThue.setForeground(Color.WHITE);
		btnQuanLyChoThue.setHorizontalAlignment(SwingConstants.LEFT);
		btnQuanLyChoThue.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnQuanLyChoThue.setBackground(new java.awt.Color(145, 102, 72));
		btnQuanLyChoThue.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnQuanLyChoThue.setBounds(0, 94, 256, 87);
		panelMenu.add(btnQuanLyChoThue);

		btnQuanLBangDia = new JButton("Quản lý băng đĩa");
		btnQuanLBangDia.setIcon(MaterialDesign.ICON_BANGDIA);
		btnQuanLBangDia.setEnabled(true);
		btnQuanLBangDia.setForeground(Color.WHITE);
		btnQuanLBangDia.setHorizontalAlignment(SwingConstants.LEFT);
		btnQuanLBangDia.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnQuanLBangDia.setBackground(new java.awt.Color(145, 102, 72));
		btnQuanLBangDia.setBounds(0, 175, 256, 93);
		panelMenu.add(btnQuanLBangDia);

		btnQuanLyKhachHang = new JButton("Quản lý khách hàng");
		btnQuanLyKhachHang.setIcon(MaterialDesign.ICON_KH);
		btnQuanLyKhachHang.setForeground(Color.WHITE);
		btnQuanLyKhachHang.setHorizontalAlignment(SwingConstants.LEFT);
		btnQuanLyKhachHang.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnQuanLyKhachHang.setBackground(new java.awt.Color(145, 102, 72));
		btnQuanLyKhachHang.setBounds(0, 263, 256, 87);
		panelMenu.add(btnQuanLyKhachHang);

		btnBaoCaoDVDvaTieuDe = new JButton("Quản lý nhân viên");
		btnBaoCaoDVDvaTieuDe.setIcon(MaterialDesign.ICON_NV);
		btnBaoCaoDVDvaTieuDe.setForeground(Color.WHITE);
		btnBaoCaoDVDvaTieuDe.setHorizontalAlignment(SwingConstants.LEFT);
		btnBaoCaoDVDvaTieuDe.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBaoCaoDVDvaTieuDe.setBackground(new java.awt.Color(145, 102, 72));
		btnBaoCaoDVDvaTieuDe.setBounds(0, 345, 256, 87);
		panelMenu.add(btnBaoCaoDVDvaTieuDe);

		btnDatTruocTieuDeDVD = new JButton("Thống kê");
		btnDatTruocTieuDeDVD.setIcon(MaterialDesign.ICON_TK);
		btnDatTruocTieuDeDVD.setForeground(Color.WHITE);
		btnDatTruocTieuDeDVD.setHorizontalAlignment(SwingConstants.LEFT);
		btnDatTruocTieuDeDVD.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDatTruocTieuDeDVD.setBackground(new java.awt.Color(145, 102, 72));
		btnDatTruocTieuDeDVD.setBounds(0, 423, 256, 87);
		panelMenu.add(btnDatTruocTieuDeDVD);

		btnThanhToan = new JButton("Cài đặt");
		btnThanhToan.setIcon(MaterialDesign.ICON_CAIDAT);
		btnThanhToan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnThanhToan.setHorizontalAlignment(SwingConstants.LEFT);
		btnThanhToan.setForeground(Color.WHITE);
		btnThanhToan.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnThanhToan.setBackground(new Color(145, 102, 72));
		btnThanhToan.setBounds(0, 500, 256, 87);
		panelMenu.add(btnThanhToan);

		panelHeader = new JPanel();
		panelHeader.setBackground(new java.awt.Color(145, 102, 72));
		panelHeader.setBounds(0, 0, 1382, 97);
		contentPane.add(panelHeader);
		panelHeader.setLayout(null);

		lblTenUngDung = new JLabel("ỨNG DỤNG QUẢN LÝ CHO THUÊ BĂNG ĐĨA");
		lblTenUngDung.setIcon(MaterialDesign.ICON_MAIN);
		lblTenUngDung.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTenUngDung.setForeground(Color.WHITE);
		lblTenUngDung.setBounds(498, 24, 600, 50);
		panelHeader.add(lblTenUngDung);

		btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.setForeground(Color.WHITE);
		btnDangNhap.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDangNhap.setBackground(Color.BLUE);
		btnDangNhap.setBounds(12, 13, 119, 25);
		panelHeader.add(btnDangNhap);

		btnDangXuat = new JButton("Đăng xuất");
		btnDangXuat.setEnabled(true);
		btnDangXuat.setForeground(Color.WHITE);
		btnDangXuat.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnDangXuat.setBackground(Color.RED);
		btnDangXuat.setBounds(12, 51, 119, 25);
		panelHeader.add(btnDangXuat);

//		txtTen = new JTextField();
//		txtTen.setFont(new Font("Tahoma", Font.PLAIN, 17));
//		txtTen.setForeground(Color.RED);
//		txtTen.setEnabled(false);
//		txtTen.setBounds(139, 13, 150, 30);
//		panelHeader.add(txtTen);
//		txtTen.setColumns(10);

		panelContent = new JPanel();
		panelContent.setBackground(SystemColor.control);
		panelContent.setBounds(255, 97, 1115, 610);
		contentPane.add(panelContent);
		contentPane.setBackground(new java.awt.Color(244, 204, 153));
		panelContent.setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		tabbedPane.setBackground(new java.awt.Color(244, 204, 153));
		tabbedPane.setBounds(0, -35, 1110, 620);
		panelContent.add(tabbedPane);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.ORANGE);
		lblNewLabel.setIcon(MaterialDesign.ICON_TCMAIN);
		lblNewLabel.setBounds(380, 111, 550, 402);
		tabbedPane.add(lblNewLabel);

		btnTrangChu.addActionListener(this);
		btnDatTruocTieuDeDVD.addActionListener(this);
		btnQuanLBangDia.addActionListener(this);
		btnQuanLyChoThue.addActionListener(this);
		btnBaoCaoDVDvaTieuDe.addActionListener(this);
		btnQuanLyKhachHang.addActionListener(this);
		btnThanhToan.addActionListener(this);
		btnDangNhap.addActionListener(this);
		btnDangXuat.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object obj = e.getSource();
		
		if (obj.equals(btnQuanLyChoThue)) {
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			tabbedPane.add(quanLyChoThue);
		}
		else if(obj.equals(btnTrangChu)) {
			
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			lblNewLabel.setIcon(new ImageIcon(MainFrm.class.getResource("/images/R.png")));
			lblNewLabel.setBounds(372, 111, 480, 402);
			tabbedPane.add(lblNewLabel);
			panelContent.setVisible(true);
		
		}
		else if(obj.equals(btnQuanLBangDia)) {
			
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			tabbedPane.add(quanLyBangDia);
		
		}
		else if(obj.equals(btnQuanLyKhachHang)) {
			
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			tabbedPane.add(quanLiKhachHang);
		
		}
		else if(obj.equals(btnBaoCaoDVDvaTieuDe)) {
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			tabbedPane.add(quanLyNhanVien);
		
		}
		else if(obj.equals(btnDatTruocTieuDeDVD)) {
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			tabbedPane.add(thongKe);
		
		}else if(obj.equals(btnThanhToan)) {
			tabbedPane.remove(tabbedPane.getSelectedComponent());
			tabbedPane.add(caiDat);		
		}
		else if(obj.equals(btnDangNhap)) {
			loginFrame.setLocationRelativeTo(null);
			loginFrame.setVisible(true);
		}
		else if(obj.equals(btnDangXuat)) {
			// dialog xác nhận đăng xuất
            ThongBaoDialog thongBaoDialog = new ThongBaoDialog(
                    new JFrame(),
                    "Cảnh báo",
                    "Bạn có muốn đăng xuất khỏi phiên người dùng này không ?",
                    ThongBaoDialog.OK_CANCLE_OPTION
            );

            // nếu người dùng đồng ý đang xuất
            if (thongBaoDialog.getKetQua() == ThongBaoDialog.OK_OPTION) {
                setVisible(false);
                new DangNhap();
            }
		}

	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
	
//	public void hienThiTenDangNhap(TaiKhoan tk) {
//		txtTen.setText(DangNhap.taiKhoan.getTenTaiKhoan());
//		System.out.println(txtTen.getText());
//		
//	}

}
