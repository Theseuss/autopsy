/*
 * Central Repository
 *
 * Copyright 2015-2017 Basis Technology Corp.
 * Contact: carrier <at> sleuthkit <dot> org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.sleuthkit.autopsy.centralrepository.optionspanel;

import org.sleuthkit.autopsy.coreutils.Logger;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.SwingUtilities;
import org.netbeans.spi.options.OptionsPanelController;
import org.openide.util.NbBundle.Messages;
import org.sleuthkit.autopsy.corecomponents.OptionsPanel;
import org.sleuthkit.autopsy.events.AutopsyEvent;
import org.sleuthkit.autopsy.ingest.IngestManager;
import org.sleuthkit.autopsy.ingest.IngestModuleGlobalSettingsPanel;
import org.sleuthkit.autopsy.centralrepository.datamodel.EamDbPlatformEnum;
import static org.sleuthkit.autopsy.centralrepository.datamodel.EamDbPlatformEnum.DISABLED;
import org.sleuthkit.autopsy.centralrepository.datamodel.EamDbUtil;
import org.sleuthkit.autopsy.centralrepository.datamodel.PostgresEamDbSettings;
import org.sleuthkit.autopsy.centralrepository.datamodel.SqliteEamDbSettings;

/**
 * Main settings panel for the Central Repository
 */
public final class GlobalSettingsPanel extends IngestModuleGlobalSettingsPanel implements OptionsPanel {

    private static final long serialVersionUID = 1L;
    private static final Logger LOGGER = Logger.getLogger(GlobalSettingsPanel.class.getName());

    private final IngestJobEventPropertyChangeListener ingestJobEventListener;

    /**
     * Creates new form EamOptionsPanel
     */
    public GlobalSettingsPanel() {
        ingestJobEventListener = new IngestJobEventPropertyChangeListener();

        initComponents();
        customizeComponents();
        addIngestJobEventsListener();

    }

    @Messages({"GlobalSettingsPanel.title=Central Repository Settings"})
    private void customizeComponents() {
        setName(Bundle.GlobalSettingsPanel_title());
    }

