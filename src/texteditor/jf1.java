/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package texteditor;



import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Toolkit;
import static java.awt.Toolkit.getDefaultToolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.util.*;
import java.lang.StringBuffer;
import static java.lang.Thread.sleep;
import java.text.AttributedCharacterIterator;
import java.util.jar.Attributes;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.JTextComponent;
import javax.swing.undo.UndoManager;
/**
 *
 * @author joey
 */
public class jf1 extends javax.swing.JFrame {
String filename;
int saved=0;
String array1[]=new String[10000000];
 int array2[]=new int[10000000];
Clipboard clip1=getToolkit().getSystemClipboard();
Dimension dm1=getDefaultToolkit().getScreenSize();    
/**
     * Creates new form jf1
     */
    public jf1(String path) {
        this.setTitle(path);
        this.getContentPane().setBackground(new Color(255,255,255));
     UndoManager um;
     
    if(isFirstUse())
    {boolean nb =new File("Data").mkdir();
  
    }
        flush();
        initComponents();
        
        load(path);
        this.setDefaultLookAndFeelDecorated(true);
        th();
         this.setLocationRelativeTo(null);//to make the application appear int the centre
         this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("Untitled.png")));
        
    }
  
    boolean isFirstUse()
    {try{
        File file=new File("first.mg42");
        if(!file.exists()){
    file.createNewFile();return true;}
        else{
         
            return false;
        }}
catch(Exception d){return false;}
    }
   void load(String r)
   {try{
   Scanner sc=new Scanner(new File(r));
   String brw="";
   while(sc.hasNext())
   {String k=sc.nextLine()+"\n";brw+=k;}
   jt1.setText(brw);
   sc.close();filename=r;fo=1;ogtext=brw;
   }
   catch(Exception e){noinitial=1;savedone=0;}
   }
   
   String open(String filename)
   {String txt="";
    try { 
        Scanner  sc=new Scanner(new File(filename));
        
        while(sc.hasNext())
        {
        txt+=sc.nextLine()+"\n";
        }
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(this,ex.toString());
    }
       
       
       return txt;}
   
   int savedone=0;
   int noinitial=0;
   String EverythingAlright()
   {
   //is file opened//is yes then have changes been made//if yes the  return true
       if(fo==1&&!(ogtext.equals(jt1.getText())))
       return "1";
       else if(this.getTitle().equals(savedfile)&&open(savedfile).equals(savedtext))//changes have been made to a saved file
       return "changes made 2";
       else if(noinitial==1&&(jt1.getText().length()!=0)&&savedone==0)
       return "2";
       //or
       //you have written something and not saved file
   
   else
           return "ALL";
   
 
   }
void th(){
 
    this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    this.addWindowListener(new java.awt.event.WindowAdapter() {
        
    @Override
    public void windowClosing(WindowEvent windowEvent) {
     //do the stuff you want to   
     String t1=EverythingAlright();
             if(t1.equals("1")){
              int d=   JOptionPane.showConfirmDialog(rootPane, "Do you want to save the changes\nmade to the file \n"+filename);
           if(d==0)
           {save(filename);
           System.exit(0);
           }
           else if(d==1){
           
           System.exit(0);
           }
           
           
             }
             else if(t1.equals("2")){
    int k= JOptionPane.showConfirmDialog(rootPane, "Do you want to save the\nuntitled document");
    if(k==0){
    JFileChooser jfc=new JFileChooser();
    int d=jfc.showSaveDialog(rootPane);
    if(d==JFileChooser.APPROVE_OPTION){
        try{
    BufferedWriter bwr=new BufferedWriter(new FileWriter(jfc.getSelectedFile()));
    bwr.write(getNormalisedText(jt1.getText()));
    bwr.close();
    System.exit(0);
        }catch(Exception e){JOptionPane.showMessageDialog(rootPane, e.toString());}
    }
    
    
    }
    else if(k==1){System.exit(0);}
             }
             else if(t1.equals("ALL")){System.exit(0);}
            }
            });
}
void save(String filename)//to save the file currently in use; 
{

String tx=jt1.getText();
tx=getNormalisedText(tx);
try{
BufferedWriter brw= new BufferedWriter(new FileWriter(filename));
brw.write(tx);
brw.close();
}
catch(Exception e){
JOptionPane.showMessageDialog(rootPane, e.toString());

}

}

