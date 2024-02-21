package com.clx.registerDevices.view;

import alahli.trustedDevices.DeviceDTO;
import com.clx.registerDevices.exceptions.UserNotFoundException;
import com.clx.registerDevices.services.RegisterDevicesServicesInterface;
import org.springframework.util.StringUtils;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.util.Vector;

public class SearchDevicesForEcorpApp extends JFrame{

	private JFrame jFrame = null;
	private JPanel jContentPane = null;
	private JPanel jPSearch = null;

	private JPanel jPEdit = null;

	private JPanel jPResult = null;
	private JLabel jLSearch = null;

	private JLabel jLUserName = null;
	private JLabel jLUserNameValue = null;
	private JLabel jLDeviceName = null;
	private JLabel jLDeviceNameValue = null;

	private JLabel jLUUID = null;
	private JTextField jTUUID = null;

	private JTextField jTSearch = null;
	private JButton jBSearch = null;

	public  JButton jBEdit = null;

	private JButton jBUpdate = null;

	private JScrollPane jScrollPane = null;
	private JTable jTResult = null;
	private JButton jBExit = null;

	private final RegisterDevicesServicesInterface registerDevicesServices;

	public SearchDevicesForEcorpApp(RegisterDevicesServicesInterface registerDevicesServices) {
		this.registerDevicesServices = registerDevicesServices;
	}