    private void addIngestJobEventsListener() {
        IngestManager.getInstance().addIngestJobEventListener(ingestJobEventListener);
        ingestStateUpdated();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnDatabaseConfiguration = new javax.swing.JPanel();
        lbDbPlatformTypeLabel = new javax.swing.JLabel();
        lbDbNameLabel = new javax.swing.JLabel();
        lbDbLocationLabel = new javax.swing.JLabel();
        bnDbConfigure = new javax.swing.JButton();
        lbDbPlatformValue = new javax.swing.JLabel();
        lbDbNameValue = new javax.swing.JLabel();
        lbDbLocationValue = new javax.swing.JLabel();
        pnDatabaseContentButtons = new javax.swing.JPanel();
        bnImportDatabase = new javax.swing.JButton();
        bnManageTags = new javax.swing.JButton();
        bnManageTypes = new javax.swing.JButton();
        tbOops = new javax.swing.JTextField();
        cbUseCentralRepo = new javax.swing.JCheckBox();

        setName(""); // NOI18N

        pnDatabaseConfiguration.setBorder(javax.swing.BorderFactory.createTitledBorder(null, org.openide.util.NbBundle.getMessage(GlobalSettingsPanel.class, "GlobalSettingsPanel.pnDatabaseConfiguration.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 12))); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(lbDbPlatformTypeLabel, org.openide.util.NbBundle.getMessage(GlobalSettingsPanel.class, "GlobalSettingsPanel.lbDbPlatformTypeLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(lbDbNameLabel, org.openide.util.NbBundle.getMessage(GlobalSettingsPanel.class, "GlobalSettingsPanel.lbDbNameLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(lbDbLocationLabel, org.openide.util.NbBundle.getMessage(GlobalSettingsPanel.class, "GlobalSettingsPanel.lbDbLocationLabel.text")); // NOI18N

        org.openide.awt.Mnemonics.setLocalizedText(bnDbConfigure, org.openide.util.NbBundle.getMessage(GlobalSettingsPanel.class, "GlobalSettingsPanel.bnDbConfigure.text")); // NOI18N
        bnDbConfigure.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnDbConfigureActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnDatabaseConfigurationLayout = new javax.swing.GroupLayout(pnDatabaseConfiguration);
        pnDatabaseConfiguration.setLayout(pnDatabaseConfigurationLayout);
        pnDatabaseConfigurationLayout.setHorizontalGroup(
            pnDatabaseConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDatabaseConfigurationLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnDatabaseConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnDatabaseConfigurationLayout.createSequentialGroup()
                        .addGroup(pnDatabaseConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbDbPlatformTypeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbDbNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lbDbLocationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(pnDatabaseConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnDatabaseConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lbDbPlatformValue, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbDbNameValue, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbDbLocationValue, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 711, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(bnDbConfigure))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnDatabaseConfigurationLayout.setVerticalGroup(
            pnDatabaseConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnDatabaseConfigurationLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(pnDatabaseConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbDbPlatformTypeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbDbPlatformValue, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDatabaseConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbDbNameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbDbNameValue, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnDatabaseConfigurationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbDbLocationLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbDbLocationValue, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(bnDbConfigure)
                .addContainerGap())
        );

        bnImportDatabase.setIcon(new javax.swing.ImageIcon(getClass().getResource("/org/sleuthkit/autopsy/centralrepository/images/import16.png"))); // NOI18N
        org.openide.awt.Mnemonics.setLocalizedText(bnImportDatabase, org.openide.util.NbBundle.getMessage(GlobalSettingsPanel.class, "GlobalSettingsPanel.bnImportDatabase.label")); // NOI18N
        bnImportDatabase.setActionCommand(org.openide.util.NbBundle.getMessage(GlobalSettingsPanel.class, "GlobalSettingsPanel.bnImportDatabase.actionCommand")); // NOI18N
        bnImportDatabase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnImportDatabaseActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(bnManageTags, org.openide.util.NbBundle.getMessage(GlobalSettingsPanel.class, "GlobalSettingsPanel.bnManageTags.text")); // NOI18N
        bnManageTags.setToolTipText(org.openide.util.NbBundle.getMessage(GlobalSettingsPanel.class, "GlobalSettingsPanel.bnManageTags.toolTipText")); // NOI18N
        bnManageTags.setActionCommand(org.openide.util.NbBundle.getMessage(GlobalSettingsPanel.class, "GlobalSettingsPanel.bnManageTags.actionCommand")); // NOI18N
        bnManageTags.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnManageTagsActionPerformed(evt);
            }
        });

        org.openide.awt.Mnemonics.setLocalizedText(bnManageTypes, org.openide.util.NbBundle.getMessage(GlobalSettingsPanel.class, "GlobalSettingsPanel.bnManageProperties.text")); // NOI18N
        bnManageTypes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnManageTypesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnDatabaseContentButtonsLayout = new javax.swing.GroupLayout(pnDatabaseContentButtons);
        pnDatabaseContentButtons.setLayout(pnDatabaseContentButtonsLayout);
        pnDatabaseContentButtonsLayout.setHorizontalGroup(
            pnDatabaseContentButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDatabaseContentButtonsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bnImportDatabase)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bnManageTags)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bnManageTypes)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnDatabaseContentButtonsLayout.setVerticalGroup(
            pnDatabaseContentButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnDatabaseContentButtonsLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnDatabaseContentButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bnImportDatabase)
                    .addComponent(bnManageTags, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bnManageTypes, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        tbOops.setEditable(false);
        tbOops.setFont(tbOops.getFont().deriveFont(tbOops.getFont().getStyle() | java.awt.Font.BOLD, 12));
        tbOops.setText(org.openide.util.NbBundle.getMessage(GlobalSettingsPanel.class, "GlobalSettingsPanel.tbOops.text")); // NOI18N
        tbOops.setBorder(null);

        org.openide.awt.Mnemonics.setLocalizedText(cbUseCentralRepo, org.openide.util.NbBundle.getMessage(GlobalSettingsPanel.class, "GlobalSettingsPanel.cbUseCentralRepo.text")); // NOI18N
        cbUseCentralRepo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbUseCentralRepoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnDatabaseContentButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tbOops, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnDatabaseConfiguration, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbUseCentralRepo, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(cbUseCentralRepo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnDatabaseConfiguration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tbOops, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnDatabaseContentButtons, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bnImportDatabaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnImportDatabaseActionPerformed
        store();
        ImportHashDatabaseDialog dialog = new ImportHashDatabaseDialog();
        firePropertyChange(OptionsPanelController.PROP_VALID, null, null);
    }//GEN-LAST:event_bnImportDatabaseActionPerformed

    private void bnManageTagsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnManageTagsActionPerformed
        store();
        ManageTagsDialog dialog = new ManageTagsDialog();
        firePropertyChange(OptionsPanelController.PROP_VALID, null, null);
    }//GEN-LAST:event_bnManageTagsActionPerformed

    private void bnManageTypesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnManageTypesActionPerformed
        store();
        ManageCorrelationPropertiesDialog dialog = new ManageCorrelationPropertiesDialog();
        firePropertyChange(OptionsPanelController.PROP_VALID, null, null);
    }//GEN-LAST:event_bnManageTypesActionPerformed

    private void bnDbConfigureActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bnDbConfigureActionPerformed
        store();
        EamDbSettingsDialog dialog = new EamDbSettingsDialog();
        load(); // reload db settings content and update buttons
    }//GEN-LAST:event_bnDbConfigureActionPerformed

    private void cbUseCentralRepoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbUseCentralRepoActionPerformed
        //if saved setting is disabled checkbox should be disabled already 
        enableDatabaseConfigureButton(cbUseCentralRepo.isSelected());
        enableButtonSubComponents(cbUseCentralRepo.isSelected() && !EamDbPlatformEnum.getSelectedPlatform().equals(DISABLED));
        this.ingestStateUpdated();
        firePropertyChange(OptionsPanelController.PROP_CHANGED, null, null);
    }//GEN-LAST:event_cbUseCentralRepoActionPerformed