/**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jt1 = new javax.swing.JTextArea();
        jef1 = new javax.swing.JTextField();
        jb1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jt1.setColumns(20);
        jt1.setRows(5);
        jt1.setToolTipText("Write here");
        jt1.setBorder(null);
        jt1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jt1MouseClicked(evt);
            }
        });
        jt1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jt1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jt1KeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(jt1);

        jef1.setForeground(new java.awt.Color(153, 153, 153));
        jef1.setText("eg <Hello World>");
        jef1.setToolTipText("Type the word you want to search");
        jef1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jef1FocusLost(evt);
            }
        });
        jef1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jef1MouseClicked(evt);
            }
        });
        jef1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jef1ActionPerformed(evt);
            }
        });
        jef1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jef1KeyTyped(evt);
            }
        });

        jb1.setBackground(new java.awt.Color(255, 255, 255));
        jb1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jb1.setText("Search");
        jb1.setToolTipText("Search for a word/word sequence in the text");
        jb1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jb1ActionPerformed(evt);
            }
        });

        jMenu1.setText("File");
        jMenu1.setToolTipText("Options Related to text file");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem1.setText("New");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem3.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem3.setText("Open");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));
        jMenuItem2.setText("Save");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem4.setText("Save as");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem11.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem11.setText("Read Text");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem11);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenu2.setToolTipText("Text Editing tools");

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem5.setText("Cut");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem5);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem6.setText("Copy");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem6);

        jMenuItem9.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem9.setText("Paste");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem9);

        jMenuItem13.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem13.setText("Undo");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem13);

        jMenuItem12.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem12.setText("Font");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem12);

        jCheckBoxMenuItem1.setText("Dark Theme");
        jCheckBoxMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jCheckBoxMenuItem1);

        jMenuBar1.add(jMenu2);

        jMenu4.setText("Tools");

        jMenuItem14.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, java.awt.event.InputEvent.SHIFT_MASK));
        jMenuItem14.setText("Compile and Run(python)");
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem14);

        jMenuBar1.add(jMenu4);

        jMenu3.setText("View");
        jMenu3.setToolTipText("Developer info and advanced tools");

        jMenuItem7.setText("Word Count");
        jMenuItem7.setToolTipText("Show the total Number of Words");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem7);

        jMenuItem10.setText("Word Frequency");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem10);

        jMenuItem8.setText("Developer info.");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem8);

        jMenuBar1.add(jMenu3);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jef1, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jb1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jef1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jb1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 382, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
String savedtext;String savedfile;
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        
        
        
        
       savedtext= jt1.getText();
       savedfile=filename;
      try{  
       String t=jt1.getText();
       File newfile=new File(filename);
       BufferedWriter br=new BufferedWriter(new FileWriter(newfile));
       br.write(getNormalisedText(t));
       br.close();
      }
      catch(Exception e){JOptionPane.showMessageDialog(this, e.toString());}
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        jt1.setText("");
        this.setTitle("");
        noinitial=1;
        savedone=0;
        fo=0;
        ogtext="";
    }//GEN-LAST:event_jMenuItem1ActionPerformed
int fo=0;
String ogtext;
    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
   
   
        
        try {
        // TODO add your handling code here:
        FileDialog fd=new FileDialog(jf1.this,"load File",FileDialog.LOAD);
        fd.setVisible(true);
        if(fd.getFile()!=null)
        { fo=1;
            filename=fd.getDirectory()+fd.getFile();
            setTitle(filename);
        }
        Scanner scd=new Scanner(new File(fd.getDirectory()+fd.getFile()));
        
        String txt="";
        while(scd.hasNext())
        {
            String g=scd.nextLine()+"\n";
            txt=txt+g;
        }
        jt1.setText(txt);noinitial=0;
        ogtext=txt;
    } catch (Exception ex) {
        Logger.getLogger(jf1.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    String getNormalisedText(String text)
{
Scanner scb=new Scanner(text);
String buffer="";
while(scb.hasNext())
{
    buffer+=scb.nextLine()+"\r\n";
    
}

return buffer;
}
    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
       if(noinitial==1)
       {savedone=1;}
        JFileChooser rw=new JFileChooser();
        int val=rw.showSaveDialog(this);
        if(val==JFileChooser.APPROVE_OPTION){
      try{
        File f=rw.getSelectedFile();
        filename=f.getAbsolutePath();
       BufferedWriter tr=new BufferedWriter(new FileWriter(f));
       
       tr.write(getNormalisedText(jt1.getText()));
       tr.close();
        
      }
      catch(Exception e){System.out.println("ERROR!");}
        
        }
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jef1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jef1ActionPerformed
        // TODO add your handling code here:
        
 
        
    
    
    }//GEN-LAST:event_jef1ActionPerformed

    int ck=1;
    class high extends DefaultHighlighter.DefaultHighlightPainter
    {
    public high(Color color)
    {super(color);}
    }
    
    
    DefaultHighlighter.HighlightPainter highlighter=new high(Color.yellow);
    public void searchtextArea(JTextArea comp,String text)
    {ck=0;
        removeHighlighter(jt1);
    try
    {
        Highlighter highlight=comp.getHighlighter();
        Document doc=comp.getDocument();
        String text1= doc.getText(0, doc.getLength());
        int pos=0;
        while((pos=text1.toUpperCase().indexOf(text.toUpperCase(),pos))>=0)
        {
        highlight.addHighlight(pos, pos+text.length(), highlighter);
        pos+=text.length();
        }
    }
    catch(Exception e){}
    }
    public void removeHighlighter(JTextComponent textcomp)
    {
    Highlighter removeHighlighter=textcomp.getHighlighter();
    removeHighlighter.removeAllHighlights();
    Highlighter.Highlight[] remove=removeHighlighter.getHighlights();
    for(int i=0;i<remove.length;i++)
    {
    if(remove[i].getPainter() instanceof Highlighter)
    {
    removeHighlighter.removeHighlight(i);
    }
    }
    
    
    }
    private void jb1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jb1ActionPerformed
String word=jef1.getText();
word=word.trim();
if(!(word.length()==0))
{
searchtextArea(jt1,word);
    }
        
        
    }//GEN-LAST:event_jb1ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        String cut=jt1.getSelectedText();
        StringSelection ss=new StringSelection(cut);
        clip1.setContents(ss, ss);
        jt1.replaceRange("", jt1.getSelectionStart(), jt1.getSelectionEnd());
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // Calling the static function called showMessageDialog
        JOptionPane.showMessageDialog(this,"Made By Akshat Mishra\nEditor++ v 1.0");
        
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        String text=jt1.getText();
        Scanner scr=new Scanner(text.trim());int c=0;
       while(scr.hasNext()){
       StringTokenizer st= new StringTokenizer(scr.nextLine(),".!? ");
     
       
   while(st.hasMoreTokens())
   {
   
   String word=Filter(st.nextToken());
   System.out.println(word.trim());
   if(word.trim().length()>0)
       c=c+g;
   }
     
       }
       
       JOptionPane.showMessageDialog(this, "Total number of words: "+c);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        
        String cop=jt1.getSelectedText();
        StringSelection sss=new StringSelection(cop);
        clip1.setContents(sss, sss);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
    try {
        // TODO add your handling code here:
        jt1.replaceRange(clip1.getContents(jf1.this).getTransferData(DataFlavor.stringFlavor).toString(), jt1.getSelectionStart(), jt1.getSelectionEnd());
    } catch (UnsupportedFlavorException ex) {
        Logger.getLogger(jf1.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IOException ex) {
        Logger.getLogger(jf1.class.getName()).log(Level.SEVERE, null, ex);
    }
    }//GEN-LAST:event_jMenuItem9ActionPerformed
void savevalue(int value)
{try{
BufferedWriter bwr=new BufferedWriter(new FileWriter(new File("Data/config.conf")));
bwr.write(""+value);
bwr.close();
}
catch(Exception e)
{}
}
int retrieve()
{try{
Scanner sc=new Scanner(new File("Data/config.conf"));
int d=Integer.parseInt(sc.nextLine().trim());
return d;
}
catch(Exception e){return -2;}

}


String Filter(String word)
{
    String em="";
    for(int i=0;i<word.length();i++)
    {
        char c=word.charAt(i);
        int word1=(int)c;
        if((c>=65&&c<=90)||(c>=97&&c<=122))
        {
        em+=c;
        }
    }
    
    
    
    
    
    
    
    return em;}
    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
     int value=0;
     int rv=retrieve();   
     if(rv==-2||rv==1||rv==2||rv==-1)
        {
         value=JOptionPane.showConfirmDialog(this, "This is an experimental feature and the results might be incorrect.\nClick Yes to never see this dialog again , otherwise click No\n click cancel to close.");
        savevalue(value);
        }
        if(!(value==2)||value!=-1)       
     {
     
        String txt=jt1.getText();
        String em="";
        Scanner sc=new Scanner(txt);
        while(sc.hasNext())
        {
            em+=sc.nextLine().trim()+" ";
            
        }
        StringTokenizer rw=new StringTokenizer(em,".!? ");
        while(rw.hasMoreTokens()){
        ispresent(Filter(rw.nextToken()));
        }
    String dxr="";
        int yy=0;
        for(int k:array2)
        {if(!(array1[yy].equals("")))
           dxr+=array1[yy++]+" "+k+"\n";  
        
        }
       
        frequencyreport fr1=new frequencyreport(dxr,dark);
        
        fr1.setVisible(true);
       flush();
        
     }  
    }//GEN-LAST:event_jMenuItem10ActionPerformed
public void flush()
{//intiates and clears the array for processing word frequency
     for(int i=0;i<10000000;i++)
        {array1[i]="";array2[i]=0;}
     for(int kk=0;kk<100000;kk++)
         unretext[kk]="";
}
    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
JOptionPane.showMessageDialog(this,"This feature is available in the pro\nversion of this app");
        // TODO add your handling code here:
   
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jt1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jt1MouseClicked
        // TODO add your handling code here:
        if(ck!=1)
        removeHighlighter(jt1);
    }//GEN-LAST:event_jt1MouseClicked
String unretext[]=new String[100000];
    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        // TODO add your handling code here:
     System.out.println(jt1.getFont().getSize2D());
         NewJFrame nfr=new NewJFrame(this,jt1.getFont(),dark);
         
        Font g=nfr.fonty;
        if(g==null)
            jt1.setFont(jt1.getFont());
        else
        {System.out.print(g);
       
       
        jt1.setFont(g);}
    }//GEN-LAST:event_jMenuItem12ActionPerformed
int c=1;
 void commandput(){
     
 unretext[c++]=jt1.getText();
 
}
    private void jt1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt1KeyTyped
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_jt1KeyTyped
int g=1;
    void doer()
{
jt1.setText(unretext[c-g]);
System.out.println(unretext[c-g]);
g=g+2;
}
    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        // TODO add your handling code here:
     
      
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jt1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jt1KeyPressed
        // TODO add your handling code here:
      
    }//GEN-LAST:event_jt1KeyPressed

    private void jef1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jef1MouseClicked
        // TODO add your handling code here:
        if(switch1==0){
         jef1.setText("");
         jef1.setForeground(Color.BLACK);}
    }//GEN-LAST:event_jef1MouseClicked
int switch1=0;
    private void jef1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jef1KeyTyped
        // TODO add your handling code here:
        
        switch1=1;
        
    }//GEN-LAST:event_jef1KeyTyped

    private void jef1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jef1FocusLost
        // TODO add your handling code here:
        if(jef1.getText().trim().length()==0)
        {jef1.setForeground(new Color(153,153,153));
        jef1.setText("eg <Hello World>");switch1=0;
        }
   
    }//GEN-LAST:event_jef1FocusLost
int dark=0;Color co=Color.yellow;
    private void jCheckBoxMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem1ActionPerformed
        // TODO add your handling code here:
        
        if(dark==0){
        jt1.setBackground(new Color(51,51,51));
        jt1.setSelectionColor(new Color(153,0,0));
        jt1.setForeground(new Color(153,153,153));
       this.getContentPane().setBackground(new Color(60,60,60));
       UIDefaults uidefaults=UIManager.getDefaults();
       uidefaults.put("activeCaption", new ColorUIResource(new Color(53,53,53)));
       uidefaults.put("activeCaptionText", new ColorUIResource(new Color(153,153,153)));
       this.setDefaultLookAndFeelDecorated(true);
        co=new Color(153,0,0);dark=1;}
        else if(dark==1)
        {
        
        jt1.setBackground(new Color(255,255,255));
        jt1.setSelectionColor(new Color(0,210,215));
        jt1.setForeground(new Color(0,0,0));this.getContentPane().setBackground(new Color(255,255,255));
        dark=0;
        }
    }//GEN-LAST:event_jCheckBoxMenuItem1ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        // TODO add your handling code here
        try{
    BufferedWriter bwr=new BufferedWriter(new FileWriter("temp.py"));
    bwr.write(jt1.getText());
    bwr.close();
    File f=new File("temp.py");
  Process p=  Runtime.getRuntime().exec("rundll32 SHELL32.DLL,ShellExec_RunDLL "+f.getAbsolutePath());
  
  
 
        }
        catch(Exception e){
            
            JOptionPane.showMessageDialog(this,e);}
    }//GEN-LAST:event_jMenuItem14ActionPerformed
 void ispresent(String tok)
{
    
    
for(int i=0;i<1000000;i++)
{
    
     if(array1[i].equalsIgnoreCase(tok)){
     array2[i]+=1;break;
     }
     else if(array1[i].equalsIgnoreCase(""))
     {
         array1[i]=tok;
         array2[i]+=1;
         break;
     }
   
    }
}
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        String path1="";
     try{
        path1=args[0];
  }
  catch(Exception e){}
  final String pth=path1;
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(jf1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(jf1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(jf1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(jf1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new jf1(pth).setVisible(true);System.setProperty("sun.awt.noerasebackground","True");
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jb1;
    private javax.swing.JTextField jef1;
    public javax.swing.JTextArea jt1;
    // End of variables declaration//GEN-END:variables
}
