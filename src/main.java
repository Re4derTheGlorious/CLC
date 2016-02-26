
import Objects.Converter;
import java.awt.Frame;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import localizations.English;
import localizations.Localization;
import localizations.Polish;

public class main extends javax.swing.JFrame {

    public main() {
	initComponents();
	this.setTitle("Cantr Log Converter by re4der");
	this.setIconImage(loadIcon());
	setLanguage();
    }
    
    private void setLanguage(){
	Localization lang = new Localization();
	if(polishRadioButton.isSelected()){
	    lang = new Polish();
	}
	else if(englishRadioButton.isSelected()){
	    lang = new English();
	}
	
	basicSettings.setText(lang.basicSettings);
	formatSettings.setText(lang.formatSettings);
	otherMenu.setText(lang.otherSettings);
	convertButton.setText(lang.convertButton);
	reverseLogCheckbox.setText(lang.reverseCheckbox);
	removeRolePlayCheckbox.setText(lang.rolePlayCheckbox);
	speechOnlyCheckbox.setText(lang.speechOnlyCheckbox);
	quotingsCheckbox.setText(lang.quotationCheckbox);
	dataCheckbox.setText(lang.dataCheckbox);
	radioSubMenu.setText(lang.radioSubMenu);
	eventSubMenu.setText(lang.eventSubMenu);
	nameCheckbox.setText(lang.nameCheckbox);
	actionCheckbox.setText(lang.actionCheckbox);
	languageSubMenu.setText(lang.languageSubMenu);
	restoreMenuItem.setText(lang.restoreMenuItem);
	radioCheckbox.setText(lang.radioMessagesCheckbox);
	frequencyCheckbox.setText(lang.frequencyCheckbox);
	fixedQuotingsCheckbox.setText(lang.fixedQuotingCheckbox);
	perspectiveMenu.setText(lang.perspectiveMenu);
	firstPersonRadioButton.setText(lang.FPSRadioButton);
	thirdPersonRadioButton.setText(lang.TPSRadioButton);
    }

    private Image loadIcon() {
	try{
	    BufferedImage image = ImageIO.read(Frame.class.getResource("/Resources/cantr.jpg"));
	    return image;
	} catch (IOException argh){
	    
	}
	return null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        languageGroup = new javax.swing.ButtonGroup();
        perspectiveGroup = new javax.swing.ButtonGroup();
        panel = new javax.swing.JPanel();
        scrollPane = new javax.swing.JScrollPane();
        textInput = new javax.swing.JTextArea();
        convertButton = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        basicSettings = new javax.swing.JMenu();
        reverseLogCheckbox = new javax.swing.JCheckBoxMenuItem();
        speechOnlyCheckbox = new javax.swing.JCheckBoxMenuItem();
        removeRolePlayCheckbox = new javax.swing.JCheckBoxMenuItem();
        formatSettings = new javax.swing.JMenu();
        dataCheckbox = new javax.swing.JCheckBoxMenuItem();
        quotingsCheckbox = new javax.swing.JCheckBoxMenuItem();
        eventSubMenu = new javax.swing.JMenu();
        nameCheckbox = new javax.swing.JCheckBoxMenuItem();
        actionCheckbox = new javax.swing.JCheckBoxMenuItem();
        radioSubMenu = new javax.swing.JMenu();
        radioCheckbox = new javax.swing.JCheckBoxMenuItem();
        frequencyCheckbox = new javax.swing.JCheckBoxMenuItem();
        fixedQuotingsCheckbox = new javax.swing.JCheckBoxMenuItem();
        perspectiveMenu = new javax.swing.JMenu();
        firstPersonRadioButton = new javax.swing.JRadioButtonMenuItem();
        thirdPersonRadioButton = new javax.swing.JRadioButtonMenuItem();
        otherMenu = new javax.swing.JMenu();
        languageSubMenu = new javax.swing.JMenu();
        polishRadioButton = new javax.swing.JRadioButtonMenuItem();
        englishRadioButton = new javax.swing.JRadioButtonMenuItem();
        restoreMenuItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(1, 68, 0));
        setMinimumSize(new java.awt.Dimension(400, 200));

        panel.setBackground(new java.awt.Color(1, 68, 0));
        panel.setForeground(new java.awt.Color(1, 68, 0));
        panel.setMaximumSize(new java.awt.Dimension(600, 800));
        panel.setMinimumSize(new java.awt.Dimension(0, 0));
        panel.setPreferredSize(new java.awt.Dimension(600, 800));

        scrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setPreferredSize(new java.awt.Dimension(578, 753));