    @Override
    @Messages({"GlobalSettingsPanel.validationerrMsg.mustConfigure=Configure the database to enable this module."})
    public void load() {
        tbOops.setText("");
        enableAllSubComponents(false);
        EamDbPlatformEnum selectedPlatform = EamDbPlatformEnum.getSelectedPlatform();
        cbUseCentralRepo.setSelected(EamDbUtil.useCentralRepo()); // NON-NLS
        switch (selectedPlatform) {
            case POSTGRESQL:
                PostgresEamDbSettings dbSettingsPg = new PostgresEamDbSettings();
                lbDbPlatformValue.setText(EamDbPlatformEnum.POSTGRESQL.toString());
                lbDbNameValue.setText(dbSettingsPg.getDbName());
                lbDbLocationValue.setText(dbSettingsPg.getHost());
                enableAllSubComponents(true);
                break;
            case SQLITE:
                SqliteEamDbSettings dbSettingsSqlite = new SqliteEamDbSettings();
                lbDbPlatformValue.setText(EamDbPlatformEnum.SQLITE.toString());
                lbDbNameValue.setText(dbSettingsSqlite.getDbName());
                lbDbLocationValue.setText(dbSettingsSqlite.getDbDirectory());
                enableAllSubComponents(true);
                break;
            default:
                lbDbPlatformValue.setText(EamDbPlatformEnum.DISABLED.toString());
                lbDbNameValue.setText("");
                lbDbLocationValue.setText("");
                enableDatabaseConfigureButton(cbUseCentralRepo.isSelected());
                tbOops.setText(Bundle.GlobalSettingsPanel_validationerrMsg_mustConfigure());
                break;
        }

    }

    @Override
    public void store() { // Click OK or Apply on Options Panel
        EamDbUtil.setUseCentralRepo(cbUseCentralRepo.isSelected());
    }