	/**
	 * This method initializes jFrame
	 * 
	 * @return javax.swing.JFrame
	 */
	public JFrame getJFrame() {
		if (jFrame == null) {
			jFrame = new JFrame();
			jFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			jFrame.setSize(702, 500);
			jFrame.setContentPane(getJContentPane());
			jFrame.setTitle("Search");
		}
		return jFrame;
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(null);
			jContentPane.add(getJPSearch(), null);
			jContentPane.add(getJPResult(), null);
			jContentPane.add(getJBEdit(), null);
			jContentPane.add(getJPEdit(), null);
			jContentPane.add(getJBExit(), null);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jPpesquisa
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPSearch() {
		if (jPSearch == null) {
			jLSearch = new JLabel();
			jLSearch.setBounds(new Rectangle(12, 25, 72, 22));
			jLSearch.setText("Search :");

			jPSearch = new JPanel();
			jPSearch.setLayout(null);
			jPSearch.setBounds(new Rectangle(10, 10, 666, 62));
			jPSearch.setBorder(BorderFactory.createTitledBorder(null,
					"Search by user name", TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, new Font("Dialog",
							Font.BOLD, 12), new Color(51, 51, 51)));
			jPSearch.add(jLSearch, null);
			jPSearch.add(getJTSearch(), null);
			jPSearch.add(getJBSearch(), null);
		}
		return jPSearch;
	}

	private JPanel getJPEdit() {
		if (jPEdit == null) {

			jPEdit = new JPanel();
			jPEdit.setLayout(null);
			jPEdit.setBounds(new Rectangle(11, 330, 666, 150));
			jPEdit.setBorder(BorderFactory.createTitledBorder(null, "New device",
					TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION,
					new Font("Dialog",Font.BOLD, 12), new Color(51, 51, 51)));

			jPEdit.add(getJLUserName(), null);
//			jPEdit.add(getJLUserNameValue(), null);
//			jPEdit.add(getJLDeviceName(), null);
//			jPEdit.add(getJLDeviceNameValue(), null);
//			jPEdit.add(getJLUUID(), null);
//			jPEdit.add(getJTUUID(), null);
//			jPEdit.add(getJBUpdate(), null);
		}
		return jPEdit;
	}

	private JTextField getJTUUID() {
		jTUUID = new JTextField();
		jTUUID.setBounds(new Rectangle(136, 326, 72, 22));
		return jTUUID;
	}

	private JLabel getJLUUID() {
		jLUUID = new JLabel();
		jLUUID.setBounds(new Rectangle(123, 326, 72, 22));
		jLUUID.setText("");
		return jLUUID;
	}

	private JLabel getJLDeviceNameValue() {
		jLDeviceNameValue = new JLabel();
		jLDeviceNameValue.setBounds(new Rectangle(110, 326, 72, 22));
		jLDeviceNameValue.setText("Hack App :P");
		return jLDeviceNameValue;
	}

	private JLabel getJLDeviceName() {
		jLDeviceName = new JLabel();
		jLDeviceName.setBounds(new Rectangle(97, 326, 72, 22));
		jLDeviceName.setText("Device Name :");
		return jLDeviceName;
	}

	private JLabel getJLUserNameValue() {
		jLUserNameValue = new JLabel();
		jLUserNameValue.setBounds(new Rectangle(85, 326, 72, 22));
		jLUserNameValue.setText("");
		return jLUserNameValue;
	}

	private JLabel getJLUserName() {
		jLUserName = new JLabel();
		jLUserName.setBounds(new Rectangle(11, 350, 72, 22));
		jLUserName.setText("UserName :");
		return jLUserName;
	}

	/**
	 * This method initializes jPressultado
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJPResult() {
		if (jPResult == null) {
			jPResult = new JPanel();
			jPResult.setLayout(new BorderLayout());
			jPResult.setBounds(new Rectangle(11, 79, 664, 215));
			jPResult.setBorder(BorderFactory.createTitledBorder(null, "",
					TitledBorder.DEFAULT_JUSTIFICATION,
					TitledBorder.DEFAULT_POSITION, new Font("Dialog",
							Font.BOLD, 12), new Color(51, 51, 51)));
			jPResult.add(getJScrollPane(), BorderLayout.CENTER);
		}
		return jPResult;
	}

	/**
	 * This method initializes jBpesquisa
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJBSearch() {
		if (jBSearch == null) {
			jBSearch = new JButton();
			jBSearch.setBounds(new Rectangle(458, 25, 97, 22));
			jBSearch.setText("Search");
			jBSearch.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					String userName = jTSearch.getText();
					if(!StringUtils.isEmpty(userName)) {
						cleanData();
						try {
							List<DeviceDTO> result = registerDevicesServices.getDevicesByUserId(userName);
							if (result.size() != 0) {
								DefaultTableModel DefaultTableModel = null;
								DefaultTableModel = setTableModel(result);
								jTResult.setModel(DefaultTableModel);
							} else {
								JOptionPane.showMessageDialog(null, "Any device found for " + userName);
							}
						} catch (UserNotFoundException userNotFoundException) {
							JOptionPane.showMessageDialog(null, userNotFoundException.getMessage() + userName);
						}
					} else {
						JOptionPane.showMessageDialog(null, "Please add a user to search!");
					}
				}
			});
		}
		return jBSearch;
	}

	protected void cleanData() {
		DefaultTableModel df = (DefaultTableModel) jTResult.getModel();
		int n = df.getRowCount();
		for (int i = n - 1; i >= 0; i--) {
			df.removeRow(i);
		}
		jTSearch.setText("");
	}

	/**
	 * This method initializes jBeditar
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJBEdit() {
		if (jBEdit == null) {
			jBEdit = new JButton();
			jBEdit.setBounds(new Rectangle(385, 301, 137, 28));
			jBEdit.setText("Edit");
			jBEdit.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					if (jTResult.getSelectedRow() == -1) {
						JOptionPane.showMessageDialog(null,"Select a line ");
					} else {
						int line = jTResult.getSelectedRow();
						int column = 0;
						DeviceDTO deviceDTO = new DeviceDTO();
						deviceDTO.setUuid((String)		 jTResult.getValueAt(line, column++));
						deviceDTO.setUuid((String) 		 jTResult.getValueAt(line, column++));
						deviceDTO.setNameDevice((String) jTResult.getValueAt(line, column++));
					}
				}
			});
		}
		return jBEdit;
	}

	private JButton getJBUpdate() {
		if (jBUpdate == null) {
			jBUpdate = new JButton();
			jBUpdate.setBounds(new Rectangle(385, 301, 137, 28));
			jBUpdate.setText("Update");
			jBUpdate.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					System.out.println("Update");
//					if (jTResult.getSelectedRow() == -1) {
//						JOptionPane.showMessageDialog(null,"Select a line ");
//					} else {
//						int line = jTResult.getSelectedRow();
//						int column = 0;
//						DeviceDTO deviceDTO = new DeviceDTO();
//						deviceDTO.setUuid((String)		 jTResult.getValueAt(line, column++));
//						deviceDTO.setUuid((String) 		 jTResult.getValueAt(line, column++));
//						deviceDTO.setNameDevice((String) jTResult.getValueAt(line, column++));
//					}
				}
			});
		}
		return jBUpdate;
	}

	/**
	 * This method initializes jScrollPane
	 * 
	 * @return javax.swing.JScrollPane
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setViewportView(getJTResult());

		}
		return jScrollPane;
	}

	/**
	 * This method initializes jTresultada
	 * 
	 * @return javax.swing.JTable
	 */
	private JTable getJTResult() {
		if (jTResult == null) {
			jTResult = new JTable();
			String[] columns = { "User Name", "uuid", "Name Device" };
			String[][] data = null;
			DefaultTableModel model = new DefaultTableModel(data, columns);
			jTResult.setModel(model);
		}
		return jTResult;
	}

	protected DefaultTableModel setTableModel(List deviceList) {
		Vector columns = new Vector();
		columns.add("User Name");
		columns.add("Device Name");
		columns.add("uuid");


		Vector data = new Vector();

		DeviceDTO deviceDTO = new DeviceDTO();
		for (int i = 0; i < deviceList.size(); i++) {
			Vector line = new Vector();
			deviceDTO = (DeviceDTO) deviceList.get(i);
			line.add(deviceDTO.getUserName());
			line.add(deviceDTO.getNameDevice());
			line.add(deviceDTO.getUuid());
			data.add(line);
		}
		DefaultTableModel modelo = new DefaultTableModel(data, columns);
		return modelo;
	}

	/**
	 * This method initializes jBsair
	 * 
	 * @return javax.swing.JButton
	 */
	private JButton getJBExit() {
		if (jBExit == null) {
			jBExit = new JButton();
			jBExit.setBounds(new Rectangle(527, 301, 137, 28));
			jBExit.setText("Exit");
			jBExit.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					jFrame.dispose();
				}
			});
		}
		return jBExit;
	}


	/**
	 * This method initializes jTpesquisa
	 *
	 * @return javax.swing.JTextField
	 */
	private JTextField getJTSearch() {
		if (jTSearch == null) {
			jTSearch = new JTextField();
			jTSearch.setBounds(new Rectangle(88, 25, 364, 22));
		}
		return jTSearch;
	}

}
