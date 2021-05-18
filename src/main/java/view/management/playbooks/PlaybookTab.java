package view.management.playbooks;

import burp.IBurpExtenderCallbacks;
import burp.IExtensionHelpers;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import view.FathersComponentTab;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.FontUIResource;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.util.Locale;

public class PlaybookTab extends FathersComponentTab {

    private JTable tblInProgressPlaybooks;
    private JTable tblNotStartedPlaybooks;
    private JTable tbDonePlaybooks;
    private JPanel rootPanel;

    public PlaybookTab(final IBurpExtenderCallbacks callbacks, final IExtensionHelpers helpers) {
        super.newTab(callbacks, helpers);
    }

    public void initializeComponent() {


        // GUI initializer generated by IntelliJ IDEA GUI Designer
        // >>> IMPORTANT!! <<<
        // DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();

        this.initializePlaybooksTables();
    }

    private void initializePlaybooksTables() {
        this.addColumnToColumnModel(tblInProgressPlaybooks.getColumnModel(), "Title");
        this.addColumnToColumnModel(tblInProgressPlaybooks.getColumnModel(), "Last change");
        this.addColumnToColumnModel(tblInProgressPlaybooks.getColumnModel(), "Analyst");
        this.addColumnToColumnModel(tblInProgressPlaybooks.getColumnModel(), "Evidence");
        this.addColumnToColumnModel(tblInProgressPlaybooks.getColumnModel(), "Actions");

        this.addColumnToColumnModel(tblNotStartedPlaybooks.getColumnModel(), "Title");
        this.addColumnToColumnModel(tblNotStartedPlaybooks.getColumnModel(), "Last change");
        this.addColumnToColumnModel(tblNotStartedPlaybooks.getColumnModel(), "Analyst");
        this.addColumnToColumnModel(tblNotStartedPlaybooks.getColumnModel(), "Evidence");
        this.addColumnToColumnModel(tblNotStartedPlaybooks.getColumnModel(), "Actions");

        this.addColumnToColumnModel(tbDonePlaybooks.getColumnModel(), "Title");
        this.addColumnToColumnModel(tbDonePlaybooks.getColumnModel(), "Last change");
        this.addColumnToColumnModel(tbDonePlaybooks.getColumnModel(), "Analyst");
        this.addColumnToColumnModel(tbDonePlaybooks.getColumnModel(), "Evidence");
        this.addColumnToColumnModel(tbDonePlaybooks.getColumnModel(), "Actions");
    }

