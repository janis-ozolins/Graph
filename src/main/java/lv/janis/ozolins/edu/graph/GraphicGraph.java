package lv.janis.ozolins.edu.graph;

import lv.janis.ozolins.edu.graph.deepcopy.DeepCopy;
import lv.janis.ozolins.edu.graph.impulss.ImpulssXmlParser;
import lv.janis.ozolins.edu.graph.msg.Messages;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GraphicGraph extends JFrame implements ActionListener{
	Container panel;
	JButton btnSkt;
	Graph graph,copy;
	GraphComputation computation;
	JButton btnStop;
	boolean paused;
	JPopupMenu popupMenu;
	JSlider dampingSlider,coulombSlider;
	JMenuBar menuBar;
	JMenuItem menuExit,menuRestart, menuUpload, xmlUpload;
	ImageLoader imLoader;
    ImpulssXmlParser xmlParser;

	
	public static void main(String[] args) {
		// Windows Look & Feel
		try {
			// Set System L&F
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            System.out.println("Error while inicializing Swing");
        }

        SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){
				List<GraphNode> list = new ArrayList<GraphNode>();
				GraphNode n1 = new GraphNode(1);
				GraphNode n2 = new GraphNode(2);
				GraphNode n3 = new GraphNode(3);
				GraphNode n4 = new GraphNode(4);
				GraphNode n5 = new GraphNode(5);
				GraphNode n6 = new GraphNode(6);
				GraphNode n7 = new GraphNode(7);
				GraphNode n8 = new GraphNode(8);
				GraphNode n9 = new GraphNode(9);
				list.add(n1);
				list.add(n2);
				list.add(n3);
				list.add(n4);
				list.add(n5);
				list.add(n6);
				list.add(n7);
				list.add(n8);
				list.add(n9);
				n1.addNeighbor(n2);
				n1.addNeighbor(n3);
				n1.addNeighbor(n7);
				n1.addNeighbor(n9);
				n2.addNeighbor(n5);
				n2.addNeighbor(n6);
				n3.addNeighbor(n7);
				n4.addNeighbor(n7);
				n4.addNeighbor(n5);
				n6.addNeighbor(n8);
				n6.addNeighbor(n9);
				n8.addNeighbor(n9);
				new GraphicGraph(new Graph(list));
			}
		});
	}
	
	public void toogleSaktButtonOn(){
		btnSkt.setEnabled(true);
	}
	
	public void toogleSaktButtonOff(){
		btnSkt.setEnabled(false);
	}
	
	public GraphicGraph(Graph graph){
		paused = false;
		this.graph = graph;
		imLoader = new ImageLoader();

		copy = (Graph) DeepCopy.copy(graph);
        xmlParser = new ImpulssXmlParser();
		
		panel = new Container(graph);
		panel.setBackground(Color.white);
			//PanelMouseListener panelListener = new PanelMouseListener();
		panel.addMouseListener(new PanelMouseListener());
		
		
		SliderListener sliderListener = new SliderListener();
		
		JLabel dampingLabel = new JLabel(Messages.msg("label.inertia"));
		dampingSlider = new JSlider(JSlider.HORIZONTAL,0,100,80);
		dampingSlider.addChangeListener(sliderListener);
		dampingSlider.setToolTipText(Messages.msg("label.damping"));
		
		JLabel coulombLabel = new JLabel(Messages.msg("label.repulsionForse"));
		coulombSlider = new JSlider(JSlider.HORIZONTAL,10,10000,1000);
		coulombSlider.addChangeListener(sliderListener);
		coulombSlider.setToolTipText(Messages.msg("label.repulstionConstant"));
		
		JPanel controlPanel = new JPanel();
		controlPanel.setBorder(new TitledBorder(Messages.msg("label.control")));
		GroupLayout controlsLayout = new GroupLayout(controlPanel);
		controlsLayout.setHorizontalGroup(
				controlsLayout.createParallelGroup(Alignment.CENTER)
				.addComponent(dampingLabel,  GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)
				.addComponent(dampingSlider, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(coulombLabel,  GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)
				.addComponent(coulombSlider, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
		);
		
		controlsLayout.setVerticalGroup(
				controlsLayout.createSequentialGroup()
						.addComponent(dampingLabel)
						.addComponent(dampingSlider)
						.addComponent(coulombLabel)
						.addComponent(coulombSlider)
		);
		controlPanel.setLayout(controlsLayout);
		
		btnSkt = new JButton("S\u0101kt");
		btnSkt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				toogleSaktButtonOff();
				startGraphComputations();
			}
		});
		
		btnStop = new JButton(Messages.msg("label.startStop"));
		btnStop.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				if(computation != null){
					if(paused){
						startGraphComputations();
						paused = false;
					}else if(!computation.isDone()){
						computation.cancel(true);
						paused = true;
					}
				}
			}
		});
		
		JMenuItem menuItem;
		MenuListener menuListener = new MenuListener();
		popupMenu = new JPopupMenu();
	    menuItem = new JMenuItem("Delete node");
	    menuItem.addActionListener(menuListener);
	    popupMenu.add(menuItem);
	    menuItem = new JMenuItem("Add new node");
	    menuItem.addActionListener(menuListener);
	    popupMenu.add(menuItem);
	    menuItem = new JMenuItem("Add neighbor node");
	    menuItem.addActionListener(menuListener);
	    popupMenu.add(menuItem);
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.RELATED, 10, 39)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addGroup(groupLayout.createSequentialGroup()
								.addGap(100)
								.addComponent(btnSkt, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(groupLayout.createSequentialGroup()
								.addGap(100)
								.addComponent(btnStop, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addComponent(controlPanel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(19))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGap(36)
							.addComponent(btnSkt)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnStop)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(controlPanel,GroupLayout.DEFAULT_SIZE,GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)))
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);

        addMenuBar();
		
		setJMenuBar(menuBar);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		setVisible(true);
		this.setTitle("Graph");
		
		setIconImage(ImageLoader.getDefaultIcon().getImage());
		
		initNodes();
	}

    private void addMenuBar() {
        menuBar = new JMenuBar();
        JMenu menu = new JMenu("File");
        menuBar.add(menu);

        menuRestart = new JMenuItem("No sakuma");
        menuRestart.addActionListener(this);
        menu.add(menuRestart);

        menuUpload = new JMenuItem("Nomainit bilditi");
        menuUpload.addActionListener(this);
        menu.add(menuUpload);

        menuExit = new JMenuItem("Exit");
        menuExit.addActionListener(this);
        menu.add(menuExit);

        JMenu loadImpulssMenu = new JMenu(Messages.msg("manu.impulss"));
        menuBar.add(loadImpulssMenu);

        xmlUpload = new JMenuItem(Messages.msg("menu.impulss.xmlUpload"));
        xmlUpload.addActionListener(this);
        loadImpulssMenu.add(xmlUpload);
    }

    public void initNodes(){
		int maxX = panel.getWidth() - 1;
		int maxY = panel.getHeight() - 1;
		graph.setDimensions(maxX, maxY);
		graph.initGraph();
	}
	
	private void startGraphComputations(){
		computation = new GraphComputation();
		computation.execute();
	}
	
	private void restartFromCopy(){
		graph = (Graph)DeepCopy.copy(copy);
		panel.setGraph(graph);
	}
	
	public class GraphComputation extends SwingWorker<Void,Boolean>{

		@Override
		protected Void doInBackground() throws Exception {
			while(graph.calculateEnergy() > Force.MIN_FORCE){
				publish(true);
				Thread.currentThread();
				Thread.sleep(20);
			}
			return null;
		}
		
		public void process(List<Boolean> whoCares){
			panel.repaint();
		}
	}

	class PanelMouseListener implements MouseListener{
		final static double RADIUS = 10.0;
		boolean wasMenuShowing = false;
		
		@Override
		public void mouseClicked(MouseEvent ev) {
			if (ev.getButton() == MouseEvent.BUTTON3) {
				maybeShowPopup(ev);
			}
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent ev) {
			if (ev.getButton() == MouseEvent.BUTTON1 && !graph.getAddSelected()) {
				int x = ev.getX();
				int y = ev.getY();
				graph.selectNode(x, y);
			}
			wasMenuShowing = false;
		}

		@Override
		public void mouseReleased(MouseEvent ev) {
			if (ev.getButton() == MouseEvent.BUTTON1 && !wasMenuShowing) {
				if (graph.isNodeSelected() && computation != null) {
					int x = ev.getX();
					int y = ev.getY();
					boolean wasStarted = false;
					if (!computation.isDone()) {
						computation.cancel(true);
						wasStarted = true;
					}
					
					if(graph.getAddSelected()){
						graph.addThisToSelected(x, y);
						graph.setAddSelected(false);
						panel.repaint();
					}else{
						graph.moveSelectedNode(x, y);
					}
					
					
					if (wasStarted) {
						startGraphComputations();
					}
					graph.deselectNode();
				}
			}else if(ev.getButton() == MouseEvent.BUTTON3) {
				maybeShowPopup(ev);
				wasMenuShowing = true;
			}
		}
		
		
	    private void maybeShowPopup(MouseEvent ev) {
	        if (ev.isPopupTrigger() && graph.selectNode(ev.getX(), ev.getY())) {
	            popupMenu.show(ev.getComponent(),
	                       ev.getX(), ev.getY());
	        }
	    }
	}
	
	class MenuListener implements ActionListener {
		
		public void actionPerformed(ActionEvent ev) {
			switch(((JMenuItem) ev.getSource()).getText()){
			case "Delete node":
				graph.deleteSelectedNode();
				break;
			case "Add new node":
				Random rand = new Random();
				graph.addNodeToSelected(rand.nextInt(100));
				break;
			case "Add neighbor node":
				graph.setAddSelected(true);
				break;
			}
			panel.repaint();
		}
	}
	
	class SliderListener implements ChangeListener{
		
		@Override
		public void stateChanged(ChangeEvent ev) {
			JSlider slider = (JSlider) ev.getSource();
			int value = slider.getValue();
			if (slider ==  dampingSlider){
				Force.setDamping(value / 100.0);
			} else if ( slider == coulombSlider){
				Force.setCoulomb(value);
			}
		}	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == menuExit){
			System.exit(0);
			
		}else if(e.getSource() == menuRestart){
			paused = false;
			toogleSaktButtonOn();
			if (computation != null && !computation.isDone()){
				computation.cancel(true);
			}
			restartFromCopy();
			initNodes();
			panel.repaint();
			
		}else if(e.getSource() == menuUpload){
			if (computation != null && !computation.isDone()) {
				computation.cancel(true);
			}
			JFileChooser fileChooser = new JFileChooser();
			int returnVal = fileChooser.showOpenDialog(this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				ImageIcon icon = imLoader.loadImage(file.getPath());
				panel.setIcon(icon);
			}
			startGraphComputations();
		}else if(e.getSource() == xmlUpload){
            if (computation != null && !computation.isDone()) {
                computation.cancel(true);
            }
            JFileChooser fileChooser = new JFileChooser();
            int returnVal = fileChooser.showOpenDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                Graph xmlGraph = xmlParser.createGraph(file);
                this.graph = xmlGraph;
                panel.setGraph(xmlGraph);
                initNodes();
                panel.repaint();

                paused = false;
                toogleSaktButtonOn();
                if (computation != null && !computation.isDone()){
                    computation.cancel(true);
                }
            }
        }
		
	}
}