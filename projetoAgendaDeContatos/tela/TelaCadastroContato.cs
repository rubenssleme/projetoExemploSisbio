using projetoAgendaDeContatos.controlador;
using projetoAgendaDeContatos.persistencia;
using System;
using System.Windows.Forms;

namespace projetoAgendaDeContatos
{
    public partial class TelaCadastroContato : Form
    {
        //Instanciar a classe conexao
        Conexao conexao = new Conexao();
        ControladorTelaContato controladorTelaContato;
       
        public TelaCadastroContato()
        {
            InitializeComponent();
            controladorTelaContato = new ControladorTelaContato(txtNome,txtEndereco,txtEmail,mskTelefone);
        }     

        private void btnTestarConexao_Click(object sender, EventArgs e)
        {
            conexao.abrirConexao();
            if (conexao.testarConexao())
            {
                MessageBox.Show("Conectado com sucesso!!");
            }
            else
            {
                MessageBox.Show(" Não foi possivel conectado com o banco de dados!!");
            }
        }
       
        private void btnSalvarContato_Click(object sender, EventArgs e)
        {
            controladorTelaContato.salvarContato();
        }
    }
}