    /**
     * Validates that the dialog/panel is filled out correctly for our usage.
     *
     * @return true if it's okay, false otherwise.
     */
    public boolean valid() {
        return true;
    }

    @Override
    public void saveSettings() { // Click OK on Global Settings Panel
        store();
    }

    @Override
    @SuppressWarnings("FinalizeDeclaration")
    protected void finalize() throws Throwable {
        IngestManager.getInstance().removeIngestJobEventListener(ingestJobEventListener);
        super.finalize();
    }

    /**
     * An ingest job event listener that disables the options panel while an
     * ingest job is running.
     */
    private class IngestJobEventPropertyChangeListener implements PropertyChangeListener {

        /**
         * Listens for local ingest job started, completed or cancel events and
         * enables/disables the options panel according to the job state.
         *
         * @param event
         */
        @Override
        public void propertyChange(PropertyChangeEvent event) {
            if (AutopsyEvent.SourceType.LOCAL == ((AutopsyEvent) event).getSourceType()) {
                ingestStateUpdated();
            }
        }
    };

    @Messages({"GlobalSettingsPanel.validationErrMsg.ingestRunning=You cannot change settings while ingest is running."})
    private void ingestStateUpdated() {
        if (!SwingUtilities.isEventDispatchThread()) {
            SwingUtilities.invokeLater(() -> {
                ingestStateUpdated();
            });

            return;
        }

        if (IngestManager.getInstance().isIngestRunning()) {
            tbOops.setText(Bundle.GlobalSettingsPanel_validationErrMsg_ingestRunning());
            enableAllSubComponents(false);
            cbUseCentralRepo.setEnabled(false);
        }
        else if (!cbUseCentralRepo.isEnabled()){
            cbUseCentralRepo.setEnabled(true);
            load();
        }
    }

    /**
     * Wrapper around each of the enableComponentXYZ methods to enable/disable
     * them all at the same time.
     *
     * @param enable
     *
     * @return True
     */
    private boolean enableAllSubComponents(Boolean enable) {
        enableDatabaseConfigureButton(cbUseCentralRepo.isSelected() && enable);
        enableButtonSubComponents(cbUseCentralRepo.isSelected() && enable);
        return true;
    }

    /**
     * Enable the Configure button
     *
     * @param enable
     *
     * @return True
     */
    private void enableDatabaseConfigureButton(Boolean enable) {
        pnDatabaseConfiguration.setEnabled(enable);
        pnDatabaseContentButtons.setEnabled(enable);
        bnDbConfigure.setEnabled(enable);
        lbDbLocationLabel.setEnabled(enable);
        lbDbLocationValue.setEnabled(enable);
        lbDbNameLabel.setEnabled(enable);
        lbDbNameValue.setEnabled(enable);
        lbDbPlatformTypeLabel.setEnabled(enable);
        lbDbPlatformValue.setEnabled(enable);
        tbOops.setEnabled(enable);
    }

    /**
     * Wrapper around each of the enableComponentXYZButton methods to
     * enable/disable them all at the same time.
     *
     * @param enable
     *
     * @return True
     */
    private boolean enableButtonSubComponents(Boolean enable) {
        bnManageTypes.setEnabled(enable);
        bnImportDatabase.setEnabled(enable);
        bnManageTags.setEnabled(enable);
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bnDbConfigure;
    private javax.swing.JButton bnImportDatabase;
    private javax.swing.JButton bnManageTags;
    private javax.swing.JButton bnManageTypes;
    private javax.swing.JCheckBox cbUseCentralRepo;
    private javax.swing.JLabel lbDbLocationLabel;
    private javax.swing.JLabel lbDbLocationValue;
    private javax.swing.JLabel lbDbNameLabel;
    private javax.swing.JLabel lbDbNameValue;
    private javax.swing.JLabel lbDbPlatformTypeLabel;
    private javax.swing.JLabel lbDbPlatformValue;
    private javax.swing.JPanel pnDatabaseConfiguration;
    private javax.swing.JPanel pnDatabaseContentButtons;
    private javax.swing.JTextField tbOops;
    // End of variables declaration//GEN-END:variables
}
