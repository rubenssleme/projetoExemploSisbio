using projetoAgendaDeContatos.dominio;
using projetoAgendaDeContatos.persistencia;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace projetoAgendaDeContatos
{
    public partial class TelaCadastroContato : Form
    {
       

        //Instanciar a classe conexao
        Conexao conexao = new Conexao();
        Contato contato; 

        public TelaCadastroContato()
        {
            InitializeComponent();
        }

        private void inicializarObjeto()
        {
            contato = new Contato();
            contato._id = 1;
            contato._nome = txtNome.Text;
            contato._endereco = txtEndereco.Text;
            contato._eMail = txtEmail.Text;
            contato._telefone = mskTelefone.Text;
                      
            MessageBox.Show(contato.ToString());
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
            inicializarObjeto();
        }
    }
}
