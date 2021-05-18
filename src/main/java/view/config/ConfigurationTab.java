package view.config;

import burp.IBurpExtenderCallbacks;
import burp.IExtensionHelpers;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import http.HttpClient;
import view.FathersComponentTab;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import javax.swing.text.StyleContext;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Locale;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ConfigurationTab extends FathersComponentTab {
    private JTextField txtFlowApiKey;
    private JPanel rootPanel;
    private JButton btnApiKey;
    private JTextField txtProjectId;
    private JButton defineButton;
    private static final String FLOW_API_KEY = "FLOW.API.KEY";
    private static final String FLOW_PROJECT_ID = "FLOW.PROJECT.ID";


    boolean isDarkBackground = false;

    public ConfigurationTab(final IBurpExtenderCallbacks callbacks, final IExtensionHelpers helpers) {
        this.newTab(callbacks, helpers);
    }

    public void initializeComponent() {
        // GUI initializer generated by IntelliJ IDEA GUI Designer
        // >>> IMPORTANT!! <<<
        // DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();

        this.setTxtFlowApiKey(callbacks);
        this.setTxtProjectId(callbacks);

        this.setRootPanel(rootPanel);
        this.setDefaultColors(btnApiKey);

        txtFlowApiKey.addKeyListener(new KeyAdapter() { // Evento para receber a API Key do txtField
            @Override
            public void keyReleased(KeyEvent e) {
                if (!txtFlowApiKey.getText().trim().equals("") && (txtFlowApiKey.getText().length() >= 40) && (txtFlowApiKey.getText().length() <= 50)) {
                    callbacks.saveExtensionSetting(FLOW_API_KEY, txtFlowApiKey.getText().trim());
                    txtFlowApiKey.setBackground(defaultBackgroundBtn);
                } else {
                    txtFlowApiKey.setBackground(Color.RED);
                }
            }
        });

        btnApiKey.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new Thread(() -> {
                    if (txtFlowApiKey.getText().isEmpty()) {
                        JOptionPane.showMessageDialog(rootPanel, "Please define API Key!");
                        return;
                    }
                    btnApiKey.setEnabled(false);
                    HttpClient httpClient = new HttpClient(callbacks, helpers);
                    if (httpClient.testApiKey()) {
                        btnApiKey.setForeground(Color.GREEN);
                        btnApiKey.setText("OK!");
                        btnApiKey.setBackground(Color.darkGray);
                    } else {
                        btnApiKey.setForeground(Color.RED);
                        btnApiKey.setText("Failed!");
                        btnApiKey.setBackground(Color.darkGray);
                    }
                    btnApiKey.setEnabled(true);

                    final ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
                    executor.schedule(() -> {
                        btnApiKey.setForeground(defaultForegroundBtn);
                        btnApiKey.setBackground(defaultBackgroundBtn);
                        btnApiKey.setText("Test");
                    }, 10, TimeUnit.SECONDS);
                }).start();
            }
        });

        defineButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    if (Integer.parseInt(txtProjectId.getText()) != 0) {
                        callbacks.saveExtensionSetting(FLOW_PROJECT_ID, txtProjectId.getText().trim());
                        JOptionPane.showMessageDialog(rootPanel, "Defined!");
                    }
                } catch (NumberFormatException err) {
                    JOptionPane.showMessageDialog(rootPanel, "Please define Project ID!");
                }
            }
        });
    }

    private void setTxtFlowApiKey(IBurpExtenderCallbacks callbacks) { // Definir a key no txtField
        String API_KEY = callbacks.loadExtensionSetting(FLOW_API_KEY);
        if (API_KEY != null) {
            txtFlowApiKey.setText(API_KEY);
        }
    }

    private void setTxtProjectId(IBurpExtenderCallbacks callbacks) { // Definir a key no txtField
        String PROJECT_ID = callbacks.loadExtensionSetting(FLOW_PROJECT_ID);
        if (PROJECT_ID != null) {
            txtProjectId.setText(PROJECT_ID);
        }
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
        rootPanel.setLayout(new GridLayoutManager(9, 15, new Insets(0, 0, 0, 0), -1, -1));
        rootPanel.setAlignmentX(0.5f);
        rootPanel.setAlignmentY(0.5f);
        rootPanel.putClientProperty("html.disable", Boolean.FALSE);
        final Spacer spacer1 = new Spacer();
        rootPanel.add(spacer1, new GridConstraints(0, 0, 1, 15, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        rootPanel.add(panel1, new GridConstraints(1, 1, 3, 9, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setIcon(new ImageIcon(getClass().getResource("/conviso.png")));
        label1.setText("");
        panel1.add(label1, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final Spacer spacer2 = new Spacer();
        rootPanel.add(spacer2, new GridConstraints(8, 5, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer3 = new Spacer();
        rootPanel.add(spacer3, new GridConstraints(1, 0, 3, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer4 = new Spacer();
        rootPanel.add(spacer4, new GridConstraints(6, 0, 1, 15, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final Spacer spacer5 = new Spacer();
        rootPanel.add(spacer5, new GridConstraints(8, 10, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer6 = new Spacer();
        rootPanel.add(spacer6, new GridConstraints(7, 14, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, new Dimension(14, 70), null, 0, false));
        final Spacer spacer7 = new Spacer();
        rootPanel.add(spacer7, new GridConstraints(8, 13, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer8 = new Spacer();
        rootPanel.add(spacer8, new GridConstraints(8, 12, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final Spacer spacer9 = new Spacer();
        rootPanel.add(spacer9, new GridConstraints(8, 11, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new FormLayout("fill:222px:noGrow,left:4dlu:noGrow,fill:max(d;4px):noGrow", "center:d:grow,top:4dlu:noGrow,center:max(d;4px):noGrow"));
        rootPanel.add(panel2, new GridConstraints(7, 1, 1, 13, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(0, 70), null, 0, false));
        final JLabel label2 = new JLabel();
        Font label2Font = this.$$$getFont$$$(null, -1, 17, label2.getFont());
        if (label2Font != null) label2.setFont(label2Font);
        label2.setText("Project ID");
        CellConstraints cc = new CellConstraints();
        panel2.add(label2, cc.xy(1, 1, CellConstraints.CENTER, CellConstraints.DEFAULT));
        txtProjectId = new JTextField();
        panel2.add(txtProjectId, cc.xy(1, 3, CellConstraints.FILL, CellConstraints.DEFAULT));
        defineButton = new JButton();
        defineButton.setText("Define");
        panel2.add(defineButton, cc.xy(3, 3));
        final JPanel panel3 = new JPanel();
        panel3.setLayout(new GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
        rootPanel.add(panel3, new GridConstraints(4, 1, 2, 13, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_BOTH, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        btnApiKey = new JButton();
        btnApiKey.setActionCommand("Test Key");
        btnApiKey.setText("Test");
        panel3.add(btnApiKey, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_SOUTH, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final JLabel label3 = new JLabel();
        Font label3Font = this.$$$getFont$$$(null, -1, 17, label3.getFont());
        if (label3Font != null) label3.setFont(label3Font);
        label3.setText("API Key");
        panel3.add(label3, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        txtFlowApiKey = new JPasswordField();
        panel3.add(txtFlowApiKey, new GridConstraints(1, 0, 1, 1, GridConstraints.ANCHOR_WEST, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
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
