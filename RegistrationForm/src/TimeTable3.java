


import java.awt.FlowLayout;
        import java.awt.GridLayout;
        import java.awt.event.WindowAdapter;
        import java.awt.event.WindowEvent;

        import javax.swing.JFrame;
        import javax.swing.JLabel;
        import javax.swing.JPanel;
        import javax.swing.JScrollPane;
        import javax.swing.JTable;

public class TimeTable3{
    private JFrame mainFrame;
    private JLabel headerLabel;
    private JLabel statusLabel;
    private JPanel controlPanel;

    public TimeTable3(){
        prepareGUI();
    }
    public static void main(String[] args){
        TimeTable3 swingControlDemo = new TimeTable3();
        swingControlDemo.showTableDemo();
    }
    private void prepareGUI(){
        mainFrame = new JFrame("students time Table ");
        mainFrame.setSize(1000,900);
        mainFrame.setLayout(new GridLayout(3, 1));

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }
        });
        headerLabel = new JLabel("", JLabel.CENTER);
        statusLabel = new JLabel("",JLabel.CENTER);
        statusLabel.setSize(3500,1000);

        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());

        mainFrame.add(headerLabel);
        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }
    private void showTableDemo(){
        headerLabel.setText("P.3 time table");

        String[] columnNames = {"Day","class","8:00 am-8:30 am", "8:30 am - 10:00 am","10:00 am-10:30 am","10:30 am-11:30 pm","11:30 am-1:00 pm","1:00 pm-2:00 pm","2:00 pm -4:00 pm"};
        Object[][] data = {
                {"Monday","p.3","assembly", "science","Break","math","English","Lunch","SST"},
                {"Tuesday","p.3","assembly", "science","Break","math","English","Lunch","SST"},
                {"Wednesday","p.3","assembly", "science","Break","math","English","Lunch","SST"},
                {"Thursday","p.3","assembly", "science","Break","math","English","Lunch","SST"},
                {"Friday","p.3","assembly", "science","Break","math","English","Lunch","SST"}

        };
        JTable table = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setSize(600, 600);
        table.setFillsViewportHeight(true);
        controlPanel.add(scrollPane);
        mainFrame.setVisible(true);
    }
}

