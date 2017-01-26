import java.awt.*;
import java.awt.event.*;
//import java.sql.Connection;
//import java.sql.Date;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Time;
//import java.util.Calendar;

//import java.sql.Statement;
import java.io.*;
import java.net.*;


public class ControleRemoto extends Frame implements ActionListener, WindowListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1531263942178058865L;
	Button bActivar;
	//Time tTime;
	Socket sCliente;
	TextField tfSenha;
	//TextArea texto;
	Label lErro;
	//Connection conexao;
	public ControleRemoto(){
		setTitle("Controle Remoto Portão.");
		setLocation(50,50);
		setSize(300,100);
		lErro    = new Label();
		//texto    = new TextArea();
		tfSenha  = new TextField(6);		
		tfSenha.addActionListener(this);
		tfSenha.setEchoChar('*');
		add(tfSenha);
		add(bActivar = new Button("Ativar"),BorderLayout.SOUTH);
		add(lErro);
		//add(texto);
		//setTitle(TesteMarcelo.pegaTotal());
		bActivar.addActionListener(this);
		bActivar.setLocation(0, 100);		
		tfSenha.addKeyListener(new KeyAdapter() {  
	            public void keyPressed(final KeyEvent e) {  
	                int key = e.getKeyCode();  
	                if (key == KeyEvent.VK_ENTER) {  
	                    Ativar();  
	                }  
	            } 
	            
	            
	        });
		addWindowListener(this);
		setLayout(new FlowLayout());
		
		/*try {
			conexao = DriverManager.getConnection(
			          "jdbc:mysql://localhost/Marcelo","root","mar0403");
			//lErro.setText("MySQL Conectado!");
			texto.append("MySQL Conectado!\n");			
			Statement stmt = conexao.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM USER");
			while (rs.next()){
				texto.append(rs.getString("Nome")+"\n");
				
			}
			
			//conexao.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		pack();
		/*Contato contato = new Contato();
		contato.setEmail("marcelodossantosmariano@gmail.com");
		contato.setDataNascimento(Calendar.getInstance());
		contato.setEndereco("Cyro Vellozo 56 ,Prado Velho Curitiba-PR");
		contato.setId(1L);
		contato.setNome("Marcelo dos Santos Mariano");
		new ContatoDao().adiciona(contato);*/
		
	}
	public void teste(Object[] e){
		
	}
	@SuppressWarnings("deprecation")
	public static void main(String args[]){
		ControleRemoto f = new ControleRemoto();
		f.show();		
	}
	public void windowClosing(WindowEvent e) {
	System.exit(0);	
	}
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void Ativar()
	{
		try {
			if(tfSenha.getText().compareTo("1234") == 0)
			{
				sCliente = new Socket("192.168.0.14",81);
				PrintWriter out = new PrintWriter(
                    new BufferedWriter(new OutputStreamWriter(
                            sCliente.getOutputStream())), true);
				setTitle("Acionando");
				out.println("act");
				out.close();
			}
			else {
				setTitle("Senha incorreta!");}
			tfSenha.setText("");
		}
		catch(Exception eScoket)
		{
			setTitle(eScoket.getMessage());
		}
		try {
			Thread.sleep(1000);
			setTitle("Controle Remoto Portão.");
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//System.exit(0);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if (e.getSource() == bActivar )
		{
			Ativar();
		}
		
	}
	public static class TesteMarcelo{
		private static final int iTotal = 10;

		public static String pegaTotal(){
			return String.valueOf(iTotal);
		}
		
	}
	/*public class ContatoDao {

		 

		   // a conexão com o banco de dados
		   private Connection connection;
		   public ContatoDao() {
		     this.connection = new ConnectionFactory().getConnection();

		   }
		   public void adiciona(Contato contato) {

			     String sql = "insert into contatos " +
			             "(nome,email,endereco,dataNascimento)" +
			             " values (?,?,?,?)";
			     try {

			         // prepared statement para inserção

			         PreparedStatement stmt = connection.prepareStatement(sql);
			         // seta os valores
			         stmt.setString(1,contato.getNome());
			         stmt.setString(2,contato.getEmail());
			         stmt.setString(3,contato.getEndereco());
			         stmt.setDate(4, new Date(
			                 contato.getDataNascimento().getTimeInMillis()));
			         stmt.execute();
			         stmt.close();

			     } catch (SQLException e) {

			         throw new RuntimeException(e);

			     }

			 }
		   
	}*/
	
	/*public class ConnectionFactory {
	    public Connection getConnection() {
	        try {
	            return DriverManager.getConnection(
	          "jdbc:mysql://localhost/Marcelo", "root", "mar0403");
	        } catch (SQLException e) {
	            throw new RuntimeException(e);
	        }
	    }
	}*/
	/*public class Contato {

		   private Long id;
		   private String nome;
		   private String email;
		   private String endereco;
		   public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getEndereco() {
			return endereco;
		}
		public void setEndereco(String endereco) {
			this.endereco = endereco;
		}
		public Calendar getDataNascimento() {
			return dataNascimento;
		}
		public void setDataNascimento(Calendar dataNascimento) {
			this.dataNascimento = dataNascimento;
		}
		private Calendar dataNascimento;

		 }*/
}