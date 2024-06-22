package com.fatin.sortSpectra;

/**
 *
 * @author MOHAMMAD FATIN NUR
 */

 import java.awt.*;
 import java.awt.event.*;
 import javax.swing.*;
 import javax.swing.event.*;
 
 public class Frame extends JFrame {
     public String[] Sorts = {"Bubble Sort", "Selection Sort", "Insertion Sort"};
 
     public int heightConst;
     public JPanel mainPanel, graph, sidebar;
     public JPanel[] bar;
     public JButton start;
     public JComboBox<String> dropDown;
     public JSlider speedSlider, arrSzSlider;
     public JLabel speedVal, aarrSz;
     public GridBagConstraints c;
     public ImageIcon logo;
 
     public Frame() {
        super("Sort Spectra");
        logo = new ImageIcon(getClass().getResource("resources/logo.png"));
        setIconImage(logo.getImage());
 
        start = new JButton("Let's Go!");
        sidebar = new JPanel();
        graph = new JPanel();
        mainPanel = new JPanel();
        dropDown = new JComboBox<String>();
        speedSlider = new JSlider(1, 1000, 30);
        arrSzSlider = new JSlider(5, 100, 15);
        speedVal = new JLabel("Speed: 30ms");
        aarrSz = new JLabel("Array Size: 15");
        c = new GridBagConstraints();

        for (String s : Sorts) dropDown.addItem(s);

        graph.setLayout(new GridBagLayout());
        mainPanel.setLayout(new BorderLayout());

        c.insets = new Insets(0, 2, 0, 2);
        c.anchor = GridBagConstraints.SOUTH;

        start.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Sort_Spectra.startSort((String) dropDown.getSelectedItem());
            }
        });

        speedSlider.setMinorTickSpacing(10);
        speedSlider.setMajorTickSpacing(1000);
        speedSlider.setPaintTicks(true);

        speedSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent arg0) {
                speedVal.setText("Speed: " + speedSlider.getValue() + "ms");
                validate();
                Sort_Spectra.wait = speedSlider.getValue();
            }
        });

        arrSzSlider.setMinorTickSpacing(1);
        arrSzSlider.setMajorTickSpacing(100);
        arrSzSlider.setPaintTicks(true);

        arrSzSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent arg0) {
                aarrSz.setText("Array Size: " + arrSzSlider.getValue());
                validate();
                Sort_Spectra.cnt = arrSzSlider.getValue();
            }
        });

        sidebar.setLayout(new GridLayout(7, 1,0,10));
        speedVal.setHorizontalAlignment(SwingConstants.CENTER);
        speedVal.setVerticalAlignment(SwingConstants.NORTH);
        aarrSz.setHorizontalAlignment(SwingConstants.CENTER);
        aarrSz.setVerticalAlignment(SwingConstants.NORTH);
        speedVal.setForeground(new Color(0xFAF0E6));
        aarrSz.setForeground(new Color(0xFAF0E6));
        speedVal.setFont(new Font("Arial", Font.BOLD, 20));
        aarrSz.setFont(new Font("Arial", Font.BOLD, 20));
        speedVal.setPreferredSize(new Dimension(300, 50));
        aarrSz.setPreferredSize(new Dimension(300, 50));
        start.setPreferredSize(new Dimension(300, 50));
        dropDown.setPreferredSize(new Dimension(300, 50));
        speedSlider.setPreferredSize(new Dimension(300, 50));
        arrSzSlider.setPreferredSize(new Dimension(300, 50));
        start.setBackground(new Color(0xDC5F00));
        dropDown.setBackground(new Color(0x1B1A55));
        speedSlider.setBackground(new Color(0x1B1A55));
        arrSzSlider.setBackground(new Color(0x1B1A55));
        start.setForeground(new Color(0xFAF0E6));
        dropDown.setForeground(new Color(0xFAF0E6));
        speedSlider.setForeground(new Color(0xFAF0E6));
        arrSzSlider.setForeground(new Color(0xFAF0E6));
        start.setFont(new Font("Arial", Font.BOLD, 20));
        dropDown.setFont(new Font("Arial", Font.BOLD, 20));
        speedSlider.setFont(new Font("Arial", Font.BOLD, 20));
        arrSzSlider.setFont(new Font("Arial", Font.BOLD, 20));
        start.setBorder(BorderFactory.createLineBorder(new Color(0x1B1A55)));
        dropDown.setBorder(BorderFactory.createLineBorder(new Color(0x1B1A55)));
        speedSlider.setBorder(BorderFactory.createLineBorder(new Color(0x1B1A55)));
        arrSzSlider.setBorder(BorderFactory.createLineBorder(new Color(0x1B1A55)));
        start.setFocusPainted(false);
        dropDown.setFocusable(false);
        speedSlider.setFocusable(false);
        arrSzSlider.setFocusable(false);
        start.setContentAreaFilled(false);
        start.setOpaque(true);
        // start.setBorderPainted(false);
        start.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                start.setBackground(new Color(0xA13333));
            }
            public void mouseEntered(MouseEvent e) {
                start.setBackground(new Color(0x4E9F3D));
            }
            public void mouseExited(MouseEvent e) {
                start.setBackground(new Color(0xDC5F00));
            }
        });
        sidebar.add(speedSlider);
        sidebar.add(speedVal);
        sidebar.add(arrSzSlider);
        sidebar.add(aarrSz);
        sidebar.add(dropDown);
        sidebar.add(start);
        sidebar.setBackground(new Color(0x1B1A55));
        sidebar.setPreferredSize(new Dimension(300, mainPanel.getHeight()));

        mainPanel.add(sidebar, BorderLayout.WEST);
        mainPanel.add(graph);
        graph.setBackground(new Color(0x070F2B));

        add(mainPanel);

        // setExtendedState(JFrame.MAXIMIZED_BOTH);
        Popup();
        setSize(1285, 675);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void Popup() {
        JDialog startupDialog = new JDialog(this, "Important Message!", true);
        startupDialog.setLayout(new GridBagLayout());
        startupDialog.setSize(1080, 600);
        startupDialog.setLocationRelativeTo(this);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.BOTH;
        // gbc.insets = new Insets(10, 10, 10, 10);

        ImageIcon imageIcon = new ImageIcon(getClass().getResource("resources/splash.png"));
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setBackground(new Color(0x1B1A55));
        imageLabel.setOpaque(true);

        gbc.weightx = 1.0;
        gbc.weighty = 0.8;
        startupDialog.add(imageLabel, gbc);

        JButton continueButton = new JButton("Click here to continue");
        continueButton.addActionListener(e -> startupDialog.dispose());
        continueButton.setBackground(new Color(0x1B1A55));
        continueButton.setForeground(new Color(0xFAF0E6));
        continueButton.setFont(new Font("Arial", Font.BOLD, 20));
        continueButton.setBorder(BorderFactory.createLineBorder(new Color(0x1B1A55)));
        continueButton.setFocusPainted(false);
        continueButton.setContentAreaFilled(false);
        continueButton.setOpaque(true);
        continueButton.setBorderPainted(false);
        continueButton.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                continueButton.setBackground(new Color(0xDC5F00));
            }
            public void mouseEntered(MouseEvent e) {
                continueButton.setBackground(new Color(0xDC5F00));
            }
            public void mouseExited(MouseEvent e) {
                continueButton.setBackground(new Color(0x1B1A55));
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(continueButton);
        buttonPanel.setBackground(new Color(0x1B1A55));
        gbc.weighty = 0.2;
        startupDialog.add(buttonPanel, gbc);

        startupDialog.setVisible(true);
    }

    public void Draw(Integer[] arr) {
        bar = new JPanel[Sort_Spectra.cnt];
        graph.removeAll();
        heightConst = (int) ((getHeight() * 0.9) / (bar.length));
        for (int i = 0; i < Sort_Spectra.cnt; i++) {
            bar[i] = new JPanel();
            bar[i].setPreferredSize(new Dimension(Sort_Spectra.barWidth, arr[i] * heightConst));
            bar[i].setBackground(new Color(0x1679AB));
            graph.add(bar[i], c);
        }
        repaint();
        validate();
    }

    public void finalDraw(Integer[] arr, int j) {
        graph.removeAll();
        for (int i = 0; i < bar.length; i++) {
            bar[i] = new JPanel();
            bar[i].setPreferredSize(new Dimension(Sort_Spectra.barWidth, arr[i] * heightConst));
            if(i<=j )bar[i].setBackground(new Color(0x535C91));
            else bar[i].setBackground(new Color(0x1679AB));
            graph.add(bar[i], c);

        }
        repaint();
        validate();
    }

    public void reDraw(Integer[] arr, int green, int red) {
        graph.removeAll();
        for (int i = 0; i < bar.length; i++) {
            bar[i] = new JPanel();
            bar[i].setPreferredSize(new Dimension(Sort_Spectra.barWidth, arr[i] * heightConst));
            if (i == green) {
                bar[i].setBackground(new Color(0x4E9F3D));
            } else if (i == red) {
                bar[i].setBackground(new Color(0xA13333));
            } else {
                bar[i].setBackground(new Color(0x1679AB));
            }
            graph.add(bar[i], c);
        }
        repaint();
        validate();
    }
}