        textInput.setBackground(new java.awt.Color(0, 136, 0));
        textInput.setColumns(20);
        textInput.setFont(new java.awt.Font("Arial", 0, 9)); // NOI18N
        textInput.setForeground(new java.awt.Color(255, 251, 248));
        textInput.setRows(5);
        textInput.setNextFocusableComponent(textInput);
        scrollPane.setViewportView(textInput);

        convertButton.setBackground(new java.awt.Color(1, 68, 0));
        convertButton.setFont(new java.awt.Font("Verdana", 0, 36)); // NOI18N
        convertButton.setForeground(new java.awt.Color(255, 251, 248));
        convertButton.setText("KONWERTUJ");
        convertButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        convertButton.setPreferredSize(new java.awt.Dimension(73, 40));
        convertButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                convertButtonMouseEntered(evt);
            }
        });
        convertButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                convertButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 580, Short.MAX_VALUE)
                    .addComponent(convertButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 727, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(convertButton, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        basicSettings.setText("Opcje");

        reverseLogCheckbox.setSelected(true);
        reverseLogCheckbox.setText("Odwrotna kolejność");
        basicSettings.add(reverseLogCheckbox);

        speechOnlyCheckbox.setText("Tylko mowa");
        basicSettings.add(speechOnlyCheckbox);

        removeRolePlayCheckbox.setSelected(true);
        removeRolePlayCheckbox.setText("Bez odgrywania");
        basicSettings.add(removeRolePlayCheckbox);

        menuBar.add(basicSettings);

        formatSettings.setText("Format");

        dataCheckbox.setText("Data");
        formatSettings.add(dataCheckbox);

        quotingsCheckbox.setText("Cudzysłowy");
        formatSettings.add(quotingsCheckbox);

        eventSubMenu.setText("Zdarzenia");

        nameCheckbox.setSelected(true);
        nameCheckbox.setText("Nazwa");
        nameCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameCheckboxActionPerformed(evt);
            }
        });
        eventSubMenu.add(nameCheckbox);

        actionCheckbox.setText("Czynność");
        eventSubMenu.add(actionCheckbox);

        formatSettings.add(eventSubMenu);

        radioSubMenu.setText("Radio");

        radioCheckbox.setSelected(true);
        radioCheckbox.setText("Wiadomości radiowe");
        radioCheckbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioCheckboxActionPerformed(evt);
            }
        });
        radioSubMenu.add(radioCheckbox);

        frequencyCheckbox.setSelected(true);
        frequencyCheckbox.setText("Częstotliwość");
        radioSubMenu.add(frequencyCheckbox);

        fixedQuotingsCheckbox.setSelected(true);
        fixedQuotingsCheckbox.setText("Poprawiony cudzysłów");
        radioSubMenu.add(fixedQuotingsCheckbox);

        formatSettings.add(radioSubMenu);

        menuBar.add(formatSettings);

        perspectiveMenu.setText("Perspektywa");

        perspectiveGroup.add(firstPersonRadioButton);
        firstPersonRadioButton.setSelected(true);
        firstPersonRadioButton.setText("Pierwszoosobowa");
        perspectiveMenu.add(firstPersonRadioButton);

        perspectiveGroup.add(thirdPersonRadioButton);
        thirdPersonRadioButton.setText("Trzecioosobowa");
        perspectiveMenu.add(thirdPersonRadioButton);

        menuBar.add(perspectiveMenu);

        otherMenu.setText("Inne");

        languageSubMenu.setText("Język");

        languageGroup.add(polishRadioButton);
        polishRadioButton.setSelected(true);
        polishRadioButton.setText("Polski");
        polishRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                polishRadioButtonActionPerformed(evt);
            }
        });
        languageSubMenu.add(polishRadioButton);

        languageGroup.add(englishRadioButton);
        englishRadioButton.setText("English");
        englishRadioButton.setEnabled(false);
        englishRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                englishRadioButtonActionPerformed(evt);
            }
        });
        languageSubMenu.add(englishRadioButton);

        otherMenu.add(languageSubMenu);

        restoreMenuItem.setText("Przywróć ustawienia domyślne");
        restoreMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restoreMenuItemActionPerformed(evt);
            }
        });
        otherMenu.add(restoreMenuItem);

        menuBar.add(otherMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, 801, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void convertButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_convertButtonActionPerformed
        Converter con = new Converter(reverseLogCheckbox.isSelected(), actionCheckbox.isSelected(), speechOnlyCheckbox.isSelected(), dataCheckbox.isSelected(), nameCheckbox.isSelected(), removeRolePlayCheckbox.isSelected(), quotingsCheckbox.isSelected(), radioCheckbox.isSelected(), frequencyCheckbox.isSelected(), fixedQuotingsCheckbox.isSelected());
	Localization lang = new Localization();
	if(polishRadioButton.isSelected()){
	    lang = new Polish();
	    con.setLanguage(lang);
	}
	else if(englishRadioButton.isSelected()){
	    lang = new English();
	    con.setLanguage(lang);
	}
	
	if(firstPersonRadioButton.isSelected()){
	    con.setPerspective(true);
	}
	else if(thirdPersonRadioButton.isSelected()){
	    con.setPerspective(false);
	}
	convertButton.setText(lang.doneButton);
	textInput.setText(con.convert(textInput.getText()));
    }//GEN-LAST:event_convertButtonActionPerformed

    private void nameCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameCheckboxActionPerformed
        actionCheckbox.setEnabled(!actionCheckbox.isEnabled());
    }//GEN-LAST:event_nameCheckboxActionPerformed

    private void convertButtonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_convertButtonMouseEntered
        if(polishRadioButton.isSelected()){
	    convertButton.setText(new Polish().convertButton);
	}
	else if(englishRadioButton.isSelected()){
	    convertButton.setText(new English().convertButton);
	}
    }//GEN-LAST:event_convertButtonMouseEntered

    private void radioCheckboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioCheckboxActionPerformed
        frequencyCheckbox.setEnabled(!frequencyCheckbox.isEnabled());
	fixedQuotingsCheckbox.setEnabled(!fixedQuotingsCheckbox.isEnabled());
    }//GEN-LAST:event_radioCheckboxActionPerformed

    private void restoreMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restoreMenuItemActionPerformed
        actionCheckbox.setSelected(false);
	actionCheckbox.setEnabled(true);
	nameCheckbox.setSelected(true);
	dataCheckbox.setSelected(false);
	quotingsCheckbox.setSelected(false);
	
	radioCheckbox.setSelected(true);
	frequencyCheckbox.setSelected(true);
	frequencyCheckbox.setEnabled(true);
	fixedQuotingsCheckbox.setSelected(true);
	fixedQuotingsCheckbox.setEnabled(true);
	
	reverseLogCheckbox.setSelected(true);
	removeRolePlayCheckbox.setSelected(true);
	speechOnlyCheckbox.setSelected(false);
	
	firstPersonRadioButton.setSelected(true);
    }//GEN-LAST:event_restoreMenuItemActionPerformed

    private void polishRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_polishRadioButtonActionPerformed
        setLanguage();
    }//GEN-LAST:event_polishRadioButtonActionPerformed

    private void englishRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_englishRadioButtonActionPerformed
        setLanguage();
    }//GEN-LAST:event_englishRadioButtonActionPerformed

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
	    java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (InstantiationException ex) {
	    java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (IllegalAccessException ex) {
	    java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	} catch (javax.swing.UnsupportedLookAndFeelException ex) {
	    java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	}
        //</editor-fold>

	/* Create and display the form */
	java.awt.EventQueue.invokeLater(new Runnable() {
	    public void run() {
		new main().setVisible(true);
	    }
	});
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBoxMenuItem actionCheckbox;
    private javax.swing.JMenu basicSettings;
    private javax.swing.JButton convertButton;
    private javax.swing.JCheckBoxMenuItem dataCheckbox;
    private javax.swing.JRadioButtonMenuItem englishRadioButton;
    private javax.swing.JMenu eventSubMenu;
    private javax.swing.JRadioButtonMenuItem firstPersonRadioButton;
    private javax.swing.JCheckBoxMenuItem fixedQuotingsCheckbox;
    private javax.swing.JMenu formatSettings;
    private javax.swing.JCheckBoxMenuItem frequencyCheckbox;
    private javax.swing.ButtonGroup languageGroup;
    private javax.swing.JMenu languageSubMenu;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JCheckBoxMenuItem nameCheckbox;
    private javax.swing.JMenu otherMenu;
    private javax.swing.JPanel panel;
    private javax.swing.ButtonGroup perspectiveGroup;
    private javax.swing.JMenu perspectiveMenu;
    private javax.swing.JRadioButtonMenuItem polishRadioButton;
    private javax.swing.JCheckBoxMenuItem quotingsCheckbox;
    private javax.swing.JCheckBoxMenuItem radioCheckbox;
    private javax.swing.JMenu radioSubMenu;
    private javax.swing.JCheckBoxMenuItem removeRolePlayCheckbox;
    private javax.swing.JMenuItem restoreMenuItem;
    private javax.swing.JCheckBoxMenuItem reverseLogCheckbox;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JCheckBoxMenuItem speechOnlyCheckbox;
    private javax.swing.JTextArea textInput;
    private javax.swing.JRadioButtonMenuItem thirdPersonRadioButton;
    // End of variables declaration//GEN-END:variables
}
