using projetoAgendaDeContatos.dominio;
using projetoAgendaDeContatos.repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace projetoAgendaDeContatos.controlador
{
    class ControladorTelaContato
    {
        //Instancia ou declaração a classe contato 
        Contato contato;
        RepositorioContato repositorioContato = new RepositorioContato();

        private TextBox txtNome;
        private TextBox txtEndereco;
        private TextBox txtEmail;
        private MaskedTextBox mskTelefone;

        public ControladorTelaContato(TextBox txtNome, TextBox txtEndereco, TextBox txtEmail, MaskedTextBox mskTelefone)
        {
            this.txtNome = txtNome;
            this.txtEndereco = txtEndereco;
            this.txtEmail = txtEmail;
            this.mskTelefone = mskTelefone;
        }
        private void inicializarObjeto()
        {
            contato = new Contato();
            contato._id = 1;
            contato._nome = txtNome.Text;
            contato._endereco = txtEndereco.Text;
            contato._eMail = txtEmail.Text;
            contato._telefone = mskTelefone.Text;
          
        }

        public void salvarContato()
        {
            inicializarObjeto();
            if (repositorioContato.Incluir(contato))
            {
                MessageBox.Show("Cliente incluido com sucesso!");
            }
            else
            {
                MessageBox.Show("O Cliente não pode ser incluido!");
            }


        }

    }
}
