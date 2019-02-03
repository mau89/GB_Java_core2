import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interface extends JFrame {

    private JTextField textField;
    private JButton button;
    private JList<String> list;
    private DefaultListModel<String> listModel;
    private JPanel panel, panel1;
    private JMenuBar jMenuBar;
    private JMenu menuFile;
    private JMenuItem menuExit;

    public Interface() {
        setTitle("Главное окно");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(200, 200, 500, 500);
        setLayout(new BorderLayout());   // выбор компоновщика элементов
        listModel = new DefaultListModel();
        list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jMenuBar = new JMenuBar();
        menuFile = new JMenu("File");
        jMenuBar.add(menuFile);
        menuExit = new JMenuItem("Exit");
        menuExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] options = {"Да", "Нет!"};
                int n = JOptionPane
                        .showOptionDialog(null, "Закрыть окно?",
                                "Подтверждение", JOptionPane.YES_NO_OPTION,
                                JOptionPane.QUESTION_MESSAGE, null, options,
                                options[0]);
                if (n == 0) {
                    System.exit(0);
                }
            }
        });
        menuFile.add(menuExit);
        add(jMenuBar, BorderLayout.NORTH);
        panel1 = new JPanel();
        panel1.setLayout(new BorderLayout());
        panel1.add(list, BorderLayout.SOUTH);
        JScrollPane scrollPane = new JScrollPane(panel1);

        textField = new JTextField();

        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
                listModel.insertElementAt(textField.getText(), listModel.size());
                int lastNdx = listModel.getSize() - 1;
                list.ensureIndexIsVisible(lastNdx);
                textField.setText("");
            }
        });
        button = new JButton("Send");
        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                list.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
                listModel.insertElementAt(textField.getText(), listModel.size());
                int lastNdx = listModel.getSize() - 1;
                list.ensureIndexIsVisible(lastNdx);
                textField.setText("");
            }
        });

        panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(button, BorderLayout.EAST);
        panel.add(textField, BorderLayout.CENTER);

        add(scrollPane, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        setVisible(true);
    }
}

