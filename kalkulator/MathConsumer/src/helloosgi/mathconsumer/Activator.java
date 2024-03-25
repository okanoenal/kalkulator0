package helloosgi.mathconsumer;

import helloosgi.mathservice.MathService;
import helloosgi.utils.MathUtils;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import java.awt.EventQueue;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Activator implements BundleActivator {

    private static BundleContext context;

    static BundleContext getContext() {
        return context;
    }

    public void start(BundleContext bundleContext) throws Exception {
        Activator.context = bundleContext;
        System.out.println("MathConsumer Starting...");

        
        ServiceReference<?> serviceReference = context
                .getServiceReference(MathService.class);
        MathService service = (MathService) context
                .getService(serviceReference);

    EventQueue.invokeLater(new Runnable(){
    	public void run() {
    		JFrame frame = new JFrame("Kalkulator");
    		frame.setSize(900,600);
    		frame.setVisible(true);
    		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    		frame.setLayout(null);
    		
    		JLabel label1 = new JLabel("Birinci Sayı: ");
    		label1.setBounds(50,50,100,25);
    		frame.add(label1);
    		
    		final JTextField entry1 = new JTextField(10);
    		entry1.setBounds(135,50,600,25);
    		frame.add(entry1);
    		
    		JLabel label2 = new JLabel("İkinci Sayı: ");
    		label2.setBounds(50,100,100,25);
    		frame.add(label2);
    		
    		final JTextField entry2 = new JTextField(10);
    		entry2.setBounds(135,100,600,25);
    		frame.add(entry2);
    		
    		JLabel label3 = new JLabel("Sonuç: ");
    		label3.setBounds(50,150,100,25);
    		frame.add(label3);
    		
    		final JTextField entry3 = new JTextField(10);
    		entry3.setBounds(135,150,600,25);
    		frame.add(entry3);

    		JButton add_button = new JButton("Topla");
    		add_button.setBounds(50,200,100,25);
    		frame.add(add_button);
    		
    		JButton sub_button = new JButton("Çıkar");
    		sub_button.setBounds(160,200,100,25);
    		frame.add(sub_button);
    		
    		JButton mult_button = new JButton("Çarp");
    		mult_button.setBounds(265,200,100,25);
    		frame.add(mult_button);
    		
    		JButton div_button = new JButton("Böl");
    		div_button.setBounds(375,200,100,25);
    		frame.add(div_button);
    		
    		add_button.addActionListener(new ActionListener(){
    			public void actionPerformed(ActionEvent ae){
    				
    				long sonuc = service.WordToNum( entry1.getText()) + service.WordToNum( entry2.getText());
    				entry3.setText(service.NumToWord(sonuc));
    			}			
    		});
    		
    		
    		sub_button.addActionListener(new ActionListener(){
    			public void actionPerformed(ActionEvent ae){
    				
    				long sonuc = service.WordToNum( entry1.getText()) - service.WordToNum( entry2.getText());
    				entry3.setText(service.NumToWord(sonuc));
    			}			
    		});
    		
    		
    		mult_button.addActionListener(new ActionListener(){
    			public void actionPerformed(ActionEvent ae){
    				
    				long sonuc = service.WordToNum( entry1.getText()) * service.WordToNum( entry2.getText());
    				entry3.setText(service.NumToWord(sonuc));
    			}			
    		});
    		
    		div_button.addActionListener(new ActionListener(){
    			public void actionPerformed(ActionEvent ae){
    				
    				long sonuc = service.WordToNum( entry1.getText()) / service.WordToNum( entry2.getText());
    				if((service.WordToNum( entry1.getText())) % (service.WordToNum(entry2.getText())) != 0) {
						entry3.setText("Tam bölünemez! / Result is not an integer!");}
    				
    				else
    					entry3.setText(service.NumToWord(sonuc));
    				
    			}
    		
    			
    		});
    		if(service.locale().equals("English")) {
    			entry1.setBounds(150,50,600,25);
    			entry2.setBounds(150,100,600,25);
    			entry3.setBounds(150,150,600,25);
    			label1.setText("First Number: ");
    			label2.setText("Second Number: ");
    			label3.setText("Answer: ");
    			add_button.setText("Add");
    			sub_button.setText("Subtract");
    			mult_button.setBounds(265,200,120,25);
    			mult_button.setText("Multiplication");
    			div_button.setBounds(390,200,100,25);
    			div_button.setText("Divide");
    		}
    		
    		
    	}
    	});
    
    }

    public void stop(BundleContext bundleContext) throws Exception {
        Activator.context = null;
        System.out.println("MathConsumer Stopped");
    }

}