    private void addColumnToColumnModel(TableColumnModel tblColumnModel, String title) {
        TableColumn t = new TableColumn();
        t.setHeaderValue(title);
        tblColumnModel.addColumn(t);
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        rootPanel = new JPanel();
        rootPanel.setLayout(new FormLayout("fill:d:grow", "center:9px:noGrow,top:4dlu:noGrow,center:max(d;4px):noGrow,top:11dlu:noGrow,center:232px:noGrow,top:11dlu:noGrow,center:max(d;4px):noGrow"));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new FormLayout("fill:37px:noGrow,left:4dlu:noGrow,fill:481px:grow,left:83dlu:noGrow,fill:max(d;4px):noGrow,left:4dlu:noGrow,fill:max(d;4px):noGrow", "center:27px:noGrow,top:4dlu:noGrow,fill:194px:noGrow"));
        CellConstraints cc = new CellConstraints();
        rootPanel.add(panel1, cc.xy(1, 3));
        final JLabel label1 = new JLabel();
        Font label1Font = this.$$$getFont$$$(null, Font.BOLD, -1, label1.getFont());
        if (label1Font != null) label1.setFont(label1Font);
        label1.setText("In progress");
        panel1.add(label1, cc.xy(3, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
        final JScrollPane scrollPane1 = new JScrollPane();
        panel1.add(scrollPane1, cc.xy(3, 3, CellConstraints.FILL, CellConstraints.FILL));
        scrollPane1.setBorder(BorderFactory.createTitledBorder(null, "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        tblInProgressPlaybooks = new JTable();
        scrollPane1.setViewportView(tblInProgressPlaybooks);
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new FormLayout("fill:max(d;4px):noGrow,left:4dlu:noGrow,fill:d:noGrow", "center:d:grow,top:4dlu:noGrow,center:max(d;4px):grow"));
        panel1.add(panel2, cc.xy(4, 3));
        final JButton button1 = new JButton();
        button1.setText("Define");
        panel2.add(button1, cc.xy(3, 1, CellConstraints.DEFAULT, CellConstraints.BOTTOM));
        final JButton button2 = new JButton();
        button2.setText("Button");
        panel2.add(button2, cc.xy(3, 3, CellConstraints.DEFAULT, CellConstraints.TOP));
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new FormLayout("fill:37px:noGrow,left:4dlu:noGrow,fill:481px:grow,left:83dlu:noGrow,fill:max(d;4px):noGrow,left:4dlu:noGrow,fill:max(d;4px):noGrow", "center:27px:noGrow,top:4dlu:noGrow,fill:194px:noGrow"));
        rootPanel.add(panel3, cc.xy(1, 5));
        final JLabel label2 = new JLabel();
        Font label2Font = this.$$$getFont$$$(null, Font.BOLD, -1, label2.getFont());
        if (label2Font != null) label2.setFont(label2Font);
        label2.setText("Not started");
        panel3.add(label2, cc.xy(3, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
        final JScrollPane scrollPane2 = new JScrollPane();
        panel3.add(scrollPane2, cc.xy(3, 3, CellConstraints.FILL, CellConstraints.FILL));
        scrollPane2.setBorder(BorderFactory.createTitledBorder(null, "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        tblNotStartedPlaybooks = new JTable();
        scrollPane2.setViewportView(tblNotStartedPlaybooks);
        final JPanel panel4 = new JPanel();
        panel4.setLayout(new FormLayout("fill:max(d;4px):noGrow,left:4dlu:noGrow,fill:d:noGrow", "center:d:grow,top:4dlu:noGrow,center:max(d;4px):grow"));
        panel3.add(panel4, cc.xy(4, 3));
        final JButton button3 = new JButton();
        button3.setText("Define");
        panel4.add(button3, cc.xy(3, 1, CellConstraints.DEFAULT, CellConstraints.BOTTOM));
        final JButton button4 = new JButton();
        button4.setText("Button");
        panel4.add(button4, cc.xy(3, 3, CellConstraints.DEFAULT, CellConstraints.TOP));
        final JPanel panel5 = new JPanel();
        panel5.setLayout(new FormLayout("fill:37px:noGrow,left:4dlu:noGrow,fill:481px:grow,left:83dlu:noGrow,fill:max(d;4px):noGrow,left:4dlu:noGrow,fill:max(d;4px):noGrow", "center:27px:noGrow,top:4dlu:noGrow,fill:194px:noGrow"));
        rootPanel.add(panel5, cc.xy(1, 7));
        final JLabel label3 = new JLabel();
        Font label3Font = this.$$$getFont$$$(null, Font.BOLD, -1, label3.getFont());
        if (label3Font != null) label3.setFont(label3Font);
        label3.setText("Done");
        panel5.add(label3, cc.xy(3, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
        final JScrollPane scrollPane3 = new JScrollPane();
        panel5.add(scrollPane3, cc.xy(3, 3, CellConstraints.FILL, CellConstraints.FILL));
        scrollPane3.setBorder(BorderFactory.createTitledBorder(null, "", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, null, null));
        tbDonePlaybooks = new JTable();
        scrollPane3.setViewportView(tbDonePlaybooks);
        final JPanel panel6 = new JPanel();
        panel6.setLayout(new FormLayout("fill:max(d;4px):noGrow,left:4dlu:noGrow,fill:d:noGrow", "center:d:grow,top:4dlu:noGrow,center:max(d;4px):grow"));
        panel5.add(panel6, cc.xy(4, 3));
        final JButton button5 = new JButton();
        button5.setText("Define");
        panel6.add(button5, cc.xy(3, 1, CellConstraints.DEFAULT, CellConstraints.BOTTOM));
        final JButton button6 = new JButton();
        button6.setText("Button");
        panel6.add(button6, cc.xy(3, 3, CellConstraints.DEFAULT, CellConstraints.TOP));
    }

    /**
     * @noinspection ALL
     */
    private Font $$$getFont$$$(String fontName, int style, int size, Font currentFont) {
        if (currentFont == null) return null;
        String resultName;
        if (fontName == null) {
            resultName = currentFont.getName();
        } else {
            Font testFont = new Font(fontName, Font.PLAIN, 10);
            if (testFont.canDisplay('a') && testFont.canDisplay('1')) {
                resultName = fontName;
            } else {
                resultName = currentFont.getName();
            }
        }
        Font font = new Font(resultName, style >= 0 ? style : currentFont.getStyle(), size >= 0 ? size : currentFont.getSize());
        boolean isMac = System.getProperty("os.name", "").toLowerCase(Locale.ENGLISH).startsWith("mac");
        Font fontWithFallback = isMac ? new Font(font.getFamily(), font.getStyle(), font.getSize()) : new StyleContext().getFont(font.getFamily(), font.getStyle(), font.getSize());
        return fontWithFallback instanceof FontUIResource ? fontWithFallback : new FontUIResource(fontWithFallback);
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return rootPanel;
    }

}
