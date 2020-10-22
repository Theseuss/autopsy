/*
 * Autopsy
 *
 * Copyright 2020 Basis Technology Corp.
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
package org.sleuthkit.autopsy.discovery.ui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import org.apache.commons.lang.StringUtils;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle;
import org.sleuthkit.datamodel.BlackboardArtifact;
import org.sleuthkit.datamodel.BlackboardAttribute;
import org.sleuthkit.datamodel.TskCoreException;

public class ArtifactsListPanel extends JPanel {

    private static final long serialVersionUID = 1L;
    private final DomainArtifactTableModel tableModel = new DomainArtifactTableModel();

    /**
     * Creates new form ArtifactsListPanel
     */
    public ArtifactsListPanel() {
        initComponents();

    }

    public void addSelectionListener(ListSelectionListener listener) {
        jTable1.getSelectionModel().addListSelectionListener(listener);
    }

    public void removeListSelectionListener(ListSelectionListener listener) {
        jTable1.getSelectionModel().removeListSelectionListener(listener);
    }

    public BlackboardArtifact getSelectedArtifact() {
        return ((DomainArtifactTableModel) jTable1.getModel()).getArtifactByRow(jTable1.getSelectionModel().getLeadSelectionIndex());
    }

    public boolean isEmpty() {
        return tableModel.getRowCount() <= 0;
    }

    public void addArtifacts(List<BlackboardArtifact> artifactList) {
        tableModel.setContents(artifactList);
        jTable1.validate();
        jTable1.repaint();
        tableModel.fireTableDataChanged();
    }

    public void clearArtifacts() {
        tableModel.setContents(new ArrayList<>());
        tableModel.fireTableDataChanged();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jTable1.setModel(tableModel);
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    void addListener(ListSelectionListener listSelectionListener) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private class DomainArtifactTableModel extends AbstractTableModel {

        private static final long serialVersionUID = 1L;
        private final List<BlackboardArtifact> artifactList = new ArrayList<>();

        DomainArtifactTableModel() {
            //No arg constructor to create empty model
        }

        void setContents(List<BlackboardArtifact> artifacts) {
            artifactList.clear();
            artifactList.addAll(artifacts);
        }

        @Override
        public int getRowCount() {
            return artifactList.size();
        }

        @Override
        public int getColumnCount() {
            return 2;
        }

        public BlackboardArtifact getArtifactByRow(int rowIndex) {
            return artifactList.get(rowIndex);
        }

        @NbBundle.Messages({"ArtifactsListPanel.value.noValue=No value available."})
        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            Object returnValue = null;
            String url = "";
            String otherDate = "";
            try {
                for (BlackboardAttribute bba : getArtifactByRow(rowIndex).getAttributes()) {
                    if (bba.getAttributeType().getTypeName().startsWith("TSK_URL")) {
                        url = bba.getDisplayString();
                        continue;
                    }
                    switch (columnIndex) {
                        case 0:
                            if (bba.getAttributeType().getTypeName().startsWith("TSK_DATETIME_ACCESSED") && !StringUtils.isBlank(bba.getDisplayString())) {
                                returnValue = bba.getDisplayString();
                            } else if (bba.getAttributeType().getTypeName().startsWith("TSK_DATETIME") && !StringUtils.isBlank(bba.getDisplayString())) {
                                otherDate = bba.getDisplayString();
                            }
                            break;
                        case 1:
                            if (bba.getAttributeType().getTypeName().startsWith("TSK_TITLE") && !StringUtils.isBlank(bba.getDisplayString())) {
                                returnValue = bba.getDisplayString();
                            }
                            break;
                        default:
                            break;
                    }
                }
            } catch (TskCoreException ex) {
                Exceptions.printStackTrace(ex);
            }
            if (returnValue == null) {
                if (columnIndex == 0 && !StringUtils.isBlank(otherDate)) {
                    returnValue = otherDate;
                } else if (columnIndex == 1 && !StringUtils.isBlank(url)) {
                    returnValue = url;
                } else {
                    returnValue = Bundle.ArtifactsListPanel_value_noValue();
                }
            }
            return returnValue;
        }

        @NbBundle.Messages({"ArtifactsListPanel.titleColumn.name=Title",
            "ArtifactsListPanel.dateColumn.name=Date/Time"})
        @Override
        public String getColumnName(int column) {
            switch (column) {
                case 0:
                    return Bundle.ArtifactsListPanel_dateColumn_name();
                case 1:
                    return Bundle.ArtifactsListPanel_titleColumn_name();
                default:
                    return "";
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
